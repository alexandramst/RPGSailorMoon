package LabirintoLunar;

/**
 * Youma fraca que aparece como vilã inicial no universo Sailor Moon.
 */
public class Morga extends NPC {

    /**
     * Construtor da Morga.
     */
    public Morga() {
        super("Morga", 55, 10, 20); // nome, vidaMax, forca, ouro
    }

    /**
     * Mensagem de introdução.
     */
    public void introduzir() {
        System.out.println("📚 Morga grita: 'Meninas tolas, vou drenar toda a vossa energia!'");
    }
}