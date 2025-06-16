package LabirintoLunar.Jogo;

import LabirintoLunar.Enum.TipoEvento;
import LabirintoLunar.Enum.Direcao;

/**
 * Classe responsável pela construção e gestão do labirinto do jogo.
 * Mantém a referência à sala atual, inicializa o mapa e permite navegação.
 */
public class Labirinto {

    private Sala salaAtual;
    private Sala salaFinal;

    /**
     * Construtor do labirinto. Cria as salas e as ligações de acordo com o mapa.
     */
    public Labirinto() {
        // Criação das salas (nomes e descrições à tua escolha)
        Sala vendedor = new Sala("Sala do Vendedor", "O vendedor misterioso está aqui!", TipoEvento.VENDEDOR);
        Sala salaA = new Sala("Sala A", "Corredor escuro e silencioso.", TipoEvento.SALA_VAZIA);
        Sala salaB = new Sala("Sala B", "Uma sala húmida e fria.", TipoEvento.SALA_VAZIA);
        Sala salaC = new Sala("Sala C", "Ouves ecos de longe.", TipoEvento.SALA_VAZIA);
        Sala salaD = new Sala("Sala D", "Luz ténue no chão.", TipoEvento.SALA_VAZIA);
        Sala salaE = new Sala("Sala E", "Paredes cobertas de símbolos.", TipoEvento.SALA_VAZIA);
        Sala salaF = new Sala("Sala F", "Ar cheiro a incenso.", TipoEvento.SALA_VAZIA);
        Sala finalSala = new Sala("Portal da Lua", "A saída do Labirinto Lunar!", TipoEvento.FINAL);
        this.salaFinal = finalSala;

        // Ligações entre salas conforme diagrama do mapa
        vendedor.ligarSala(Direcao.ESQUERDA, salaA);
        vendedor.ligarSala(Direcao.FRENTE, salaB);
        vendedor.ligarSala(Direcao.DIREITA, salaC);

        salaA.ligarSala(Direcao.FRENTE, salaD);
        salaB.ligarSala(Direcao.FRENTE, salaE);
        salaC.ligarSala(Direcao.FRENTE, salaF);

        salaD.ligarSala(Direcao.FRENTE, finalSala);
        salaE.ligarSala(Direcao.FRENTE, finalSala);
        salaF.ligarSala(Direcao.FRENTE, finalSala);

        // A sala inicial é a do vendedor
        this.salaAtual = vendedor;
    }

    /**
     * Obtém a sala onde o jogador se encontra.
     * @return Sala atual.
     */
    public Sala getSalaAtual() {
        return salaAtual;
    }

    /**
     * Atualiza a sala atual do jogador.
     * @param sala Nova sala atual.
     */
    public void setSalaAtual(Sala sala) {
        this.salaAtual = sala;
    }

    /**
     * Verifica se o jogador chegou à sala final (saída).
     * @return true se for a sala final.
     */
    public boolean chegouAoFinal() {
        return salaAtual == salaFinal;
    }
}