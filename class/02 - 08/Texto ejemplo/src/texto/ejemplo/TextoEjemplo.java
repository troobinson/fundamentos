/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texto.ejemplo;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author ulacit
 */
public class TextoEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String sTexto = "Hola soy Thomas";
        StringTokenizer frase = new StringTokenizer(sTexto);
        Stack<String> pila = new Stack<>();
        while (frase.hasMoreTokens()) {
            pila.push(frase.nextToken());
        }
        while (!pila.empty()) {
            System.out.print(pila.pop() + " ");
        }
    }
}
