package LabirintoLunar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Representa o vendedor do jogo, que vende itens à heroína.
 */
public class Vendedor {

    private ArrayList<ItemHeroina> stock;

    /**
     * Construtor do vendedor com stock inicial de itens.
     */
    public Vendedor(ArrayList<ItemHeroina> stockInicial) {
        this.stock = stockInicial;
    }

    /**
     * Método que permite interagir com a heroína e vender até 10 itens aleatórios.
     * @param heroina A heroína que vai comprar itens.
     */
    public void interagirComHeroina(Heroina heroina) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🛍️ A vendedora apareceu com novos itens mágicos!");

        // Embaralhar e obter os primeiros 10 itens
        ArrayList<ItemHeroina> opcoesLoja = new ArrayList<>(stock);
        Collections.shuffle(opcoesLoja);
        int limite = Math.min(10, opcoesLoja.size());

        for (int i = 0; i < limite; i++) {
            ItemHeroina item = opcoesLoja.get(i);
            System.out.println((i + 1) + " - " + item.getNome() + " (" + item.getPreco() + " ouro)");
            item.mostrarDetalhes();
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("💰 Ouro atual: " + heroina.getOuro());
            System.out.println("Digite o número do item que deseja comprar (0 para sair):");

            int escolha = scanner.nextInt();
            if (escolha == 0) {
                continuar = false;
                System.out.println("👋 A heroína agradeceu e partiu para a próxima sala.");
            } else if (escolha > 0 && escolha <= limite) {
                ItemHeroina itemEscolhido = opcoesLoja.get(escolha - 1);

                // Verifica se a heroína pode usar
                if (!itemEscolhido.getHeroinasPermitidas().contains(heroina.getClass().getSimpleName())) {
                    System.out.println("❌ A sua heroína não pode usar esse item!");
                    continue;
                }

                // Verifica se tem ouro suficiente
                if (heroina.getOuro() < itemEscolhido.getPreco()) {
                    System.out.println("❌ Ouro insuficiente para comprar esse item.");
                    continue;
                }

                // Compra
                heroina.setOuro(heroina.getOuro() - itemEscolhido.getPreco());
                stock.remove(itemEscolhido); // Remove do stock

                if (itemEscolhido instanceof ArmaPrincipal) {
                    heroina.setArmaPrincipal((ArmaPrincipal) itemEscolhido);
                    System.out.println("🗡️ Arma equipada com sucesso!");
                } else if (itemEscolhido instanceof Consumivel) {
                    heroina.adicionarItem((Consumivel) itemEscolhido);
                    System.out.println("🍀 Item adicionado ao inventário.");
                }

            } else {
                System.out.println("❓ Escolha inválida.");
            }
        }
    }

    /**
     * Permite adicionar itens ao stock do vendedor.
     * @param item O item a ser adicionado.
     */
    public void adicionarItemAoStock(ItemHeroina item) {
        stock.add(item);
    }
}