package LabirintoLunar.Entidades;

import LabirintoLunar.Itens.ArmaPrincipal;
import LabirintoLunar.Enum.TipoHeroina;

/**
 * Representa a heroína Sailor Moon, baseada no arquétipo de "Cavaleiro".
 * Tem armadura especial: o inimigo ataca primeiro, mas só com 80% da força.
 */
public class SailorMoon extends Heroina {

    /**
     * Construtor padrão (usa valores predefinidos).
     */
    public SailorMoon() {
        super("Sailor Moon", 100, 15, 1, 50, null, TipoHeroina.SAILOR_MOON);
    }

    /**
     * Construtor parametrizado: permite criar a Sailor Moon com valores personalizados.
     *
     * @param vidaMax Vida máxima.
     * @param forca Força inicial.
     * @param nivel Nível inicial.
     * @param ouro Ouro inicial.
     * @param armaPrincipal Arma principal equipada (pode ser null).
     */
    public SailorMoon(int vidaMax, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal) {
        super("Sailor Moon", vidaMax, forca, nivel, ouro, armaPrincipal, TipoHeroina.SAILOR_MOON);
    }

    /**
     * Lógica de combate especial para Sailor Moon.
     */
    @Override
    public boolean atacar(NPC inimigo) {
        System.out.println("\n🌙 Sailor Moon prepara-se para o combate contra " + inimigo.getNome() + "!");

        // Inimigo ataca primeiro com dano reduzido
        int danoInimigo = (int) Math.round(inimigo.getForca() * 0.8);
        System.out.println("O inimigo ataca primeiro! Dano reduzido pela armadura: " + danoInimigo);
        this.receberDano(danoInimigo);

        if (!this.estaViva()) {
            System.out.println("Sailor Moon foi derrotada antes de poder contra-atacar!");
            return false;
        }

        // Sailor Moon ataca
        int danoHeroina = this.getForca();
        if (getArmaPrincipal() != null) {
            danoHeroina += getArmaPrincipal().getAtaque();
        }
        System.out.println("🌙 Sailor Moon contra-ataca! Causa " + danoHeroina + " de dano!");
        inimigo.receberDano(danoHeroina);

        if (inimigo.getVidaAtual() <= 0) {
            System.out.println("O inimigo foi derrotado por Sailor Moon!");
            return true;
        } else {
            System.out.println("O inimigo ainda resiste ao poder da Lua!");
            return false;
        }
    }
}