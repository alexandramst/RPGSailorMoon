package LabirintoLunar.Entidades;

/**
 * Inimiga Morga, uma das inimigas do Labirinto Lunar.
 */
public class Morga extends NPC {

    /**
     * Construtor da Morga.
     */
    public Morga() {
        super("Morga", 40, 8, 10); // Exemplo: vida 40, força 8, ouro 10
    }

    /**
     * Introdução personalizada da Morga ao encontrar a heroína.
     */
    @Override
    public void introduzir() {
        System.out.println("👹 Morga: \"Vocês, Sailors intrometidas, vão pagar por me desafiarem!\"");
    }
}