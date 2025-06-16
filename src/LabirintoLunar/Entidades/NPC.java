package LabirintoLunar.Entidades;

/**
 * Classe abstrata que representa um NPC (personagem não jogável) no labirinto.
 * NPCs podem ser inimigos ou figuras com quem a heroína interage.
 */
public abstract class NPC extends Entidade {

    protected int ouro;

    /**
     * Construtor do NPC.
     *
     * @param nome    Nome do NPC.
     * @param vidaMax Vida máxima do NPC.
     * @param forca   Força de ataque do NPC.
     * @param ouro    Quantidade de ouro que o NPC carrega.
     */
    public NPC(String nome, int vidaMax, int forca, int ouro) {
        super(nome, vidaMax, forca);
        this.ouro = ouro;
    }

    /**
     * Devolve a quantidade de ouro que o NPC carrega.
     * @return Ouro.
     */
    public int getOuro() {
        return ouro;
    }

    /**
     * Define a quantidade de ouro do NPC.
     * @param ouro Novo valor de ouro.
     */
    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * Mostra detalhes do NPC na consola.
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("💰 Ouro: " + ouro);
        System.out.println("--------------------------------");
    }

    /**
     * Método abstrato que representa uma introdução falada do NPC ao iniciar o encontro.
     * Cada subclasse deve implementar esta apresentação.
     */
    public abstract void introduzir();
}