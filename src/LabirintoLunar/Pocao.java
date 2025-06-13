package LabirintoLunar;

import java.util.ArrayList;

/**
 * Poção que cura vida ou aumenta força.
 */
public class Pocao extends Consumivel {

    private int vidaACurar;
    private int aumentoForca;

    public Pocao(String nome, int preco, ArrayList<String> heroinasPermitidas, int vidaACurar, int aumentoForca) {
        super(nome, preco, heroinasPermitidas);
        this.vidaACurar = vidaACurar;
        this.aumentoForca = aumentoForca;
    }

    public int getVidaACurar() {
        return vidaACurar;
    }

    public int getAumentoForca() {
        return aumentoForca;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("🧴 Poção: " + nome);
        System.out.println("Preço: " + preco + " ouro");
        System.out.println("Cura: " + vidaACurar + " vida");
        System.out.println("Aumento de Força: " + aumentoForca);
        System.out.println("Permitido para: " + heroinasPermitidas);
    }
}