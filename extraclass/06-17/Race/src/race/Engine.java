/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

/**
 *
 * @author davibq
 */
public class Engine {
    private final String brand;
    private final int horsepower;
    private int wheelsize;
    private final int size;
    
    public Engine(String brand, int horsepower, Wheels size) {
        this.brand = brand;
        this.horsepower = horsepower;
        this.size = wheelsize;
    }

    

    public int getHorsepower() {
        return horsepower;
    
    }
}
