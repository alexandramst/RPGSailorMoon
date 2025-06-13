package LabirintoLunar;

/**
 * Classe abstrata que representa um NPC (personagem não jogável).
 * NPCs podem ser inimigos ou outros personagens encontrados no labirinto.
 */
public abstract class NPC extends Entidade {

    protected int ouro;

    /**
     * Construtor do NPC.
     *
     * @param nome Nome do NPC.
     * @param vidaMax Vida máxima do NPC.
     * @param forca Força do NPC.
     * @param ouro Quantidade de ouro que o NPC possui.
     */
    public NPC(String nome, int vidaMax, int forca, int ouro) {
        super(nome, vidaMax, forca);
        this.ouro = ouro;
    }

    /**
     * Obtém a quantidade de ouro do NPC.
     *
     * @return Quantidade de ouro.
     */
    public int getOuro() {
        return ouro;
    }

    /**
     * Define a quantidade de ouro do NPC.
     *
     * @param ouro Novo valor de ouro.
     */
    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * Mostra os detalhes do NPC, incluindo o ouro.
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("\uD83D\uDCB0 Ouro: " + ouro);
        System.out.println("--------------------------------");
    }
}