package LabirintoLunar;

/**
 * Evento em que a heroína encontra um tesouro e ganha ouro.
 */
public class EventoTesouro extends EventoSala {

    private int quantidadeOuro;

    /**
     * Construtor do evento de tesouro.
     * @param quantidadeOuro Quantidade de ouro a receber.
     */
    public EventoTesouro(int quantidadeOuro) {
        this.quantidadeOuro = quantidadeOuro;
    }

    @Override
    public void executar(Heroina heroina) {
        System.out.println("\n💰 Encontraste um baú brilhante!");
        System.out.println("Recebes " + quantidadeOuro + " moedas de ouro!");

        int novoOuro = heroina.getOuro() + quantidadeOuro;
        heroina.setOuro(novoOuro);

        System.out.println("💎 Ouro total: " + heroina.getOuro());
    }
}