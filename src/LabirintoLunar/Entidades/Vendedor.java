package LabirintoLunar.Entidades;

import LabirintoLunar.Itens.ArmaPrincipal;
import LabirintoLunar.Itens.Consumivel;
import LabirintoLunar.Itens.ConsumivelCombate;
import LabirintoLunar.Itens.ItemHeroina;
import LabirintoLunar.Itens.Pocao;
import LabirintoLunar.Enum.TipoHeroina;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Representa um vendedor no labirinto que vende itens à heroína.
 * O vendedor possui uma lista de itens disponíveis para venda, que podem incluir
 * armas principais, consumíveis de combate e poções.
 */
public class Vendedor {

    private ArrayList<ItemHeroina> loja;

    /**
     * Construtor padrão.
     * Inicializa a loja com exemplos de itens universais e exclusivos.
     */
    public Vendedor() {
        loja = new ArrayList<>();

        // Itens universais (todas as heroínas podem usar)
        loja.add(new Pocao("Poção de Vida", 10, new ArrayList<>(), 20, 0));
        loja.add(new Pocao("Poção de Força", 12, new ArrayList<>(), 0, 5));
        loja.add(new ConsumivelCombate("Granada Lunar", 15, new ArrayList<>(), 25));
        loja.add(new ArmaPrincipal("Espada Lunar", 30, new ArrayList<>(), 10, 15));

        // Item exclusivo da Sailor Moon
        loja.add(new ArmaPrincipal("Cetro Lunar", 20,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MOON)), 15, 25));

        // Item exclusivo da Sailor Mercurio
        loja.add(new ArmaPrincipal("Harpão de Gelo", 15,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MERCURIO)), 13, 22));

        // Item exclusivo da Sailor Marte
        loja.add(new ConsumivelCombate("Papel de Exorcismo", 8,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MARTE)), 30));

        // Item apenas para Mercurio e Marte
        loja.add(new Pocao("Poção Misteriosa", 4,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MERCURIO, TipoHeroina.SAILOR_MARTE)), 25, 0));

        // Itens extra universais com nomes temáticos
        loja.add(new Pocao("Poção Lunar", 4, new ArrayList<>(), 10, 1));
        loja.add(new Pocao("Poção Estelar", 5, new ArrayList<>(), 11, 2));
        loja.add(new Pocao("Poção da Coragem", 5, new ArrayList<>(), 12, 2));
        loja.add(new Pocao("Poção do Destino", 6, new ArrayList<>(), 13, 3));
        loja.add(new Pocao("Poção do Eclipse", 7, new ArrayList<>(), 14, 4));
        loja.add(new Pocao("Poção do Mistério", 7, new ArrayList<>(), 15, 5));
        loja.add(new Pocao("Poção da Força Lunar", 8, new ArrayList<>(), 16, 6));
    }

    /**
     * Construtor que permite definir um stock personalizado para o vendedor.
     *
     * @param stockInicial Lista de itens a serem vendidos na loja.
     */
    public Vendedor(ArrayList<ItemHeroina> stockInicial) {
        this.loja = stockInicial;
    }

    /**
     * Método que mostra até 10 itens disponíveis na loja na ordem atual da lista.
     *
     */
    public void imprimirLoja() {
        System.out.println("\n \uD83D\uDED2 Itens disponíveis na loja:");
        int maxItens = 10;
        int limite;
        if (loja.size() < maxItens) {
            limite = loja.size();
        } else {
            limite = maxItens;
        }
        for (int i = 0; i < limite; i++) {
            ItemHeroina item = loja.get(i);
            String tipo = "Item";
            if (item instanceof ArmaPrincipal) tipo = "🗡️"; //Arma
            else if (item instanceof Pocao) tipo = "🧴"; //Poção
            else if (item instanceof ConsumivelCombate) tipo = "⚔️"; //Comsunivel Combate
            System.out.print((i + 1) + ". [" + tipo + "] ");
            item.mostrarDetalhes();
        }
    }

    /**
     * Método que interage com a heroína, permitindo-lhe comprar itens
     * (ou até ficar sem ouro ou sem stock). Após cada compra, o item é removido do stock.
     * Embaralha os itens apenas uma vez no início da visita à loja.
     *
     * @param heroina A heroína que entrou na sala do vendedor.
     */
    public void interagirComHeroina(Heroina heroina) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Só embaralha UMA vez, no início da visita!
        Collections.shuffle(loja);

        int maxItens = 10;
        while (continuar && !loja.isEmpty() && heroina.getOuro() > 0) {
            imprimirLoja();
            System.out.println("\n💬 Tens " + heroina.getOuro() + " moedas de ouro.");
            System.out.println("👉 Digita o número do item que queres comprar (Se não quiseres imprime 0 para sair): ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Opção inválida. Tenta novamente.");
                continue;
            }

            int limite;
            if (loja.size() < maxItens) {
                limite = loja.size();
            } else {
                limite = maxItens;
            }

            if (opcao == 0) {
                System.out.println("👋 Saíste da loja.");
                continuar = false;
            } else if (opcao > 0 && opcao <= limite) {
                ItemHeroina item = loja.get(opcao - 1);

                if (!item.podeSerUsadoPor(heroina.getTipo())) {
                    System.out.println("❌ A tua heroína não pode usar este item.");
                    continue;
                }

                if (heroina.getOuro() >= item.getPreco()) {
                    if (item instanceof ArmaPrincipal) {
                        heroina.setArmaPrincipal((ArmaPrincipal) item);
                        System.out.println("🗡️ Equipaste a arma: " + item.getNome());
                    } else if (item instanceof Consumivel) {
                        heroina.adicionarItem((Consumivel) item);
                        System.out.println("\uD83E\uDDFE Adicionaste ao inventário: " + item.getNome());
                    }
                    heroina.setOuro(heroina.getOuro() - item.getPreco());
                    System.out.println("💰 Restam-te " + heroina.getOuro() + " moedas de ouro.");
                    loja.remove(item);
                } else {
                    System.out.println("❌ Não tens ouro suficiente.");
                }
            } else {
                System.out.println("❌ Opção inválida. Tenta novamente.");
            }
        }
    }
}