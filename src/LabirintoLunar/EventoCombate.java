package LabirintoLunar;

/**
 * Representa um evento de combate entre a heroína e um NPC.
 */
public class EventoCombate extends EventoSala {

    private NPC inimigo;

    /**
     * Construtor do evento de combate.
     * @param inimigo NPC que a heroína irá enfrentar
     */
    public EventoCombate(NPC inimigo) {
        this.inimigo = inimigo;
    }

    @Override
    public void executar(Heroina heroina) {
        System.out.println("\n🛑 Encontraste um inimigo: " + inimigo.getNome());
        inimigo.mostrarDetalhes();
        heroina.mostrarDetalhes();

        // Luta até alguém morrer
        while (heroina.estaViva() && inimigo.estaViva()) {
            // Heroína ataca primeiro
            heroina.atacar(inimigo);

            if (!inimigo.estaViva()) {
                System.out.println("\n✅ Vitória! Derrotaste " + inimigo.getNome() + "!");
                heroina.setOuro(heroina.getOuro() + inimigo.getOuro());
                System.out.println("💰 Recebeste " + inimigo.getOuro() + " de ouro!");
                break;
            }

            // Inimigo contra-ataca
            System.out.println("\n⚠️ " + inimigo.getNome() + " contra-ataca!");
            heroina.receberDano(inimigo.getForca());

            if (!heroina.estaViva()) {
                System.out.println("\n💀 Foste derrotada pela vilã " + inimigo.getNome() + "...");
            }
        }
    }
}