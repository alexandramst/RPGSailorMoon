package LabirintoLunar.Entidades;

import LabirintoLunar.Itens.ArmaPrincipal;
import LabirintoLunar.Itens.Consumivel;
import LabirintoLunar.Enum.TipoHeroina;
import java.util.ArrayList;

/**
 * Classe abstrata que representa uma heroína jogável no Labirinto Lunar.
 * Cada heroína tem nível, ouro, uma arma principal, um inventário de consumíveis e um tipo específico.
 * Esta classe serve como base para as heroínas concretas (ex: SailorMoon, SailorMercurio, SailorMarte).
 */
public abstract class Heroina extends Entidade {

    protected int nivel;
    protected int ouro;
    protected ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;
    protected TipoHeroina tipo;

    /**
     * Construtor base da heroína.
     *
     * @param nome          Nome da heroína.
     * @param vidaMax       Vida máxima.
     * @param forca         Força base.
     * @param nivel         Nível inicial.
     * @param ouro          Ouro inicial.
     * @param armaPrincipal Arma equipada no início (pode ser null).
     * @param tipo          Tipo específico da heroína (ex: SAILOR_MOON, SAILOR_MARTE, etc).
     */
    public Heroina(String nome, int vidaMax, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal, TipoHeroina tipo) {
        super(nome, vidaMax, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
        this.tipo = tipo;
    }

    // Getters e Setters

    public int getNivel() {
        return nivel;
    }

    public int getOuro() {
        return ouro;
    }

    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    public TipoHeroina getTipo() {
        return tipo;
    }

    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    /**
     * Método utilitário para obter o nome da arma equipada ou "Sem arma" se não houver.
     * @return Nome da arma equipada ou "Sem arma".
     */
    public String getNomeArmaOuSemArma() {
        if (armaPrincipal != null) {
            return armaPrincipal.getNome();
        } else {
            return "Sem arma";
        }
    }

    /**
     * Mostra os detalhes da heroína na consola, incluindo nível, ouro,
     * arma equipada, inventário e tipo de heroína.
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("🌟 Nível: " + this.nivel);
        System.out.println("🪙 Ouro: " + this.ouro);
        System.out.println("🗡️ Arma equipada: " + getNomeArmaOuSemArma());
        System.out.println("🎒 Inventário: " + inventario.size() + " consumíveis");
        System.out.println("✨ Tipo: " + tipo);
        System.out.println("--------------------------------");
    }

    /**
     * Adiciona um consumível ao inventário da heroína.
     * @param item Consumível a adicionar.
     */
    public void adicionarItem(Consumivel item) {
        this.inventario.add(item);
    }

    /**
     * Método abstrato para combater um NPC.
     * Cada subclasse deverá implementar o seu próprio ataque com poderes/estilo único.
     * @param inimigo O NPC inimigo a combater.
     * @return true se a heroína vencer, false se for derrotada.
     */
    public abstract boolean atacar(NPC inimigo);
}