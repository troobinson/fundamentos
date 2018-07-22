/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Usuario.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ulacit
 */
public class Logica {

    /*public List<Usuario> getusers() {
        List<Usuario> list = new ArrayList<>();
        list.add(new Usuario("thomas@gmail.com", "thomas123"));
        return null;

    }*/

    public boolean isValid(String user, String pass) {
        boolean retVal;
        retVal = user.endsWith("@gmail.com") || user.endsWith("@hotmail.com");
        if (retVal == false) {
            return false;
        } else {
            return true;
        }
        

    }


        
    }
