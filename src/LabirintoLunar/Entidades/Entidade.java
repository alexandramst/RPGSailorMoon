package LabirintoLunar.Entidades;

/**
 * Classe base abstrata para qualquer entidade do jogo (Herói, NPC, Inimigo, etc.).
 * Fornece propriedades e métodos comuns, como nome, vida, força, receber dano e mostrar detalhes.
 *
 * Deve ser estendida pelas classes Heroina, NPC, etc.
 */
public abstract class Entidade {

    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int forca;

    /**
     * Construtor da entidade.
     * @param nome Nome da entidade.
     * @param vidaMax Vida máxima da entidade.
     * @param forca Força base da entidade.
     */
    public Entidade(String nome, int vidaMax, int forca) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaMax; // Começa com vida total.
        this.forca = forca;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getForca() {
        return forca;
    }

    // Setters
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * Mostra detalhes da entidade na consola.
     */
    public void mostrarDetalhes() {
        System.out.println("💎 Nome: " + this.nome);
        System.out.println("❤️ Vida: " + this.vidaAtual + " / " + this.vidaMax);
        System.out.println("💪 Força: " + this.forca);
        System.out.println("--------------------------------");
    }

    /**
     * Aplica dano à entidade, não permitindo vida negativa.
     * @param dano Quantidade de dano a subtrair à vida.
     */
    public void receberDano(int dano) {
        System.out.println(this.nome + " recebeu " + dano + " de dano!");
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }
        System.out.println("Vida atual: " + this.vidaAtual);
    }

    /**
     * Verifica se a entidade está viva.
     * @return true se vida atual > 0, false caso contrário.
     */
    public boolean estaViva() {

        return this.vidaAtual > 0;
    }
}