package LabirintoLunar.Itens;

import LabirintoLunar.Cores.ConsoleColors;
import LabirintoLunar.Enum.TipoHeroina;
import java.util.ArrayList;

/**
 * Representa uma poção que pode ser usada por uma heroína para restaurar vida e/ou aumentar força.
 */
public class Pocao extends Consumivel {

    private int curaVida;
    private int aumentoForca;

    /**
     * Construtor da poção.
     *
     * @param nome               Nome da poção.
     * @param preco              Preço da poção.
     * @param heroinasPermitidas Lista de heroínas que podem usar.
     * @param curaVida           Quantidade de vida curada.
     * @param aumentoForca       Quantidade de força aumentada.
     */
    public Pocao(String nome, int preco, ArrayList<TipoHeroina> heroinasPermitidas, int curaVida, int aumentoForca) {
        super(nome, preco, heroinasPermitidas);
        this.curaVida = curaVida;
        this.aumentoForca = aumentoForca;
    }

    /**
     * Devolve a quantidade de vida que esta poção cura.
     *
     * @return Valor de vida curada.
     */
    public int getCuraVida() {
        return curaVida;
    }

    /**
     * Devolve a quantidade de força que esta poção aumenta.
     *
     * @return Valor de força aumentada.
     */
    public int getAumentoForca() {
        return aumentoForca;
    }

    @Override
    public void mostrarDetalhes() {


        String permitidoPara;
        if (heroinasPermitidas.isEmpty()) {
            permitidoPara = "Todas as Heroinas \uD83C\uDF20";
        } else {
            permitidoPara = heroinasPermitidas.toString();
        }


        System.out.print("Poção: " + nome + "\n"+
                "Preço: " + preco + " moedas de ouro\n"+
                "Cura: " + curaVida + " de vida\n" +
                "Aumento da Fprça: " + aumentoForca + "\n" +
                "Permitido para:" + permitidoPara + " \n");
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT +"⋆☆✮✪✮☆⋆ \n" + ConsoleColors.RESET);

    }
}