package LabirintoLunar.Entidades;

import LabirintoLunar.Itens.ArmaPrincipal;
import LabirintoLunar.Enum.TipoHeroina;

/**
 * Representa a heroína Sailor Marte, baseada no arquétipo de "Arqueira".
 * Ataca primeiro, mas recebe 10% mais dano do inimigo.
 */
public class SailorMarte extends Heroina {

    /**
     * Construtor padrão (usa valores predefinidos).
     */
    public SailorMarte() {
        super("Sailor Marte", 95, 16, 1, 48, null, TipoHeroina.SAILOR_MARTE);
    }

    /**
     * Construtor parametrizado: permite criar a Sailor Marte com valores personalizados.
     *
     * @param vidaMax Vida máxima.
     * @param forca Força inicial.
     * @param nivel Nível inicial.
     * @param ouro Ouro inicial.
     * @param armaPrincipal Arma principal equipada (pode ser null).
     */
    public SailorMarte(int vidaMax, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal) {
        super("Sailor Marte", vidaMax, forca, nivel, ouro, armaPrincipal, TipoHeroina.SAILOR_MARTE);
    }

    /**
     * Lógica de combate especial para Sailor Marte.
     */
    @Override
    public boolean atacar(NPC inimigo) {
        System.out.println("\n🔥 " + getNome() + " ataca primeiro com chamas ardentes!");

        int danoHeroina = this.getForca();
        if (getArmaPrincipal() != null) {
            danoHeroina += getArmaPrincipal().getAtaque();
        }
        System.out.println("Causa " + danoHeroina + " de dano!");
        inimigo.receberDano(danoHeroina);

        if (!inimigo.estaViva()) {
            System.out.println("O inimigo foi derrotado pelo fogo purificador!");
            return true;
        }

        int danoInimigo = (int) Math.round(inimigo.getForca() * 1.10);
        System.out.println("O inimigo contra-ataca! Dano aumentado (+10%): " + danoInimigo);
        this.receberDano(danoInimigo);

        if (!this.estaViva()) {
            System.out.println("Sailor Marte foi derrotada!");
            return false;
        }

        System.out.println("Ambos resistem! O combate continua.");
        return false;
    }
}