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
 * @author Acer
 */
public class Usuarios implements Serializable{
    
     private static ArrayList<Usuario> lista_usuarios; 
     
     public Usuarios(){  
         lista_usuarios = new ArrayList<Usuario>(); 
     }
     public ArrayList<Usuario> getUsuarios(){
         return lista_usuarios;
     }
     
     public void setUsuarios(ArrayList<Usuario> usuarios){
         Usuarios.lista_usuarios=usuarios;
     }
     
     public Usuario autenticar() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Usuario: ");
        String login = entrada.nextLine();
        System.out.print("Password: ");
        String pass = entrada.nextLine();
        for (Usuario u : lista_usuarios) {
            if (u.getNick().equals(login) && u.getClave().equals(pass)) {
                return u;
            }
        }
        return null;
    }
     
    //Evitar que se puedan crear dos usuarios con el mismo nick 
    public boolean registrar(Usuario nuevo) {
        
        boolean sePuede=true;
        for(Usuario u: lista_usuarios){
            if(u.getNick().contains(nuevo.getNick())){
                sePuede=false;
            }
        }
        if(sePuede==true){
            this.lista_usuarios.add(nuevo);
        }
        return sePuede;
        
        
       /* boolean sePuede = false;
        if (!usuarios.contains(nuevo)) {
            this.usuarios.add(nuevo);
            sePuede = true;
        }
        return sePuede;*/
    }
   
}
