package LabirintoLunar;

import java.util.ArrayList;

/**
 * Representa uma sala no labirinto do jogo.
 */
public class Sala {

    private String descricao;
    private EventoSala evento;
    private ArrayList<Sala> proximasSalas;

    /**
     * Cria uma nova sala com um evento associado.
     * @param descricao Texto descritivo da sala
     * @param evento Tipo de evento associado à sala
     */
    public Sala(String descricao, EventoSala evento) {
        this.descricao = descricao;
        this.evento = evento;
        this.proximasSalas = new ArrayList<>();
    }

    /**
     * Mostra a descrição da sala.
     */
    public void mostrarDescricao() {
        System.out.println("📍 " + descricao);
    }

    /**
     * Executa o evento associado à sala.
     * @param heroina A heroína que entra na sala
     */
    public void entrar(Heroina heroina) {
        mostrarDescricao();
        evento.executar(heroina);
    }

    /**
     * Liga esta sala a outra.
     * @param sala Próxima sala possível
     */
    public void adicionarProximaSala(Sala sala) {
        proximasSalas.add(sala);
    }

    /**
     * Retorna as salas possíveis a seguir.
     * @return Lista de próximas salas
     */
    public ArrayList<Sala> getProximasSalas() {
        return proximasSalas;
    }
}