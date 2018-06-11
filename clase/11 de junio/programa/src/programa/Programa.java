
package programa;

import fundamentos.Automotor;
/**
 *
 * @author ulacit
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Automotor auto = new Automotor();
      auto.Encender();
      auto.setLlantas(4);
      auto.Encender();
      auto.Apagar();
      auto.Apagar();
      Automotor moto = new Automotor();
      moto.setLlantas(2);
      moto.Encender();
      moto.Encender();
      moto.Apagar();
      moto.Apagar();
      
    }
    
}
