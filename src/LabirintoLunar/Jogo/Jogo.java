package LabirintoLunar.Jogo;

import LabirintoLunar.Entidades.*;
import LabirintoLunar.Itens.Consumivel;
import LabirintoLunar.Itens.Pocao;
import LabirintoLunar.Enum.DificuldadeJogo;
import LabirintoLunar.Enum.Direcao;
import LabirintoLunar.Enum.TipoEvento;

import java.util.*;

/**
 * Classe principal que gere todo o ciclo do RPG "Labirinto Lunar".
 * Faz a ligação entre o labirinto, combate, vendedor, sorteio de eventos e fluxo do jogo.
 */
public class Jogo {

    private Heroina heroina;
    private DificuldadeJogo dificuldadeSelecionada;
    private Labirinto labirinto;
    private Vendedor vendedor;
    private ArrayList<NPC> inimigosDisponiveis;
    private Random random;

    /**
     * Construtor. Inicializa o labirinto, vendedor e inimigos.
     */
    public Jogo() {
        this.labirinto = new Labirinto();
        this.vendedor = new Vendedor();
        this.random = new Random();

        // Lista de inimigos possíveis
        this.inimigosDisponiveis = new ArrayList<>();
        this.inimigosDisponiveis.add(new Morga());
        this.inimigosDisponiveis.add(new Jadeite());
    }

    /**
     * Inicia o fluxo do jogo: cria personagem, entra no labirinto e gere o ciclo principal.
     */
    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        criarPersonagem(scanner);

