package LabirintoLunar;

import java.util.ArrayList;

public abstract class Heroina extends Entidade {
    protected int nivel;
    protected int ouro;
    protected ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;

    public Heroina(String nome, int vidaMax, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, vidaMax, forca);
        this.nivel = nivel;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }

    // Getters
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

    // Setters
    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("\uD83C\uDF1F Nível: " + this.nivel);
        System.out.println("\uD83E\uDE99 Ouro: " + this.ouro);
        System.out.println("\uD83D\uDD2E Itens no inventário: " + this.inventario.size());
//        if (armaPrincipal != null) {
//            System.out.println("\uD83D\uDCAB Arma equipada: " + armaPrincipal.getNome());
//        } else {
//            System.out.println("\uD83D\uDCAB Sem arma equipada.");
//        }
        System.out.println("--------------------------------");
    }

    public void adicionarItem(Consumivel item) {
        this.inventario.add(item);
    }

    // Metodo abstrato obrigatório a implementar nas heroínas
    public abstract void atacar(Entidade inimigo);


}