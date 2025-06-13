package LabirintoLunar;

import java.util.ArrayList;

/**
 * Consumível que causa dano instantâneo.
 */
public class ConsumivelCombate extends Consumivel {

     private int ataqueInstantaneo;

     public ConsumivelCombate(String nome, int preco, ArrayList<String> heroinasPermitidas, int ataqueInstantaneo) {
          super(nome, preco, heroinasPermitidas);
          this.ataqueInstantaneo = ataqueInstantaneo;
     }

     public int getAtaqueInstantaneo() {
          return ataqueInstantaneo;
     }

     @Override
     public void mostrarDetalhes() {
          System.out.println("⚔️ Consumível de Combate: " + nome);
          System.out.println("Preço: " + preco + " ouro");
          System.out.println("Ataque Instantâneo: " + ataqueInstantaneo);
          System.out.println("Permitido para: " + heroinasPermitidas);
     }
}