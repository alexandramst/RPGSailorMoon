package LabirintoLunar.Entidades;

/**
 * Representa a inimiga Morga, uma das personagens do Labirinto Lunar.
 */
public class Morga extends NPC {

    /**
     * Construtor da Morga.
     * Define vida, força e ouro específicos para a Morga.
     */
    public Morga() {
        super("Morga", 40, 8, 10); // vida 40, força 8, ouro 10
    }

    /**
     * Introdução personalizada da Morga ao encontrar a heroína.
     */
    @Override
    public void introduzir() {
        System.out.println("👹 Morga: \"Vocês, Sailors intrometidas, vão pagar por me desafiarem!\"");
    }
}