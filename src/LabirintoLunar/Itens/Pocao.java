package LabirintoLunar.Itens;

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
     * @param nome Nome da poção.
     * @param preco Preço da poção.
     * @param heroinasPermitidas Lista de heroínas que podem usar.
     * @param curaVida Quantidade de vida curada.
     * @param aumentoForca Quantidade de força aumentada.
     */
    public Pocao(String nome, int preco, ArrayList<TipoHeroina> heroinasPermitidas, int curaVida, int aumentoForca) {
        super(nome, preco, heroinasPermitidas);
        this.curaVida = curaVida;
        this.aumentoForca = aumentoForca;
    }

    /**
     * Devolve a quantidade de vida que esta poção cura.
     * @return Valor de vida curada.
     */
    public int getCuraVida() {
        return curaVida;
    }

    /**
     * Devolve a quantidade de força que esta poção aumenta.
     * @return Valor de força aumentada.
     */
    public int getAumentoForca() {
        return aumentoForca;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("🧴 Poção: " + nome + "\nPreço: " + preco +
                "\nCura: " + curaVida + " vida" +
                "\nAumento de Força: " + aumentoForca +
                "\nPermitido para: " + (heroinasPermitidas.isEmpty() ? "Qualquer heroína" : heroinasPermitidas));
    }
}