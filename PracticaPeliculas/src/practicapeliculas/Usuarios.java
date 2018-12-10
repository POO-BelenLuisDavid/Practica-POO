/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Usuarios {
    
    //Usuario u;
    
    public void autentica(Usuario u){
        
        
        String usu = "";
        String contra = "";
        Scanner usuario = new Scanner(System.in);
        Scanner contrasena = new Scanner(System.in);
        usu = usuario.nextLine();
        contra = contrasena.nextLine();
        
        if ((usu.equals()) || (contra.equals())){ //falta meter los String de los usuarios y las contraseñas registradas
            System.out.print("Sesion iniciada");
        }
        else{
            System.out.print("Usuario incorrecto");
        }
        
        
    }
    
    public void registrar(Usuario u){
        
        String usu = "";
        String contra = "";
        Scanner usuario = new Scanner(System.in);
        Scanner contrasena = new Scanner(System.in);
        usu = usuario.nextLine();
        contra = contrasena.nextLine();
    }
    
}
