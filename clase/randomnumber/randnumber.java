/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumber;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author ulacit
 */
public class randnumber {
    public static void main(String[] args) {
        
        Scanner number = new Scanner(System.in);
        int randnum = 1 + (int) (Math.random() * 99);
        int count = 0;
        int guess = 0;
        
        System.out.println("Adivina el numero entre el 1 al 100");
        
        
        while (guess != randnum) {
            guess = number.nextInt();
            count++;
            if (guess > randnum) {
                System.out.println("El numero es menor....");
                System.out.println("¿Otro numero?");
                
                
            }
            else if (guess < randnum) {
                System.out.println ("El numero es mayor.....");
                System.out.println("¿Otro numero?");
                
            }
            
            
        }
       System.out.println("¡Felicitaciones! Logro adivinar el numero en " + count + " intentos" );
        
        
    }
    
}
