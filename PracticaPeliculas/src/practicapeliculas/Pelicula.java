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
public class Pelicula {
    
    String titulo, director, genero, actor, actriz;
    int año;
    
    
    public Pelicula(String t, String d, String g, String a_m, String a_f, int a){
            this.titulo=t;
            this.director=d;
            this.genero=g;
            this.actor= a_m;
            this.actriz=a_f;
            this.año= a;
    }
    
    public String getTitulo(){
        return this.titulo;
    }
    public String getDirector(){
        return this.director;
    }
    public String getGenero(){
        return this.genero;
    }
    public String getActor(){
        return this.actor;
    }
    public String getActriz(){
        return this.actriz;
    }
    public int getAño(){
        return this.año;
    }
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setGenero(String g){
        this.genero=g;
    }
    public void setActor(String o){
        this.actor=o;
    }
    public void setActriz(String a){
        this.actriz=a;
    }
    public void setDirector(String d){
        this.director=d;
    }
    public void setAño(int n){
        this.año=n;
    }
    
    @Override
    public String toString(){
        String cadena="pelicula :"+this.getTitulo()+"del año "+this.getAño();
        cadena=cadena+" y director "+this.getDirector()+"\n";
        return cadena;
    }
    
    public boolean equals(Pelicula p){
        return (this.getTitulo().equals(p.getTitulo())&&(this.getDirector().equals(p.getDirector()))) ;
    }
    
}
