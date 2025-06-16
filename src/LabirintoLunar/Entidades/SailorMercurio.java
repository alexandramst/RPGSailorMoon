package LabirintoLunar.Entidades;

import LabirintoLunar.Itens.ArmaPrincipal;
import LabirintoLunar.Enum.TipoHeroina;

/**
 * Representa a heroína Sailor Mercurio, baseada no arquétipo de "Feiticeiro".
 * Sailor Mercurio ataca primeiro, o inimigo responde com ataque normal.
 */
public class SailorMercurio extends Heroina {

    /**
     * Construtor padrão (usa valores predefinidos para Sailor Mercurio).
     */
    public SailorMercurio() {
        super("Sailor Mercurio", 90, 14, 1, 45, null, TipoHeroina.SAILOR_MERCURIO);
    }

    /**
     * Construtor parametrizado: permite criar a Sailor Mercurio com valores personalizados.
     *
     * @param vidaMax        Vida máxima.
     * @param forca          Força inicial.
     * @param nivel          Nível inicial.
     * @param ouro           Ouro inicial.
     * @param armaPrincipal  Arma principal equipada (pode ser null).
     */
    public SailorMercurio(int vidaMax, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal) {
        super("Sailor Mercurio", vidaMax, forca, nivel, ouro, armaPrincipal, TipoHeroina.SAILOR_MERCURIO);
    }

    /**
     * Lógica de combate especial para Sailor Mercurio:
     * - Ataca primeiro (força + ataque da arma, se houver).
     * - Se o inimigo sobreviver, ataca normalmente.
     * @param inimigo O NPC inimigo a combater.
     * @return true se derrotou o inimigo, false caso contrário.
     */
    @Override
    public boolean atacar(NPC inimigo) {
        System.out.println("\n💧 " + getNome() + " ataca primeiro com o poder da água!");

        // Sailor Mercurio ataca primeiro
        int danoHeroina = this.getForca();
        if (getArmaPrincipal() != null) {
            danoHeroina += getArmaPrincipal().getAtaque();
        }
        System.out.println("Causa " + danoHeroina + " de dano!");
        inimigo.receberDano(danoHeroina);

        if (!inimigo.estaViva()) {
            System.out.println("O inimigo foi derrotado pelo ataque aquático!");
            return true;
        }

        // O inimigo ataca normalmente
        int danoInimigo = inimigo.getForca();
        System.out.println("O inimigo reage! Dano causado: " + danoInimigo);
        this.receberDano(danoInimigo);

        if (!this.estaViva()) {
            System.out.println("Sailor Mercúrio foi derrotada pelo inimigo!");
            return false;
        }

        System.out.println("Ambos resistem! O combate pode continuar.");
        return false;
    }
}