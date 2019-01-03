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
public class Peliculas {
    
    private  ArrayList<Pelicula> peliculas;  
    private  ArrayList<Critica> criticas;
    private  ArrayList<Critica> criticas_compartidas;
    //Usuario usuarios =new Usuario();
    
    
    public Peliculas(){  
         peliculas = new ArrayList<Pelicula>(); 
         criticas = new ArrayList<Critica>();
         criticas_compartidas = new ArrayList<Critica>();
     }
    
    public ArrayList<Pelicula> getPeliculas(){
        return peliculas;
    }
    
   public ArrayList<Critica> getCriticas(){
        return criticas;
    }
   
   public ArrayList<Critica> getCriticasCompartidas(){
       return criticas_compartidas;
   }
    
    public boolean anadirPelicula(Pelicula p, Usuario u){ //Comprueba si hay alguna peli con el mismo titulo y la añade si no existe
         boolean sePuede=true;
         for(Pelicula peli: u.peliculas.getPeliculas()){
             if(peli.getTitulo().contains(p.getTitulo())){
                 sePuede=false;
             }
         }
         if(sePuede==true){
             u.peliculas.getPeliculas().add(p);
             System.out.println("Pelicula añadida correctamente");
         }
         return sePuede;
    }

   
    public void listaPelis(){ //Listado de pelis
        int cont=0;
        System.out.println("Tu lista de peliculas:");
        for(Pelicula p: peliculas){
            cont++;
            System.out.println(cont+".-"+p.getTitulo());
        }
    }
    
    public void verInfoPeliculas(Usuario u){ //Muestra la información de cada pelicula
        int cont=0;
        boolean sePuede=true;
        if(u.peliculas.getPeliculas().isEmpty()){
            System.out.println("No tienes peliculas");
            System.out.println("Volviendo al menu");
            sePuede=false;
        }
        
        if(sePuede==true){
            System.out.println("Tu lista de peliculas:");
            for(Pelicula p: u.peliculas.getPeliculas()){
                cont++;
                System.out.println(cont+".-"+p.getTitulo());
            }
            System.out.println("¿De que peli quieres ver información?");   
            Scanner pelicula = new Scanner(System.in);
            System.out.println("Titulo de la pelicula:");
            String titulo = pelicula.nextLine();

            int cont2=0;
            for(Pelicula p:u.peliculas.getPeliculas()){
                if(p.getTitulo().equals(titulo)){
                    System.out.println(p);
                    cont2++;
                }
            }    
            if(cont2==0){
                System.out.println("Titulo erroneo");
            }      
        }
    }
    
    public void anadirCritica(Critica c, Pelicula p){ //Añade una critica de una peli si esta existe
        int cont=0;
        for(Pelicula peli: peliculas){
            if(peli.getTitulo().equals(p.getTitulo())){
                if(criticas.contains(c)){//Esto no funciona, puedo meter dos criticas totalmente igual en una misma peli
                    System.out.println("Ya hay critica de esta pelicula");
                    break;
                }
                criticas.add(c);
                System.out.println("Critica realizada!");
                cont++;
            }    
        }
        if(cont==0){
            System.out.println("No existe una peli con este titulo");
            System.out.println("Critica no realizada"); 
            } 
    } 
    
    public void listaCriticas(){ //Muestra una lista de los titulos de las criticas disponibles (para compartirlas)
        int cont=0;
        System.out.println("Tu lista de peliculas con criticas:");
        for(Critica c: criticas){
            cont++;
            System.out.println(cont+".-"+c.getPelicula());
        }
    }
    
    public void criticasPelis(){ //Muestra la información de una crítica
        int cont=0;
        int cont2=0;
        for(Pelicula p: peliculas){
            cont++;
            System.out.println(cont+".-"+p.getTitulo());
        }
        System.out.println("¿De que peli quieres ver la crítica?"); 
        Scanner pelicula = new Scanner(System.in);
        System.out.println("Titulo de la pelicula:");
        String titulo = pelicula.nextLine();
        
        for(Critica c: criticas){
            if(!criticas.isEmpty()){
                if(c.getPelicula().equals(titulo)){
                    System.out.println(c);
                    cont2++;
                }
                else{
                    System.out.println("Esta peli no existe o aun no tiene critica");
                    cont2++;
                }   
            }        
        }
        if(cont2==0){//Este else no funciona
            System.out.println("Aun no hay criticas registradas");
        }
    }
    
    public void anadirCriticaCompartida(Critica c, Usuario u){ //Añade una critica que un usuario comparte con otro
        //Esto no funciona
        u.criticas_compartidas.add(c);
        System.out.println(c);
        System.out.println("Crítica enviada");
        
    }
    
    public void listaCriticasCompartidas(Usuario u){ //Lista de criticas que un usuario comparte con otro
        int cont=0;
        int cont2=0;
        System.out.println("Tu lista de criticas compartidas:");
        for(Critica c:u.criticas_compartidas){
            cont++;
            System.out.println(cont+".-"+c.getPelicula());
        }
        if(cont==0){
            System.out.println("Aun no han compartido críticas contigo");
        }

        System.out.println("¿De que peli quieres ver la crítica?"); 
        Scanner pelicula = new Scanner(System.in);
        System.out.println("Titulo de la pelicula:");
        String titulo = pelicula.nextLine();
        
        for(Critica c: u.criticas_compartidas){
            if(c.getPelicula().equals(titulo)){
                System.out.println(c);
                cont2++;
            } 
        }
        if(cont2==0){
                System.out.println("Error al introducir el nombre de la pelicula");
            }  
    }
}
    
