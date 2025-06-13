package LabirintoLunar;

import java.util.ArrayList;

/**
 * Representa a heroína Sailor Marte.
 */
public class SailorMarte extends Heroina {

    public SailorMarte() {
        super("SailorMarte", 95, 16, 1, 48, null);
        this.armaPrincipal = null;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void atacar(Entidade inimigo) {
        int dano = this.forca;
        if (armaPrincipal != null) {
            dano += armaPrincipal.getAtaque();
        }
        System.out.println("🔥 " + nome + " ataca com chamas ardentes! Dano: " + dano);
        inimigo.receberDano(dano);
    }
}