/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author D.Palacios
 */
public class practicapeliculas implements Serializable{

    public static Plataforma plataforma;
    
    /**
     * @param args the command line arguments
     */
    
    private static void acceder (){
        
       Usuario usuario; 
       
        do{
            usuario = plataforma.acceder ();
            if (usuario==null) {
               System.out.println ("Por favor, introduzca unos credeciales correctos");
            }
        }while (usuario==null);
        
        System.out.print ("Bienvenido");
        
    }
    private static void crearUsuario() {
        
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime el nick: ");
        String nick = entrada.nextLine();
        System.out.print ("Dime el pass: ");
        String pass = entrada.nextLine();
        
        Usuario nuevo = new Usuario (nick, pass, 0, 0, 0);
       // System.out.print ("Hasta aqui llego");
       
        boolean sePuede = plataforma.crearUsuario(nuevo);
        if (sePuede) {
            System.out.println ("Usuario creado correctamente");
        }else {
            System.out.println ("No se puede crear usuario");
        }
    }
    private static void tratarOpcion(int opcion) {
        
        switch (opcion) {
            
            case 1: acceder ();
                      break;
            
            case 2: crearUsuario ();
                      break;
             
            case 0: System.out.println ("Adios");
                      break;
            default: System.out.println ("Opcion no reconocida");
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String opcion;
      
        System.out.println ("¿Qué deseas hacer?");
        System.out.println ("1- Acceder // 2- Registrarse");
        
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime una opcion: ");
        opcion = entrada.nextLine();
        
        int nuestraopcion= Integer.parseInt(opcion);
        
        
        do {
            tratarOpcion (nuestraopcion);
        }while (nuestraopcion!=0);  
    }
}
