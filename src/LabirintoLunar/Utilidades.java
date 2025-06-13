package LabirintoLunar;

import java.util.ArrayList;

/**
 * Classe utilitária para criar o stock inicial de itens do vendedor.
 */
public class Utilidades {

    /**
     * Cria uma lista de 15 itens variados (armas, consumíveis e poções).
     * @return Lista de itens para o vendedor.
     */
    public static ArrayList<ItemHeroina> criarStockInicial() {
        ArrayList<ItemHeroina> stock = new ArrayList<>();

        // Armas Principais
        ArrayList<String> p1 = new ArrayList<>();
        p1.add("SailorMoon");
        stock.add(new ArmaPrincipal("Tiara Lunar", 20, p1, 10, 25));

        ArrayList<String> p2 = new ArrayList<>();
        p2.add("SailorMarte");
        stock.add(new ArmaPrincipal("Chamas Celestiais", 30, p2, 15, 30));

        ArrayList<String> p3 = new ArrayList<>();
        p3.add("SailorMercurio");
        stock.add(new ArmaPrincipal("Bolhas de Névoa", 25, p3, 12, 20));

        ArrayList<String> p4 = new ArrayList<>();
        p4.add("SailorMoon");
        stock.add(new ArmaPrincipal("Cetro Espiral", 40, p4, 20, 35));

        ArrayList<String> p5 = new ArrayList<>();
        p5.add("SailorMarte");
        p5.add("SailorMoon");
        stock.add(new ArmaPrincipal("Lança Lunar Flamejante", 50, p5, 18, 40));

        // Consumíveis de Combate
        ArrayList<String> c1 = new ArrayList<>();
        c1.add("SailorMoon");
        stock.add(new ConsumivelCombate("Mini Tiara Extra", 10, c1, 12));

        ArrayList<String> c2 = new ArrayList<>();
        c2.add("SailorMarte");
        stock.add(new ConsumivelCombate("Chicote de Fogo", 12, c2, 15));

        ArrayList<String> c3 = new ArrayList<>();
        c3.add("SailorMercurio");
        stock.add(new ConsumivelCombate("Explosão Gélida", 15, c3, 14));

        ArrayList<String> c4 = new ArrayList<>();
        c4.add("SailorMoon");
        c4.add("SailorMercurio");
        stock.add(new ConsumivelCombate("Raio Arco-Íris", 18, c4, 16));

        ArrayList<String> c5 = new ArrayList<>();
        c5.add("SailorMarte");
        stock.add(new ConsumivelCombate("Granada Solar", 20, c5, 20));

        // Poções
        ArrayList<String> po1 = new ArrayList<>();
        po1.add("SailorMoon");
        stock.add(new Pocao("Poção da Lua Cheia", 15, po1, 20, 0));

        ArrayList<String> po2 = new ArrayList<>();
        po2.add("SailorMercurio");
        stock.add(new Pocao("Elixir Mental", 18, po2, 15, 2));

        ArrayList<String> po3 = new ArrayList<>();
        po3.add("SailorMarte");
        stock.add(new Pocao("Poção de Fogo Sagrado", 20, po3, 25, 5));

        ArrayList<String> po4 = new ArrayList<>();
        po4.add("SailorMoon");
        po4.add("SailorMarte");
        stock.add(new Pocao("Néctar Estelar", 30, po4, 30, 3));

        ArrayList<String> po5 = new ArrayList<>();
        po5.add("SailorMercurio");
        stock.add(new Pocao("Gotas de Gelo", 22, po5, 18, 4));

        return stock;
    }
}