/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Usuarios {
    
     private static ArrayList<Usuario> usuarios; 
     
     public Usuarios(){  
         usuarios = new ArrayList<Usuario>(); 
     }
     public ArrayList<Usuario> getUsuarios(){
         return usuarios;
     }
     
     public Usuario autenticar() {
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
     
    //Evitar que se puedan crear dos usuarios con el mismo nick 
    public boolean registrar(Usuario nuevo) {
        boolean sePuede = false;
        if (!usuarios.contains(nuevo)) {
            this.usuarios.add(nuevo);
            sePuede = true;
        }
        return sePuede;
    }
}
