package LabirintoLunar;

/**
 * Evento em que a heroína encontra uma fonte mágica e recupera vida.
 */
public class EventoCura extends EventoSala {

    private int quantidadeCura;

    /**
     * Construtor do evento de cura.
     * @param quantidadeCura Quantidade de vida a recuperar (pode ser total ou parcial)
     */
    public EventoCura(int quantidadeCura) {
        this.quantidadeCura = quantidadeCura;
    }

    @Override
    public void executar(Heroina heroina) {
        System.out.println("\n💖 Encontras uma fonte mágica brilhante!");
        System.out.println("✨ Recuperas " + quantidadeCura + " pontos de vida!");

        int novaVida = heroina.getVidaAtual() + quantidadeCura;
        if (novaVida > heroina.getVidaMax()) {
            novaVida = heroina.getVidaMax(); // não ultrapassar a vida máxima
        }

        heroina.setVidaAtual(novaVida);

        System.out.println("❤️ Vida atual: " + heroina.getVidaAtual() + " / " + heroina.getVidaMax());
    }
}