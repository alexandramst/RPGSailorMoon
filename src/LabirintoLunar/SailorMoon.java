package LabirintoLunar;

import java.util.ArrayList;

/**
 * Representa a heroína Sailor Moon.
 */
public class SailorMoon extends Heroina {

    public SailorMoon() {
        super("SailorMoon", 100, 15, 1, 50, null);
        this.armaPrincipal = null;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void atacar(Entidade inimigo) {
        int dano = this.forca;
        if (armaPrincipal != null) {
            dano += armaPrincipal.getAtaque();
        }
        System.out.println("🌙 " + nome + " ataca com dano " + dano + "!");
        inimigo.receberDano(dano);
    }
}