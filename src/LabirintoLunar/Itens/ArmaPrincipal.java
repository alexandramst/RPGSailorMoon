package LabirintoLunar.Itens;

import java.util.ArrayList;
import LabirintoLunar.Enum.TipoHeroina;

/**
 * Representa uma arma principal que pode ser equipada por uma heroína.
 * Extende a classe abstrata ItemHeroina.
 */
public class ArmaPrincipal extends ItemHeroina {

    private int ataque;
    private int ataqueEspecial;

    /**
     * Construtor da arma principal.
     *
     * @param nome Nome da arma.
     * @param preco Preço em ouro.
     * @param heroinasPermitidas Lista de tipos de heroínas que podem usar esta arma.
     * @param ataque Ataque base da arma.
     * @param ataqueEspecial Ataque especial da arma.
     */
    public ArmaPrincipal(String nome, int preco, ArrayList<TipoHeroina> heroinasPermitidas, int ataque, int ataqueEspecial) {
        super(nome, preco, heroinasPermitidas);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }

    /**
     * Obtém o valor de ataque da arma.
     * @return valor de ataque.
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Obtém o valor de ataque especial da arma.
     * @return valor do ataque especial.
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    /**
     * Mostra na consola os detalhes da arma.
     * (Método sobreposto da classe ItemHeroina)
     */
    @Override
    public void mostrarDetalhes() {
        System.out.print("🗡️ Arma: " + nome + "\n");
        System.out.print("Preço: " + preco + " ouro\n");
        System.out.print("Ataque: " + ataque + "\n");
        System.out.print("Ataque Especial: " + ataqueEspecial + "\n");
        System.out.print("Permitido para: ");
        if (heroinasPermitidas == null || heroinasPermitidas.isEmpty()) {
            System.out.println("Qualquer heroína");
        } else {
            for (TipoHeroina t : heroinasPermitidas) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }
}