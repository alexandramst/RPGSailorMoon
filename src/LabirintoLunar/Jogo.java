package LabirintoLunar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal responsável por iniciar o jogo e gerir as escolhas do jogador.
 */
public class Jogo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🌙 Bem-vinda ao Labirinto Lunar!");
        Heroina heroina = criarPersonagem(sc);

        System.out.println("\n✨ Detalhes da heroína:");
        heroina.mostrarDetalhes();

        // Criar stock e vendedor
        ArrayList<ItemHeroina> stockInicial = Utilidades.criarStockInicial();
        Vendedor vendedor = new Vendedor(stockInicial);

        System.out.println("\n🛍️ Chegaste à loja mágica da Lua!");
        vendedor.interagirComHeroina(heroina);

        System.out.println("\n🧚‍♀️ Boa sorte no teu caminho pelo Labirinto!");
    }

    /**
     * Permite ao jogador escolher a heroína que quer jogar.
     * @param sc Scanner para leitura de input.
     * @return Heroína criada.
     */
    public static Heroina criarPersonagem(Scanner sc) {
        System.out.println("🌙 Bem-vinda ao Labirinto Lunar!");
        System.out.println("・┆✦ʚ♡ɞ✦ ┆・Escolhe a tua heroína・┆✦ʚ♡ɞ✦ ┆・");
        System.out.println("1. Sailor Moon 🌙");
        System.out.println("2. Sailor Mercúrio 🌊");
        System.out.println("3. Sailor Marte 🔥");
        System.out.print("Escolha: ");

        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
                return new SailorMoon();
            case 2:
                return new SailorMercurio();
            case 3:
                return new SailorMarte();
            default:
                System.out.println("Opção inválida. Sailor Moon escolhida por defeito.");
                return new SailorMoon();
        }
    }
}