package LabirintoLunar.Itens;

import LabirintoLunar.Enum.TipoHeroina;
import java.util.ArrayList;

/**
 * Classe abstrata que representa um item utilizável por uma heroína,
 * como armas, poções ou consumíveis de combate.
 * Esta classe serve de base para todos os itens do inventário da heroína.
 */
public abstract class ItemHeroina {

    protected String nome;
    protected int preco;
    protected ArrayList<TipoHeroina> heroinasPermitidas;

    /**
     * Construtor base de ItemHeroina.
     *
     * @param nome Nome do item.
     * @param preco Preço em moedas de ouro.
     * @param heroinasPermitidas Lista dos tipos de heroína que podem usar o item.
     * Se a lista estiver vazia, qualquer heroína pode usar.
     */
    public ItemHeroina(String nome, int preco, ArrayList<TipoHeroina> heroinasPermitidas) {
        this.nome = nome;
        this.preco = preco;
        this.heroinasPermitidas = new ArrayList<>(heroinasPermitidas);
    }

    /**
     * Devolve o nome do item.
     * @return nome do item
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o preço em moedas de ouro.
     * @return preço do item
     */
    public int getPreco() {
        return preco;
    }

    /**
     * Devolve uma cópia da lista dos tipos de heroína que podem usar o item.
     * @return lista de tipos de heroína permitidos
     */
    public ArrayList<TipoHeroina> getHeroinasPermitidas() {
        return new ArrayList<>(heroinasPermitidas);
    }

    /**
     * Verifica se um determinado tipo de heroína pode usar o item.
     * Se a lista heroinasPermitidas estiver vazia, significa que qualquer heroína pode usar.
     * @param tipo Tipo de heroína.
     * @return true se puder usar, false caso contrário.
     */
    public boolean podeSerUsadoPor(TipoHeroina tipo) {
        return heroinasPermitidas.isEmpty() || heroinasPermitidas.contains(tipo);
    }

    /**
     * Método abstrato para mostrar detalhes do item na consola.
     * Deve ser implementado pelas subclasses.
     */
    public abstract void mostrarDetalhes();
}