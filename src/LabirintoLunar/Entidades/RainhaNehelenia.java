package LabirintoLunar.Entidades;

/**
 * Construtor da Rainha Nehelenia.
 * Define vida, força e ouro específicos para a Morga.
 */
public class RainhaNehelenia extends NPC {

    public RainhaNehelenia() {
        super("Rainha Nehelenia", 130, 40, 150);
    }

    @Override
    public void introduzir() {
        System.out.println("\n🌑 Rainha Nehelenia: Iludiste-te com a esperança, Sailor... Nunca sairás das Trevas! Muahahahah");
    }
}