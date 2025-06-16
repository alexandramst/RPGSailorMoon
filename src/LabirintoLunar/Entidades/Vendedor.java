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
        loja.add(new ArmaPrincipal("Cetro Lunar", 40,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MOON)), 15, 25));

        // Item exclusivo da Sailor Mercurio
        loja.add(new ArmaPrincipal("Harpão de Gelo", 35,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MERCURIO)), 13, 22));

        // Item exclusivo da Sailor Marte
        loja.add(new ConsumivelCombate("Papel de Exorcismo", 18,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MARTE)), 30));

        // Item apenas para Mercurio e Marte
        loja.add(new Pocao("Poção Misteriosa", 14,
                new ArrayList<>(Arrays.asList(TipoHeroina.SAILOR_MERCURIO, TipoHeroina.SAILOR_MARTE)), 25, 0));

        // Itens extra universais para completar a loja
        for (int i = 0; i < 7; i++) {
            loja.add(new Pocao("Poção Extra " + (i + 1), 8 + i, new ArrayList<>(), 10 + i, i));
        }
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
     * Mostra até 10 itens disponíveis na loja na ordem atual da lista.
     */
    public void imprimirLoja() {
        System.out.println("\n🛍️ Itens disponíveis na loja:");
        for (int i = 0; i < Math.min(10, loja.size()); i++) {
            System.out.print((i + 1) + ". ");
            loja.get(i).mostrarDetalhes();
        }
    }

    /**
     * Interage com a heroína, permitindo-lhe comprar itens enquanto desejar
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

        while (continuar && !loja.isEmpty() && heroina.getOuro() > 0) {
            imprimirLoja();
            System.out.println("\n💬 Tens " + heroina.getOuro() + " de ouro.");
            System.out.println("👉 Digita o número do item que queres comprar (0 para sair): ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Opção inválida. Tenta novamente.");
                continue;
            }

            if (opcao == 0) {
                System.out.println("👋 Saíste da loja.");
                continuar = false;
            } else if (opcao > 0 && opcao <= Math.min(10, loja.size())) {
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
                        System.out.println("🎒 Adicionaste ao inventário: " + item.getNome());
                    }
                    heroina.setOuro(heroina.getOuro() - item.getPreco());
                    System.out.println("💰 Restam-te " + heroina.getOuro() + " de ouro.");

                    // Remove o item comprado do stock do vendedor!
                    loja.remove(item);

                } else {
                    System.out.println("❌ Não tens ouro suficiente.");
                }
            } else {
                System.out.println("❌ Opção inválida. Tenta novamente.");
            }
        }

        if (loja.isEmpty()) {
            System.out.println("O vendedor já não tem mais itens para vender!");
        } else if (heroina.getOuro() <= 0) {
            System.out.println("Ficaste sem ouro!");
        }
    }
}