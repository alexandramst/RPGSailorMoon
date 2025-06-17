package LabirintoLunar.Entidades;

/**
 * Classe abstrata para qualquer entidade do jogo (Heroína, NPC, inimigo, etc.).
 * Fornece propriedades e métodos comuns, como nome, vida, força, receber dano e mostrar detalhes.
 *
 */
public abstract class Entidade {

    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int forca;

    /**
     * Construtor da entidade.
     *
     * @param nome    Nome da entidade.
     * @param vidaMax Vida máxima da entidade.
     * @param forca   Força base da entidade.
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
        //Caso a Vida Atual aumentar acima, ajusta

        if (this.vidaAtual > vidaMax) {
            this.vidaAtual = vidaMax;
        }
    }

    /**
     * Metodo para definir o valor da vida atual da entidade
     * @param vidaAtual Novo valor pretendido para a vida atual
     */
    public void setVidaAtual(int vidaAtual) {
        if (vidaAtual < 0) vidaAtual = 0; //Vida nunca fica negativa
        if (vidaAtual > this.vidaMax) vidaAtual = this.vidaMax; //Vida nao ultrapassa o valor máximo permitido
        this.vidaAtual = vidaAtual; //Atualiza a vida atual
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * Metodo Mostrar Detalhes da entidade na consola.
     */
    public void mostrarDetalhes() {
        System.out.println("💎 Nome: " + this.nome);
        System.out.println("❤️ Vida: " + this.vidaAtual + " / " + this.vidaMax);
        System.out.println("💪 Força: " + this.forca);
        System.out.println("\n｡ ₊°༺❤\uFE0E༻°₊ ｡｡ ₊°༺❤\uFE0E༻°₊ ｡\n");
    }

    /**
     * Método para aplicar dano à entidade. Não é permitido vida negativa.
     *
     * @param dano Quantidade de dano a subtrair à vida.
     */
    public void receberDano(int dano) {
        System.out.println(this.nome + " recebeu " + dano + " de dano!"); //Mostra na consola de quanto foi o dano
        this.vidaAtual -= dano; //subtrai o dano recebido à vida atual
        if (this.vidaAtual < 0) { //Se a vida for menor que 0, ajusta para zero.
            this.vidaAtual = 0;
        }
        System.out.println("Vida atual: " + this.vidaAtual); //Imprime na consola a vida atual depois do dano
    }

    /**
     * Verifica se a entidade está viva.
     *
     * @return true se vida atual > 0, false caso contrário.
     */
    public boolean estaViva() {
        return this.vidaAtual > 0;
    }
}