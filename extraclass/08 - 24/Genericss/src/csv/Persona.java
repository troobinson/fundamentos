/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csv;


public class Persona<T> {
    T name;
    T lastname;
    T age;

    
    

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getLastname() {
        return lastname;
    }

    public void setLastname(T lastname) {
        this.lastname = lastname;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
    Persona (T name, T lastname, T age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;

        
    }

}
