package LabirintoLunar;

/**
 * Classe abstrata que representa um evento que ocorre quando a heroína entra numa sala.
 */
public abstract class EventoSala {

    /**
     * Executa o evento da sala.
     * @param heroina A heroína que entrou na sala.
     */
    public abstract void executar(Heroina heroina);
}