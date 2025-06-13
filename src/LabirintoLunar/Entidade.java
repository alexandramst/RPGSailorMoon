package LabirintoLunar;

public class Entidade {

    protected String nome;
    protected int vidaMax;
    protected int vidaAtual;
    protected int forca;

    public Entidade(String nome, int vidaMax,  int forca) {
        this.nome = nome;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaMax; //Vida Atual começa igual à vida Maxima inicialmente
        this.forca = forca;
    }

    //Getters
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

    //Metodo mostrarDetalhes
    public void mostrarDetalhes() {
        System.out.println("\uD83D\uDC8E Nome: " + this.nome);
        System.out.println("❤\uFE0F Vida: " + this.vidaAtual + " | " + this.vidaMax);
        System.out.println("\uD83D\uDCAA\uD83C\uDFFC Força: " + this.forca);
        System.out.println("--------------------------------");
    }

    // Aplica dano e evita vida negativa
    public void receberDano(int dano) {
        System.out.println(this.nome + " recebeu " + dano + " de dano!");
        this.vidaAtual -= dano;

        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }

        System.out.println("Vida atual: " + this.vidaAtual);
    }

    // Verifica se ainda está viva
    public boolean estaViva() {
        return this.vidaAtual > 0;
    }
}

