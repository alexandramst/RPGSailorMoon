package LabirintoLunar.Itens;

import java.util.ArrayList;
import LabirintoLunar.Enum.TipoHeroina;

/**
 * Classe abstrata que representa um item consumível no jogo.
 * Herda do ItemHeroina e serve de base para itens como poções e consumíveis de combate.
 */
public abstract class Consumivel extends ItemHeroina {

    /**
     * Construtor do consumível.
     *
     * @param nome Nome do item consumível.
     * @param preco Preço do item em ouro.
     * @param heroinasPermitidas Lista de tipos de heroínas que podem usar o item.
     */
    public Consumivel(String nome, int preco, ArrayList<TipoHeroina> heroinasPermitidas) {
        super(nome, preco, heroinasPermitidas);
    }
}