package LabirintoLunar;

import java.util.ArrayList;

/**
 * Representa uma arma principal que pode ser equipada por uma heroína.
 */
public class ArmaPrincipal extends ItemHeroina {

    private int ataque;
    private int ataqueEspecial;

    public ArmaPrincipal(String nome, int preco, ArrayList<String> heroinasPermitidas, int ataque, int ataqueEspecial) {
        super(nome, preco, heroinasPermitidas);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("🗡️ Arma: " + nome);
        System.out.println("Preço: " + preco + " ouro");
        System.out.println("Ataque: " + ataque);
        System.out.println("Ataque Especial: " + ataqueEspecial);
        System.out.println("Permitido para: " + heroinasPermitidas);
    }
}