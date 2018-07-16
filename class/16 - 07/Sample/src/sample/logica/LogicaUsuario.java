/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.logica;
import java.util.ArrayList;
import java.util.List;
import sample.modelos.Usuario;
/**
 *
 * @author ulacit
 */
public class LogicaUsuario {
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> list = new ArrayList<>();
        list.add(new Usuario("David", 27));
        list.add(new Usuario("Jaime", 25));
        list.add(new Usuario("Marco", 22));
        list.add(new Usuario("Thomas", 18));
        return list;
        
    }
}
