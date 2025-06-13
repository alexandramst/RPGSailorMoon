package LabirintoLunar;

import java.util.ArrayList;

/**
 * Classe abstrata que representa um item que pode ser usado por uma heroína.
 * Pode ser uma arma, uma poção ou outro tipo de consumível.
 */
public abstract class ItemHeroina {

    protected String nome;
    protected int preco;
    protected ArrayList<String> heroinasPermitidas;

    /**
     * Construtor do item da heroína.
     *
     * @param nome Nome do item.
     * @param preco Preço do item em moedas de ouro.
     * @param heroinasPermitidas Lista das heroínas que podem usar este item.
     */
    public ItemHeroina(String nome, int preco, ArrayList<String> heroinasPermitidas) {
        this.nome = nome;
        this.preco = preco;
        this.heroinasPermitidas = heroinasPermitidas;
    }

    /**
     * Obtém o nome do item.
     * @return Nome do item.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o preço do item.
     * @return Preço em moedas de ouro.
     */
    public int getPreco() {
        return preco;
    }

    /**
     * Obtém a lista de heroínas que podem usar o item.
     * @return Lista de nomes das heroínas.
     */
    public ArrayList<String> getHeroinasPermitidas() {
        return heroinasPermitidas;
    }

    /**
     * Método abstrato que imprime os detalhes do item na consola.
     * Cada subclasse deve implementar este método.
     */
    public abstract void mostrarDetalhes();
}