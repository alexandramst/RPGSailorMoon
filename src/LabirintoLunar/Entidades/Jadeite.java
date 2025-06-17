package LabirintoLunar.Entidades;

/**
 * Representa o inimigo Jadeite, uma das personagens do Labirinto Lunar.
 */
public class Jadeite extends NPC {

    /**
     * Construtor do Jadeite.
     * Define vida, força e ouro específicos.
     */
    public Jadeite() {
        super("Jadeite", 80, 20, 30); // vida 80, força 20, ouro 30
    }

    /**
     * Introdução personalizada do Jadeite ao encontrar a heroína.
     */
    @Override
    public void introduzir() {
        System.out.println(" \uD83D\uDD74\uFE0FJadeite: \"Não ousem desafiar o império das trevas!!!\"");
    }
}