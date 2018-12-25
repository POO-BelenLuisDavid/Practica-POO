/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

/**
 *
 * @author Acer
 */
public class Critica {
    
    String pelicula, texto;
    double puntuacion;
    
    
    public Critica(String p, String t, double pun){
        this.pelicula=p;
        this.texto=t;
        this.puntuacion=pun;
    }
    
    public String getPelicula(){
        return this.pelicula;
    }
    public String getTexto(){
        return this.texto;
    }
    public Double getPunt(){
        return this.puntuacion;
    }
    public void setPelicula(String p){
        this.pelicula=p;
    }
    public void setTexto(String texto){
        this.texto=texto;
    }
    public void setPuntuacion(Double punt){
        this.puntuacion=punt;
    }
    
    @Override
    public String toString(){
        String cadena="critica de la película "+this.getPelicula()+": "+this.getTexto();
        cadena=cadena+". Puntuación: "+this.getPunt()+"\n";
        return cadena;
    }
}
