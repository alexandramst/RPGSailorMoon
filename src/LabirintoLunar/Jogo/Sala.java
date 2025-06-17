package LabirintoLunar.Jogo;

import LabirintoLunar.Enum.TipoEvento;
import LabirintoLunar.Enum.Direcao;
import java.util.HashMap;
import java.util.Map;

/**
 * Representa uma sala do labirinto, com possíveis ligações a outras salas e um evento.
 */
public class Sala {
    private String nome;
    private String descricao;
    private TipoEvento evento;
    private Map<Direcao, Sala> ligacoes; //Para criar o mapa da direção para Sala vizinha

    /**
     * Construtor.
     * @param nome Nome da sala.
     * @param descricao Descrição da sala.
     * @param evento Evento inicial da sala.
     */
    public Sala(String nome, String descricao, TipoEvento evento) {
        this.nome = nome;
        this.descricao = descricao;
        this.evento = evento;
        this.ligacoes = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoEvento getEvento() {
        return evento;
    }

    public void setEvento(TipoEvento evento) {
        this.evento = evento;
    }

    public void ligarSala(Direcao direcao, Sala sala) {
        ligacoes.put(direcao, sala);
    }

    public Sala getSalaVizinha(Direcao direcao) {
        return ligacoes.get(direcao);
    }

    public Map<Direcao, Sala> getLigacoes() {
        return ligacoes;
    }
}