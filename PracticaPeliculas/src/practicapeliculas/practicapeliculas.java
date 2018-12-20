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
public class practicapeliculas implements Serializable{

    public static Usuarios usuarios= new Usuarios();
    //private static ArrayList<Usuario> usuario = new ArrayList<>(); 
    private static Usuario admin = new Usuario("Luis", "1234", 0, 0, 0);
    private static Usuario admin2 = new Usuario("Dani", "1234", 0, 0, 0);
    
    /**
     * @param args the command line arguments
     */
    
    private static void acceder (){
        
       Usuario u; 
       
        do{
            u = usuarios.autenticar ();
            if (u==null) {
               System.out.println ("Por favor, introduzca unos credeciales correctos");
            }
        }while (u==null);
        
        System.out.print ("Bienvenido");
        
        opciones_perfil(u);
    }
    private static void crearUsuario() {
        
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime el nick: ");
        String nick = entrada.nextLine();
        System.out.print ("Dime el pass: ");
        String pass = entrada.nextLine();
        
        Usuario nuevo = new Usuario (nick, pass, 0, 0, 0);
       
        boolean sePuede = usuarios.registrar(nuevo);
        if (sePuede) {
            System.out.println ("Usuario creado correctamente");
            System.out.println ("Ahora inicia sesión");
            acceder();
        }else {
            System.out.println ("No se puede crear usuario");
        }
    }
    
    private static void opciones_perfil(Usuario u){
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println(" 1. Mis amigos\n 2. Películas\n 3. Trivial\n 4. Muro\n 5. Cerrar sesión");
        System.out.print ("Opcion: ");
        int opcion= entrada.nextInt(); 
        
        switch (opcion){
            case 1: funciones_Amigos(u);
                    break;
            case 2: funciones_Peliculas(u);
                    break;
            case 3: funciones_Trivial(u);
                    break;
            case 4: funciones_Muro(u);
                    break;
            case 5: Cerrar_Sesion(u);
                    break;
            default: System.out.println ("Opcion no reconocida");
        } 
    }
    
    private static void funciones_Amigos(Usuario u){
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println(" 1. Agregar amigo\n 2. Solicitudes\n");
        System.out.print ("Opcion: ");
        int opcion= entrada.nextInt(); 
        
        switch (opcion){
            case 1: 
                boolean encontrado= false;
                    Scanner entrada2 = new Scanner (System.in);
                    System.out.println("Nick de tu amigo: ");
                    String nombreAmigo= entrada2.nextLine();
                    
                    for(Usuario usu: usuarios.getUsuarios()){
                        if(usu.getNick().equals(nombreAmigo));
                            u.invitarAmigo(usu);
                            encontrado=true;
                            break;
                    }
                    if(!encontrado){
                        System.out.println("No tienes amigos\n");
                    }
                    break;
                    
            //case 2: solicitudes(u);
              //      break;
            default: System.out.println ("Opcion no reconocida");
        } 
    }
    
    private static void funciones_Peliculas(Usuario u){
        System.out.println("Chupamela luis");
    }
    
    private static void funciones_Trivial(Usuario u){
        System.out.println("Chupamela luis");
    }
    
    private static void funciones_Muro(Usuario u){
        System.out.println("Chupamela luis");
    }
    
    private static void Cerrar_Sesion(Usuario u){
        System.out.println("Chupamela luis");
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
        int opcion;
      
        
        usuarios.registrar(admin);
        usuarios.registrar(admin2);
        
        System.out.println ("¿Qué deseas hacer?");
        System.out.println ("1- Acceder // 2- Registrarse");
        
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime una opcion: ");
        opcion = entrada.nextInt();       
        
       if(opcion!=0)
            tratarOpcion (opcion);
    }
}
