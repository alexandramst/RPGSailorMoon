package LabirintoLunar.Itens;

import LabirintoLunar.Cores.ConsoleColors;
import LabirintoLunar.Enum.TipoHeroina;
import java.util.ArrayList;

/**
 * Consumível de combate: item que pode ser usado para causar dano imediato ao inimigo.
 * Por exemplo: granadas, papéis de exorcismo, etc.
 */
public class ConsumivelCombate extends Consumivel {

     private int ataqueInstantaneo;

     /**
      * Construtor do consumível de combate.
      *
      * @param nome Nome do item.
      * @param preco Preço do item em ouro.
      * @param heroinasPermitidas Lista de tipos de heroínas que podem usar o item.
      * @param ataqueInstantaneo Valor de ataque instantâneo ao ser usado.
      */
     public ConsumivelCombate(String nome, int preco, ArrayList<TipoHeroina> heroinasPermitidas, int ataqueInstantaneo) {
          super(nome, preco, heroinasPermitidas);
          this.ataqueInstantaneo = ataqueInstantaneo;
     }

     /**
      * Obtém o valor de ataque instantâneo do consumível de combate.
      * @return ataque instantâneo
      */
     public int getAtaqueInstantaneo() {
          return ataqueInstantaneo;
     }

     /**
      * Mostra na consola os detalhes do consumível de combate.
      */

     @Override
     public void mostrarDetalhes() {
          System.out.print("Consumivel Combate" +nome +
                  "\nPreço: " + preco +
                  "\nAtaque Instantâneo: " + ataqueInstantaneo +
                  "\nPermitido para: ");

          if (heroinasPermitidas.isEmpty()) {
               System.out.println("Todas as Heroínas 🌠");
          } else {
               System.out.println(heroinasPermitidas);
          }
          System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT +"⋆☆✮✪✮☆⋆ \n" + ConsoleColors.RESET);
     }


}
