package LabirintoLunar;

import java.util.ArrayList;

/**
 * Representa a heroína Sailor Mercúrio.
 */
public class SailorMercurio extends Heroina {

    public SailorMercurio() {
        super("SailorMercurio", 90, 14, 1, 45, null);
        this.armaPrincipal = null;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void atacar(Entidade inimigo) {
        int dano = this.forca;
        if (armaPrincipal != null) {
            dano += armaPrincipal.getAtaque();
        }
        System.out.println("💧 " + nome + " ataca com jato de água! Dano: " + dano);
        inimigo.receberDano(dano);
    }
}