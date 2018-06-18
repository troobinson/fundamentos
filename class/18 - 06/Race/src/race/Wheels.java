/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

/**
 *
 * @author ulacit
 */
public class Wheels {

   private final int wheelsize;
   
   private final int Max_Wheel_size;
   
   public Wheels(int size) {
        this.Max_Wheel_size = 20;
        this.wheelsize = size;
       
} public int getwheelfactor() {
    float wfactor = wheelsize/20f;
    return wheelsize;
}
}
