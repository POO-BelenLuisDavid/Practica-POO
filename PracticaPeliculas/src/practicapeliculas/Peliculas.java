/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Peliculas {
    
    private ArrayList<Pelicula> peliculas= new ArrayList<Pelicula>();
    
    public void anadirPeliculas(Pelicula p){
        if(peliculas.contains(p)){
            System.out.println("La película ya existe");
        }else{
            peliculas.add(p);
        }
        
    }
    
    public void verInfoPeliculas(){
        for(Pelicula p:peliculas){
            System.out.println(p);
            System.out.println("--------------------------------");
        }
    }
    
}
