/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.sample;

import java.util.Random;

/**
 *
 * @author ulacit
 */
public class ArraySample {

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static void main(String[] args) {
        Random rand = new Random();

// nextInt as provided by Random is exclusive of the top value so you need to add 1 
        /*int randomNum = rand.nextInt();*/
        int[] arreglo;
        int [] arreglo2;
        arreglo = new int[5];
        arreglo2 = new int[5];
        System.out.println("ARREGLO 1");
        System.out.println("");

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = getRandomNumberInRange(0, 10);
            System.out.println(arreglo[i]);

        }
        System.out.println("");
        System.out.println("ARREGLO 2");
        for (int j =0; j < arreglo2.length; j++) {
            arreglo2[j] = getRandomNumberInRange(0, 10);
            System.out.println(arreglo2[j]);
        }
        System.out.println("");
    }
}
