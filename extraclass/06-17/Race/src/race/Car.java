/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

import java.util.Random;

/**
 *
 * @author davibq
 */
public class Car {
    private final Engine engine;
    private double position = 0;
    private final String brand;
    private Wheels size;
    
    
    public Car(String brand, int horsepower, int wheels) {
        engine = new Engine(brand, horsepower, size);
        this.brand = brand;
        size = new Wheels(wheels);
    }

    
    
    public Wheels getwheelsize(){
        return size;
    }
    
    public double move() {
        Random rnd = new Random();
        float factor = rnd.nextFloat();
        double movement = Math.floor(factor * engine.getHorsepower() * size.getwheelfactor());
        
        position += movement;
        
        return position;
    }
    
    public double getPosition() {
        return position;
    }
    
    public String getBrand() {
        return brand;
    }
}
