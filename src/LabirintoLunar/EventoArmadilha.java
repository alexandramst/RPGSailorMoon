package LabirintoLunar;

/**
 * Evento em que a heroína cai numa armadilha e perde vida.
 */
public class EventoArmadilha extends EventoSala {

    private int dano;

    /**
     * Construtor da armadilha.
     * @param dano Quantidade de vida que será retirada da heroína.
     */
    public EventoArmadilha(int dano) {
        this.dano = dano;
    }

    @Override
    public void executar(Heroina heroina) {
        System.out.println("\n⚠️ CAÍSTE NUMA ARMADILHA!");
        System.out.println("💥 Perdes " + dano + " pontos de vida!");

        heroina.receberDano(dano);

        if (!heroina.estaViva()) {
            System.out.println("☠️ Infelizmente, a tua aventura termina aqui...");
        } else {
            System.out.println("❤️ Vida atual: " + heroina.getVidaAtual() + " / " + heroina.getVidaMax());
        }
    }
}