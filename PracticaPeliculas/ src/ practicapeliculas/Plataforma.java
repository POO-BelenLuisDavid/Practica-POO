/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author D.Palacios
 */
public class Plataforma implements Serializable{
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    
    public Usuario acceder() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Usuario: ");
        String login = entrada.nextLine();
        System.out.print("Password: ");
        String pass = entrada.nextLine();
        for (Usuario u : usuarios) {
            if (u.getNick().equals(login) && u.getClave().equals(pass)) {
                return u;
            }
        }
        return null;
    }
     
    public boolean crearUsuario(Usuario nuevo) {
        boolean sePuede = false;
        if (!usuarios.contains(nuevo)) {
            this.usuarios.add(nuevo);
            sePuede = true;
        }
        return sePuede;
    }
}
