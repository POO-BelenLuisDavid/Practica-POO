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
    
    private static ArrayList<Pelicula> peliculas;
    
    private static ArrayList<Critica> criticas;
    
    public Peliculas(){  
         peliculas = new ArrayList<Pelicula>(); 
         criticas = new ArrayList<Critica>();
     }
    
    public ArrayList<Pelicula> getPeliculas(){
        return peliculas;
    }
    
   public ArrayList<Critica> getCriticas(){
        return criticas;
    }
    
    public void listaPelis(){
        int cont=0;
        System.out.println("Tu lista de peliculas:");
        for(Pelicula p: peliculas){
            cont++;
            System.out.println(cont+".-"+p.getTitulo());
        }
    }
    
    public boolean anadirPelicula(Pelicula p){
        boolean sePuede=false;
        
        
        
        if(peliculas.contains(p)){
            System.out.println("La película ya existe");
        }else{
            this.peliculas.add(p);
            System.out.println("Pelicula añadida correctamente");
            sePuede=true;
        }
        return sePuede;
    }
    
    public void verInfoPeliculas(){
        int cont=0;
        System.out.println("Tu lista de peliculas:");
        for(Pelicula p: peliculas){
            cont++;
            System.out.println(cont+".-"+p.getTitulo());
        }
        System.out.println("¿De que peli quieres ver información?");   
        Scanner pelicula = new Scanner(System.in);
        System.out.println("Titulo de la pelicula:");
        String titulo = pelicula.nextLine();
        
        int cont2=0;
        for(Pelicula p:peliculas){
            if(p.getTitulo().equals(titulo)){
                System.out.println(p);
                cont2++;
            }
        }    
        if(cont2==0){
            System.out.println("Titulo erroneo");
        }
        
    }
    
    
    public void anadirCritica(Critica c, Pelicula p){
        Critica crit=new Critica();
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
 
    
    public void criticasPelis(){
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
    
}
