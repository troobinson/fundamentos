/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class CSV {
    String name;
    String age;
    String lastname;
    

    public static void main(String[] args) {
        Persona pers1 = new Persona("Thomas", "Robinson", "18");
        String name = null;
        String lastname = null;
        String age = null;
        //String name = "Juan";
        //String lastname = "Perez";
        //String age = "56";
        String filepath = "pers.txt";
        pers1.setName(name);
        pers1.setLastname(lastname);
        pers1.setAge(age);
        
        pers1.getName();
        pers1.getLastname();
        pers1.getAge();
        
        

        saveRecord(name, lastname, age, filepath);
        

    }
    

   /* public CSV(String name, String lastname, String age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;

    }*/
    
    
    public static void saveRecord(String name, String lastname, String age, String filepath) {

        try {
            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(name + "," + lastname + "," + age + "\n");
            pw.print(name + "," + lastname + "," + age + "\n");
            pw.print(name + "," + lastname + "," + age+ "\n");
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro no guardado exitosamente");

        }
    }

}
