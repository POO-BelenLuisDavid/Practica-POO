/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author D.Palacios
 */
public class practicapeliculas implements Serializable{

    public static Usuarios usuarios;
    private static Usuario admin = new Usuario("Luis", "1234", 0, 0, 0);
    private static Usuario admin2 = new Usuario("Dani", "1234", 0, 0, 0);
    public static Peliculas peliculas;
     public static boolean fichero_cargado=false;
    
    /**
     * @param args the command line arguments
     */
    
    private static void acceder () throws IOException, FileNotFoundException, ClassNotFoundException{
       
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
    private static void crearUsuario() throws IOException, FileNotFoundException, ClassNotFoundException {
        
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
    
    private static void opciones_perfil(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        
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
    
    private static void funciones_Amigos(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{

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
                    opciones_perfil(u);
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
                                opciones_perfil(u);
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

    private static void funciones_Peliculas(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        System.out.println("--------------------------------");
        Pelicula p;
        Scanner entrada4 = new Scanner (System.in);
        System.out.println("¿Qué deseas hacer?");
        System.out.println(" 1.Agregar película\n 2.Compartir película\n 3.Listado de películas\n 4.Críticas\n 5.Volver");
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
                    String año = entrada5.nextLine();
                    Pelicula pelicula= new Pelicula(titulo,director,genero,actor,actriz,año);
                   
                    boolean sePuede = peliculas.anadirPelicula(pelicula, u);
                    if (sePuede){
                        peliculas.anadirPeliculaPropia(pelicula, u);
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
                                Pelicula pe=new Pelicula(t,null,null,null,null,null);
                                
                                modo_comparticion_pelicula(u,pe);
                                break;
                                  
                        case 2://(por hacer)no se como enfocarlo
                            
                        default:System.out.println("Por favor, seleccione una opción correcta");
                                funciones_Peliculas(u);
                                break;
                            
                    }
                    
                    break;
            case 3: 
                    System.out.println("Aquí se muestran todas tus pelis, tanto las que has creado como las que te han compartido");
                    peliculas.verInfoPeliculas(u);
                    funciones_Peliculas(u);
                    break;
            
            case 4:
                    
                    System.out.println("¿Que deseas hacer?\n 1:Hacer una crítica 2:Compartir una crítica");
                    System.out.print("Opcion:");
                    Scanner entrada7= new Scanner(System.in);
                    int opcion_critica= entrada7.nextInt();
                    Pelicula peli= new Pelicula();
                    switch(opcion_critica){
                        
                        case 1:
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
                                Pelicula p2=new Pelicula(tit, null, null, null, null,null);
                                u.anadirCritica(c,p2);
                                break;
                                
                        case 2:
                                System.out.println("Este es tu listado de críticas actualmente disponibles");
                                u.peliculas.listaCriticas();                     
                                System.out.print ("Dime el titulo de la pelicula: ");
                                Scanner entrada = new Scanner (System.in);
                                String titulo1 = entrada.nextLine();
                                Critica c2= new Critica(titulo1, null, 0);
                                modo_comparticion_critica(c2, u);   
                                break;
                    }
                    
            case 5: 
                    opciones_perfil(u);
                    break;
                    
            default: System.out.println("Por favor, seleccione una opción correcta");
                    funciones_Peliculas(u);
                    break;
        }
    }
    

    public static void modo_comparticion_pelicula(Usuario u,Pelicula p) throws IOException, FileNotFoundException, ClassNotFoundException{
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
                    System.out.println("Mis amigos son:\n "+u.mis_amigos.toString()+"\n");
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
                    modo_comparticion_pelicula(u,p);
                    break;
        }
    }
    
    public static void modo_comparticion_critica(Critica c, Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        int cont=0;
        System.out.println("--------------------------------");
        Scanner entrada8= new Scanner(System.in);
        System.out.print("Desea compartir la critica con:\n1. Todos\n2. Un amigo\nOpción:");
        int seleccion= entrada8.nextInt();
        switch(seleccion){
            case 1: 
                    System.out.println("Compartiendo critica");
                    u.compartirCritica(c);
                    funciones_Peliculas(u);
                    break;
            case 2: 
                    System.out.println("Mis amigos son:\n "+u.mis_amigos.toString()+"\n");
                    Scanner entrada2 = new Scanner (System.in);
                    System.out.println("Nick de tu amigo: ");
                    String nombreA= entrada2.nextLine();

                    for(Usuario usu: usuarios.getUsuarios()){
                        if(usu.getNick().equals(nombreA)){
                            System.out.print("Compartiendo crítica\n");
                            u.compartirCritica(c, usu);
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
                    modo_comparticion_critica(c, u);
                    break;
        }
        
    }


    private static void funciones_Trivial(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        Partida pa = new Partida();
        ArrayList<Pelicula> copia = u.peliculas.getPeliculas();
        
        Scanner entrada = new Scanner (System.in);
        System.out.println();
        System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
        System.out.println("|/|        TRIVIAL        |/|");
        System.out.println("|/|-----------------------|/|");
        System.out.println("|/| 1. Iniciar Partida    |/|\n|/| 2. Completar Partida  |/|\n"
                + "|/| 3. Compartir Partida  |/|\n|/| 4. Volver             |/|");
        System.out.println("|/|/|/|/|/|/|/|/|/|/|/|/|/|/|");
        System.out.print ("Opcion: ");
        int opcion= entrada.nextInt();
        System.out.println();
        
        
        switch (opcion){
            case 1: 
                int aux=0;
                for(Pelicula peli: copia){
                    aux++;
                }
            if(copia.isEmpty()){
                System.out.println("No hay suficientes películas para jugar");
                opciones_perfil(u);
                break;
            }
            else if(aux<5){
                System.out.println("No hay suficientes películas para jugar");
                opciones_perfil(u);
                break;
            }
            else{
                u.iniciarPartida(u);
                opciones_perfil(u);
                break;
            }
            case 2: 
                    if(u.partidas.isEmpty()){
                        System.out.println("No tienes partidas pendientes");
                    }
                    else{
                        u.completarPartida(u, pa);
                    }
                    opciones_perfil(u);
                    break;
            case 3: u.compartirPArtida(pa);//Mirar Esto
                    break;
            case 4: System.out.println();
                    
                    opciones_perfil(u);
            default: System.out.println ("Introduzca una opción correcta");
        } 
    }
    
    private static void funciones_Muro(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        System.out.println("Muro:\nAquí podrás ver tu actividad en la apliación.");
        Scanner entrada = new Scanner (System.in);
        System.out.println(" 1. Mis críticas\n 2. Películas\n 3. Criticas compartidas conmigo\n 4. Trivial\n 5. Volver");
        System.out.print ("Opcion: ");
        int opcion= entrada.nextInt(); 
        
        switch (opcion){
            case 1:     
                    System.out.println("Este es el listado de titulos actualmente disponibles");
                    u.peliculas.criticasPelis();
                    funciones_Muro(u);
                    break;
                    
            case 2: 
                    System.out.println("Aqui podrás ver las peliculas que has subido tú o las que te han enviado");
                    System.out.print("Elige una opción\n1. Peliculas subidas por mí\n2. Peliculas compartidas conmigo\n");
                    System.out.print ("Opción: ");
                    int opcion2= entrada.nextInt();
                    switch(opcion2){
                        case 1:
                                System.out.println("Este es tu listado de pelis propio");
                                peliculas.verInfoPeliculasPropias(u);
                                funciones_Muro(u);
                        
                        case 2:
                                System.out.println("Este es el listado de pelis que han compartido contigo");
                                peliculas.verInfoPeliculasCompartidas(u);
                                funciones_Muro(u);
                    }
                    break;
            case 3: 
                    System.out.println("Estas son las críticas de las peliculas que tus amigos han compartido contigo");
                    peliculas.listaCriticasCompartidas(u);
                    System.out.println("Volviendo al muro");
                    funciones_Muro(u);
                    break;
            case 4: 
                    System.out.println(("Aquí podrás ver todo lo relacionado a tus partidas de trivial y a las de tus amigos"));
                    break;                   
            case 5:
                    opciones_perfil(u);
            default: System.out.println ("Opcion no reconocida");
        } 
    }
    
    
     private static void Cerrar_Sesion(Usuario u) throws IOException, FileNotFoundException, ClassNotFoundException{
        
        System.out.println("--------------------------------");
        Scanner entrada3 = new Scanner (System.in);
        System.out.println("¿Desea cerrar sesión?");
        System.out.println(" 1.Si\n 2.No\n");
        System.out.print ("Opcion: ");
        int numero=entrada3.nextInt();
        
        switch(numero){
            case 1:    GuardarFichero(usuarios, u.peliculas);
                        fichero_cargado=false;
                        break;
            case 2:     System.out.println("Cancelando cierre de sesión");
                        opciones_perfil(u);
                        break;
            default:    System.out.println("Por favor, seleccione una opción correcta");
                        Cerrar_Sesion(u);
                        break;
                        
        }
        
    }
    
    private static void tratarOpcion(int opcion) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        switch (opcion) {
            
            case 1: if(!fichero_cargado){
                    usuarios= new Usuarios();
                    peliculas=new Peliculas();
                    usuarios.registrar(admin);
                    usuarios.registrar(admin2);
                    } 
                    
                    acceder ();
                      break;
            
            case 2: if(!fichero_cargado){
                    usuarios= new Usuarios();
                    peliculas=new Peliculas();
                    usuarios.registrar(admin);
                    usuarios.registrar(admin2);
                    } 
                    crearUsuario ();
                      break;
            
            case 3: usuarios= new Usuarios(); 
                    peliculas=new Peliculas();
                    CargarFichero(); 
                    break;
            case 4: break;
                    
            default: System.out.println ("Opcion no reconocida");
                    break;
        }
    }
    
    
     public static void Inicio_Sesion() throws IOException, FileNotFoundException, ClassNotFoundException{
        int opcion;
        System.out.println ("¿Qué deseas hacer?");
        System.out.println ("1- Acceder // 2- Registrarse // 3- Cargar fichero // 4-Cerrar aplicacion");
        
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime una opcion: ");
        opcion = entrada.nextInt();       
        
       if(opcion!=0)
            tratarOpcion (opcion);
    }

     
      public static void GuardarFichero(Usuarios u,Peliculas p) throws FileNotFoundException, IOException, ClassNotFoundException{
         
        /*Scanner entrada4 = new Scanner (System.in);
        System.out.print("¿En qué fichero desea guardar la información?");
        String fichero=entrada4.nextLine();*/
        File fichero= new File("prueba.txt");
         
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        
        oos.writeObject(usuarios.getUsuarios());
        oos.writeObject(peliculas.getPeliculas());
        oos.writeObject(peliculas.getCriticas());
        oos.writeObject(peliculas.getCriticasCompartidas());
        oos.writeObject(peliculas.getPeliculasCompartidas());
        oos.writeObject(peliculas.getPeliculasCreadas());
       
        oos.close();
       
        System.out.println("Cerrando sesión...");
        Inicio_Sesion();
    }
     
      public static void CargarFichero()throws IOException,FileNotFoundException, ClassNotFoundException{
            
            File fichero= new File("prueba.txt");
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero));
            
            usuarios.setUsuarios((ArrayList <Usuario>)entrada.readObject());
            peliculas.setPeliculas((ArrayList<Pelicula>)entrada.readObject());
            peliculas.setCriticas((ArrayList<Critica>)entrada.readObject());
            peliculas.setCriticasCompartidas((ArrayList<Critica>)entrada.readObject());
            peliculas.setPeliculasCompartidas((ArrayList<Pelicula>)entrada.readObject());
            peliculas.setPeliculasCreadas((ArrayList<Pelicula>)entrada.readObject());
            
            System.out.println("Fichero cargado con exito.\n");
            fichero_cargado=true;
            Inicio_Sesion();
            
     }
     
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        // TODO code application logic here
                    
        Inicio_Sesion();
        
    }
}
