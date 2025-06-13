package LabirintoLunar;

import java.util.ArrayList;

/**
 * Classe abstrata para itens consumíveis.
 */
public abstract class Consumivel extends ItemHeroina {

    public Consumivel(String nome, int preco, ArrayList<String> heroinasPermitidas) {
        super(nome, preco, heroinasPermitidas);
    }
}