        while (true) {
            System.out.println("\n🌙=== INÍCIO DO LABIRINTO ===🌙");
            labirinto.setSalaAtual(labirinto.getSalaAtual()); // Começa sempre do início
            cicloLabirinto(scanner);

            System.out.println("\nO que queres fazer?");
            System.out.println("1. Jogar novamente com a mesma heroína");
            System.out.println("2. Criar uma nova heroína");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                // Repõe vida da heroína para novo jogo
                heroina.setVidaAtual(heroina.getVidaMax());
            } else if (opcao == 2) {
                criarPersonagem(scanner);
            } else {
                System.out.println("Até à próxima! 🌟");
                break;
            }
        }
    }

    /**
     * Permite ao utilizador criar a sua heroína e escolher dificuldade.
     * @param scanner Scanner para input.
     */
    private void criarPersonagem(Scanner scanner) {
        System.out.println("Escolhe a tua heroína:");
        System.out.println("1. Sailor Moon");
        System.out.println("2. Sailor Mercurio");
        System.out.println("3. Sailor Marte");
        int escolhaHeroina = scanner.nextInt();

        System.out.println("Escolhe a dificuldade:");
        System.out.println("1. Fácil");
        System.out.println("2. Difícil");
        int escolhaDificuldade = scanner.nextInt();
        if (escolhaDificuldade == 1) {
            dificuldadeSelecionada = DificuldadeJogo.FACIL;
        } else {
            dificuldadeSelecionada = DificuldadeJogo.DIFICIL;
        }

        int pontosCriacao;
        int ouro;
        if (dificuldadeSelecionada == DificuldadeJogo.FACIL) {
            pontosCriacao = 300;
            ouro = 20;
        } else {
            pontosCriacao = 220;
            ouro = 15;
        }

        System.out.println("Tens " + pontosCriacao + " pontos para distribuir (VIDA=1pt, FORÇA=5pt).");
        int vida, forca;
        while (true) {
            System.out.print("VIDA: ");
            vida = scanner.nextInt();
            System.out.print("FORÇA: ");
            forca = scanner.nextInt();
            int total = vida + (forca * 5);
            if (total == pontosCriacao) break;
            System.out.println("Total inválido (" + total + "). Tem de ser igual a " + pontosCriacao);
        }

        switch (escolhaHeroina) {
            case 1:
                heroina = new SailorMoon(vida, forca, 1, ouro, null);
                break;
            case 2:
                heroina = new SailorMercurio(vida, forca, 1, ouro, null);
                break;
            case 3:
                heroina = new SailorMarte(vida, forca, 1, ouro, null);
                break;
            default:
                heroina = new SailorMoon(vida, forca, 1, ouro, null);
        }
        System.out.println("Heroína criada:");
        heroina.mostrarDetalhes();
    }

    /**
     * Gera e gere o ciclo do labirinto, mostrando as salas, sorteando eventos e movimentando a heroína.
     * @param scanner Scanner para input do utilizador.
     */
    private void cicloLabirinto(Scanner scanner) {
        Sala salaAtual = labirinto.getSalaAtual();

        while (!labirinto.chegouAoFinal() && heroina.estaViva()) {
            System.out.println("\n== Sala Atual: " + salaAtual.getNome() + " ==");
            System.out.println(salaAtual.getDescricao());

            // Sorteia evento apenas se não for vendedor ou final
            if (salaAtual.getEvento() == TipoEvento.VENDEDOR) {
                vendedor.interagirComHeroina(heroina);
            } else if (salaAtual.getEvento() == TipoEvento.FINAL) {
                System.out.println("Encontraste o PORTAL DA LUA! 🌙 GANHASTE O JOGO!");
                break;
            } else {
                TipoEvento eventoAleatorio = sortearEvento();
                processarEvento(eventoAleatorio, scanner);
                if (!heroina.estaViva()) {
                    System.out.println("💀 Foste derrotada. O jogo terminou!");
                    break;
                }
            }

            // Sempre que termina a sala, pode usar poções antes de avançar
            usarPocaoDepoisSala(scanner);

            // Apresenta as direções possíveis
            Map<Direcao, Sala> opcoes = salaAtual.getLigacoes();
            if (opcoes.isEmpty()) {
                break; // Não há mais salas para avançar
            }
            System.out.println("Caminhos disponíveis:");
            int i = 1;
            Map<Integer, Direcao> indiceParaDirecao = new HashMap<>();
            for (Map.Entry<Direcao, Sala> entry : opcoes.entrySet()) {
                System.out.println(i + ". " + entry.getKey() + " - " + entry.getValue().getNome());
                indiceParaDirecao.put(i, entry.getKey());
                i++;
            }
            System.out.print("Escolhe a direção: ");
            int escolha = scanner.nextInt();
            Direcao direcao = indiceParaDirecao.get(escolha);
            salaAtual = opcoes.get(direcao);
            labirinto.setSalaAtual(salaAtual);
        }
    }

    /**
     * Sorteia um evento aleatório para a sala (exceto vendedor e final).
     * @return TipoEvento sorteado.
     */
    private TipoEvento sortearEvento() {
        int n = random.nextInt(100);
        if (n < 30) return TipoEvento.INIMIGO;
        else if (n < 50) return TipoEvento.POCAO;
        else if (n < 70) return TipoEvento.ARMADILHA;
        else if (n < 85) return TipoEvento.OURO;
        else return TipoEvento.SALA_VAZIA;
    }

    /**
     * Processa o evento sorteado dentro da sala.
     * @param evento Evento sorteado.
     * @param scanner Scanner para input.
     */
    private void processarEvento(TipoEvento evento, Scanner scanner) {
        switch (evento) {
            case INIMIGO:
                if (!inimigosDisponiveis.isEmpty()) {
                    NPC inimigo = inimigosDisponiveis.remove(random.nextInt(inimigosDisponiveis.size()));
                    inimigo.introduzir();
                    Combate.combateTurnos(heroina, inimigo, scanner);
                } else {
                    System.out.println("Não há mais inimigos neste labirinto.");
                }
                break;
            case POCAO:
                Pocao pocaoSala = new Pocao("Poção Misteriosa", 0, new ArrayList<>(), 15, 2);
                System.out.println("Encontraste uma poção! Foi adicionada ao teu inventário.");
                heroina.adicionarItem(pocaoSala);
                break;
            case ARMADILHA:
                int dano = 5 + random.nextInt(16); // Entre 5 e 20
                System.out.println("Caíste numa armadilha! Perdes " + dano + " de vida.");
                heroina.receberDano(dano);
                break;
            case OURO:
                int ouroGanho = 5 + random.nextInt(11); // Entre 5 e 15
                System.out.println("Encontraste " + ouroGanho + " moedas de ouro!");
                heroina.setOuro(heroina.getOuro() + ouroGanho);
                break;
            case SALA_VAZIA:
                System.out.println("A sala está vazia. Segues em frente.");
                break;
            default:
                System.out.println("Nada acontece.");
                break;
        }
    }

    /**
     * Permite ao jogador usar poções no fim de cada sala, antes de avançar.
     * @param scanner Scanner para input.
     */
    private void usarPocaoDepoisSala(Scanner scanner) {
        while (true) {
            ArrayList<Pocao> pocoes = new ArrayList<>();
            for (Consumivel c : heroina.getInventario()) {
                if (c instanceof Pocao) {
                    pocoes.add((Pocao) c);
                }
            }
            if (pocoes.isEmpty()) {
                break;
            }
            System.out.println("\nInventário de Poções:");
            for (int i = 0; i < pocoes.size(); i++) {
                Pocao p = pocoes.get(i);
                System.out.println((i + 1) + ". " + p.getNome() + " - Cura: " + p.getCuraVida() + " - Força extra: " + p.getAumentoForca());
            }
            System.out.print("Queres usar alguma poção? (0 para avançar): ");
            int escolha = scanner.nextInt();
            if (escolha <= 0 || escolha > pocoes.size()) break;
            Pocao pocao = pocoes.get(escolha - 1);

            int vidaAntes = heroina.getVidaAtual();
            int vidaMax = heroina.getVidaMax();
            int vidaCurada = pocao.getCuraVida();
            int vidaFinal = vidaAntes + vidaCurada;
            int excesso = 0;
            if (vidaFinal > vidaMax) {
                excesso = vidaFinal - vidaMax;
                vidaFinal = vidaMax;
            }
            heroina.setVidaAtual(vidaFinal);
            if (pocao.getAumentoForca() > 0) {
                heroina.setForca(heroina.getForca() + pocao.getAumentoForca());
                System.out.println("Força aumentada em " + pocao.getAumentoForca() + "!");
            }
            if (excesso > 0) {
                System.out.println("Curaste até à vida máxima! " + excesso + " de cura foi desperdiçada.");
            } else {
                System.out.println("Curaste " + vidaCurada + " de vida!");
            }
            heroina.getInventario().remove(pocao);
        }
    }

    /**
     * @return A heroína atual.
     */
    public Heroina getHeroina() {
        return heroina;
    }

    /**
     * @return A dificuldade selecionada.
     */
    public DificuldadeJogo getDificuldadeSelecionada() {
        return dificuldadeSelecionada;
    }
}