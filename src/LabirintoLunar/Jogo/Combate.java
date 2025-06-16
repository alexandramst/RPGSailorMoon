package LabirintoLunar.Jogo;

import LabirintoLunar.Entidades.Heroina;
import LabirintoLunar.Entidades.NPC;
import LabirintoLunar.Itens.Consumivel;
import LabirintoLunar.Itens.ConsumivelCombate;
import LabirintoLunar.Itens.Pocao;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe utilitária que gere a lógica de combate por turnos e o uso de poções durante a luta.
 */
public class Combate {

    /**
     * Realiza o combate por turnos entre uma heroína e um NPC inimigo.
     * O jogador pode escolher ataque normal, especial, usar consumível ou poção.
     *
     * @param heroina Heroína que combate.
     * @param inimigo Inimigo a combater.
     * @param scanner Scanner para input do utilizador.
     */
    public static void combateTurnos(Heroina heroina, NPC inimigo, Scanner scanner) {
        boolean ataqueEspecialUsado = false;
        while (heroina.estaViva() && inimigo.estaViva()) {
            System.out.println("\n--- Turno da Jogadora ---");
            imprimirMenuCombate(ataqueEspecialUsado);

            System.out.print("Escolhe uma opção: ");
            int escolha = scanner.nextInt();
            boolean passouTurno = false;

            if (escolha == 1) {
                // Ataque normal
                int dano = heroina.getForca();
                if (heroina.getArmaPrincipal() != null) {
                    dano = dano + heroina.getArmaPrincipal().getAtaque();
                }
                System.out.println("Atacaste com ataque normal! Dano: " + dano);
                inimigo.receberDano(dano);
            } else if (escolha == 2) {
                // Ataque especial (uma vez por combate, precisa de arma)
                if (!ataqueEspecialUsado && heroina.getArmaPrincipal() != null) {
                    int danoEspecial = heroina.getForca() + heroina.getArmaPrincipal().getAtaqueEspecial();
                    System.out.println("Atacaste com ataque ESPECIAL! Dano: " + danoEspecial);
                    inimigo.receberDano(danoEspecial);
                    ataqueEspecialUsado = true;
                } else if (ataqueEspecialUsado) {
                    System.out.println("Ataque especial já foi usado neste combate.");
                    passouTurno = true;
                } else {
                    System.out.println("Não tens arma principal equipada.");
                    passouTurno = true;
                }
            } else if (escolha == 3) {
                // Ataque com consumível de combate
                ArrayList<Consumivel> consumiveisCombate = new ArrayList<>();
                for (Consumivel c : heroina.getInventario()) {
                    if (c instanceof ConsumivelCombate) {
                        consumiveisCombate.add(c);
                    }
                }
                if (consumiveisCombate.isEmpty()) {
                    System.out.println("Não tens consumíveis de combate!");
                    passouTurno = true;
                } else {
                    System.out.println("Consumíveis de combate disponíveis:");
                    for (int i = 0; i < consumiveisCombate.size(); i++) {
                        ConsumivelCombate cc = (ConsumivelCombate) consumiveisCombate.get(i);
                        System.out.println((i + 1) + ". " + cc.getNome() + " (Ataque instantâneo: " + cc.getAtaqueInstantaneo() + ")");
                    }
                    System.out.print("Qual usar? (0 para cancelar): ");
                    int escolhaConsumivel = scanner.nextInt();
                    if (escolhaConsumivel <= 0 || escolhaConsumivel > consumiveisCombate.size()) {
                        System.out.println("Cancelaste o ataque com consumível.");
                        passouTurno = true;
                    } else {
                        ConsumivelCombate usado = (ConsumivelCombate) consumiveisCombate.get(escolhaConsumivel - 1);
                        System.out.println("Usaste " + usado.getNome() + "! Dano: " + usado.getAtaqueInstantaneo());
                        inimigo.receberDano(usado.getAtaqueInstantaneo());
                        heroina.getInventario().remove(usado);
                    }
                }
            } else if (escolha == 4) {
                usarPocao(heroina, scanner);
                passouTurno = true;
            } else {
                System.out.println("Opção inválida. Perdes o turno!");
                passouTurno = true;
            }

            // Verifica se o inimigo morreu
            if (!inimigo.estaViva()) {
                System.out.println("O inimigo foi derrotado!");
                break;
            }

            // Turno do inimigo (só se não passou turno)
            if (!passouTurno) {
                int danoInimigo = inimigo.getForca();
                heroina.receberDano(danoInimigo);
                System.out.println("O inimigo atacou! Dano: " + danoInimigo);
                if (!heroina.estaViva()) {
                    System.out.println("Foste derrotada!");
                }
            }
        }
    }

    /**
     * Imprime o menu de combate.
     * @param ataqueEspecialUsado True se o ataque especial já foi usado.
     */
    public static void imprimirMenuCombate(boolean ataqueEspecialUsado) {
        System.out.println("O que queres fazer?");
        System.out.println("1. Ataque Normal");
        if (ataqueEspecialUsado) {
            System.out.println("2. Ataque Especial (já usado)");
        } else {
            System.out.println("2. Ataque Especial");
        }
        System.out.println("3. Ataque com Consumível");
        System.out.println("4. Usar Poção");
    }

    /**
     * Permite ao jogador usar uma poção do inventário (cura vida e/ou força).
     * Só mostra poções, não consumíveis de combate.
     * @param heroina Heroína que pode usar poções.
     * @param scanner Scanner para input.
     */
    public static void usarPocao(Heroina heroina, Scanner scanner) {
        ArrayList<Consumivel> pocasDisponiveis = new ArrayList<>();
        for (Consumivel c : heroina.getInventario()) {
            if (c instanceof Pocao) {
                pocasDisponiveis.add(c);
            }
        }
        if (pocasDisponiveis.isEmpty()) {
            System.out.println("Não tens poções para usar!");
            return;
        }
        System.out.println("Poções disponíveis:");
        for (int i = 0; i < pocasDisponiveis.size(); i++) {
            Pocao p = (Pocao) pocasDisponiveis.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " - Cura: " + p.getCuraVida() + " - Força extra: " + p.getAumentoForca());
        }
        System.out.print("Qual poção queres usar? (0 para cancelar): ");
        int escolha = scanner.nextInt();
        if (escolha <= 0 || escolha > pocasDisponiveis.size()) return;
        Pocao pocao = (Pocao) pocasDisponiveis.get(escolha - 1);

        // Aplica cura, sem ultrapassar vida máxima
        int vidaAntes = heroina.getVidaAtual();
        int vidaMax = heroina.getVidaMax();
        int vidaFinal = vidaAntes + pocao.getCuraVida();
        if (vidaFinal > vidaMax) {
            vidaFinal = vidaMax;
        }
        int curaReal = vidaFinal - vidaAntes;
        heroina.setVidaAtual(vidaFinal);

        // Aplica aumento de força, se tiver
        if (pocao.getAumentoForca() > 0) {
            heroina.setForca(heroina.getForca() + pocao.getAumentoForca());
            System.out.println("Força aumentada em " + pocao.getAumentoForca() + "!");
        }
        System.out.println("Curaste " + curaReal + " de vida! Vida atual: " + heroina.getVidaAtual() + "/" + heroina.getVidaMax());
        if (curaReal < pocao.getCuraVida()) {
            System.out.println("A poção tinha mais cura, mas já estavas perto da vida máxima.");
        }
        heroina.getInventario().remove(pocao);
    }
}