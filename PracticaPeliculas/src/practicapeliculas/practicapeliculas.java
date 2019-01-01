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
    private static Usuario admin = new Usuario("Luis", "1234", 0, 0, 0);
    private static Usuario admin2 = new Usuario("Dani", "1234", 0, 0, 0);
    public static Peliculas peliculas =new Peliculas();
    //private static ArrayList<Usuario> usuario = new ArrayList<>(); 
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
        if (sePuede){
            System.out.println ("Usuario creado correctamente");
            System.out.println ("Ahora inicia sesión");
            acceder();
        }else{
            System.out.println ("No se puede crear usuario, es posible que el nick ya esté cogido");
            Inicio_Sesion();
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

        System.out.println("Mis amigos son:\n "+u.mis_amigos.toString()+"\n");
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println(" 1. Agregar amigo\n 2. Solicitudes recibidas\n 3. Volver\n");
        System.out.print ("Opcion: ");
        int opcion= entrada.nextInt(); 
        
        switch (opcion){
            case 1:      
                    boolean encontrado= false;
                    Scanner entrada3 = new Scanner (System.in);
                    System.out.println("Nick de tu amigo: ");
                    String nombreAmigo= entrada3.nextLine();
                        
                    for(Usuario usu: usuarios.getUsuarios()){
                        if(usu.getNick().equals(nombreAmigo)){
                            u.invitarAmigo(usu);
                            encontrado=true;
                            break;
                        }
                        }
                    if(!encontrado){
                        System.out.println("No existen usuarios con ese nombre\n");
                    }
                    funciones_Amigos(u);
                    break;
               
            case 2:                
                    System.out.println("Tus solicitudes recibidas son:\n(Recuerda que se aceptan/rechazan en orden)");
                    int cont=0;
                    for(int i=0; i<u.solicitudes_amigos_pendientes.length; i++){
                        if(u.solicitudes_amigos_pendientes[i]!=null){
                            cont++;
                            System.out.println(cont+".-"+u.solicitudes_amigos_pendientes[i].getNick());
                        }
                    }
                    System.out.println("¿Qué deseas hacer?\n 1:Aceptar/Rechazar\n 2:Volver\n");
                    Scanner entrada4 = new Scanner (System.in);
                    System.out.print ("Opcion: ");
                    int solicitud= entrada4.nextInt();
                    switch(solicitud){
                            case 1:
                                u.aceptarInvitacion(u.solicitudes_amigos_pendientes[0]);
                                funciones_Amigos(u);
                                break;
                            case 2: 
                                funciones_Amigos(u);
                                break;
                            default: System.out.println ("Opcion no reconocida");
                                     funciones_Amigos(u);
                                     break;
                    }
                    break;
                    
            case 3: 
                    opciones_perfil(u);
                    break;
        }
    }                         

    private static void funciones_Peliculas(Usuario u){
        
        System.out.println("--------------------------------");
        Pelicula p;
        Scanner entrada4 = new Scanner (System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println(" 1.Agregar película\n 2.Compartir película\n 3.Listado de películas\n 4.Críticas de películas\n 5.Volver");
        System.out.print ("Opcion: ");
        int opcion= entrada4.nextInt(); 
        
        switch (opcion){
            case 1: 
                    Scanner entrada5 = new Scanner (System.in);
                    System.out.print ("Dime el titulo: ");
                    String titulo = entrada5.nextLine();
                    System.out.print ("Dime el nombre del director: ");
                    String director = entrada5.nextLine();
                    System.out.print ("Dime el genero: ");
                    String genero = entrada5.nextLine();
                    System.out.print ("Dime el actor principal: ");
                    String actor = entrada5.nextLine();
                    System.out.print ("Dime el actriz principal: ");
                    String actriz = entrada5.nextLine();
                    System.out.print ("Dime el año: ");
                    int año = entrada5.nextInt();
                    Pelicula pelicula= new Pelicula(titulo,director,genero,actor,actriz,año);
                   
                    boolean sePuede = peliculas.anadirPelicula(pelicula, u);
                    if (sePuede){
                        opciones_perfil(u);
                    }else{
                        System.out.println ("Por favor, añade una peli nueva. La peli que has añadido ya existe");
                        funciones_Peliculas(u);
                    }
                    break;
            case 2: 
                    Scanner entrada6 = new Scanner (System.in);
                    System.out.println("¿De qué modo desea compartir?");
                    System.out.print("1. Compartir pelicula\n2. Compartir todo\nOpción:");
                    int opcion_compartir=entrada6.nextInt();
                    switch(opcion_compartir){
                        case 1:  
                                System.out.println("Este es el listado de titulos actualmente disponibles");
                                u.peliculas.listaPelis();  
                                System.out.print ("¿Qué película deseas compartir? ");
                                Scanner entrada7 = new Scanner (System.in);
                                String t = entrada7.nextLine();
                                Pelicula pe=new Pelicula(t,null,null,null,null,0);
                                
                                modo_comparticion(u,pe);
                                break;
                                  
                        case 2: //aqui tambien hay que meter una critica.(por hacer)
                            
                        default:System.out.println("Por favor, seleccione una opción correcta");
                                funciones_Peliculas(u);
                                break;
                            
                    }
                    
                    break;
            case 3: 
                    peliculas.verInfoPeliculas(u);
                    funciones_Peliculas(u);
                    break;
            
            case 4:
                    System.out.println("¿Que deseas hacer?\n 1:Ver críticas 2:Hacer una crítica");
                    System.out.print("Opcion:");
                    Scanner entrada7= new Scanner(System.in);
                    int opcion_critica= entrada7.nextInt();
                    Pelicula peli= new Pelicula();
                    switch(opcion_critica){
                        case 1:
                                System.out.println("Este es el listado de titulos actualmente disponibles");
                                u.peliculas.criticasPelis();   
                                break;
                        case 2:
                                u.peliculas.listaPelis();
                                Scanner entrada8 = new Scanner (System.in);
                                System.out.print ("Dime el titulo de la pelicula: ");
                                String tit = entrada8.nextLine();
                                System.out.print ("Escribe tu comentario acerca de la pelicula: ");
                                String com = entrada8.nextLine();
                                System.out.print ("¿Qué nota le pondrías?: ");
                                double nota = entrada8.nextDouble();
                                if(nota>10||nota<0){
                                    System.out.println("La nota debe ser entre 0 y 10\nVuelve a hacer la crítica");
                                    funciones_Peliculas(u);
                                    
                                }
                                Critica c= new Critica(tit, com, nota);
                                Pelicula p2=new Pelicula(tit, null, null, null, null,0);
                                u.anadirCritica(c,p2);
                    }
            case 5: 
                    opciones_perfil(u);
                    break;
                    
            default: System.out.println("Por favor, seleccione una opción correcta");
                    funciones_Peliculas(u);
                    break;
        }
    }
    

    public static void modo_comparticion(Usuario u,Pelicula p){
        int cont=0;
        System.out.println("--------------------------------");
        Scanner entrada8= new Scanner(System.in);
        System.out.print("Desea compartir la película con:\n1. Todos\n2. Un amigo\nOpción:");
        int seleccion= entrada8.nextInt();
        switch(seleccion){
            case 1: 
                    System.out.println("Compartiendo pelicula");
                    u.compartirPelicula(p);
                    funciones_Peliculas(u);
                    break;
            case 2: 
                    //Poner aqui lista de amigos
                    Scanner entrada2 = new Scanner (System.in);
                    System.out.println("Nick de tu amigo: ");
                    String nombreA= entrada2.nextLine();

                    for(Usuario usu: usuarios.getUsuarios()){
                        if(usu.getNick().equals(nombreA)){
                            System.out.print("Compartiendo pelicula\n");
                            u.compartirPelicula(p, usu);
                            cont++;
                            break;
                        }
                    }
                    if(cont==0){
                        System.out.println("No tienes amigos con ese nick");
                    }
                    funciones_Peliculas(u);
                    break;
            default: 
                    System.out.println("Por favor, seleccione una opción correcta");
                    modo_comparticion(u,p);
                    break;
        }
    }


    private static void funciones_Trivial(Usuario u){
        System.out.println("Chupamela luis");
    }
    
    private static void funciones_Muro(Usuario u){
        System.out.println("Chupamela luis");
    }
    
    
     private static void Cerrar_Sesion(Usuario u){
        
        System.out.println("--------------------------------");
        Scanner entrada3 = new Scanner (System.in);
        System.out.println("¿Desea cerrar sesión?");
        System.out.println(" 1.Si\n 2.No\n");
        System.out.print ("Opcion: ");
        int numero=entrada3.nextInt();
        
        switch(numero){
            case 1:    System.out.println("Cerrando sesión...");
                        Inicio_Sesion();
                        break;
            case 2:     System.out.println("Cancelando cierre de sesión");
                        opciones_perfil(u);
                        break;
            default:    System.out.println("Por favor, seleccione una opción correcta");
                        Cerrar_Sesion(u);
                        break;
                        
        }
        
    }
    
    private static void tratarOpcion(int opcion) {
        
        switch (opcion) {
            
            case 1: acceder ();
                      break;
            
            case 2: crearUsuario ();
                      break;
            default: System.out.println ("Opcion no reconocida");
        }
    }
    
    
     public static void Inicio_Sesion(){
        int opcion;
        System.out.println ("¿Qué deseas hacer?");
        System.out.println ("1- Acceder // 2- Registrarse");
        
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime una opcion: ");
        opcion = entrada.nextInt();       
        
       if(opcion!=0)
            tratarOpcion (opcion);
    }
     
    public static void main(String[] args) {
        // TODO code application logic here
            
        
        usuarios.registrar(admin);
        usuarios.registrar(admin2);
        
        Inicio_Sesion();
    }
}
