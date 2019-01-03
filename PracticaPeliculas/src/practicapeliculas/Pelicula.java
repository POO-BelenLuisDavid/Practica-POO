/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class Pelicula implements Serializable{
    
    String titulo, director, genero, actor, actriz, año;
    
    int N=10, aux=-1;
    String titulos[] = new String[N];
    String directores[] = new String[N];
    String generos[] = new String[N];
    String actores[] = new String[N];
    String actrices[] = new String[N];
    String años[] = new String[N];
    
    public Pelicula(){  
         
     }
    
    public Pelicula(String t, String d, String g, String a_m, String a_f, String a){
            this.titulo=t;
            this.director=d;
            this.genero=g;
            this.actor= a_m;
            this.actriz=a_f;
            this.año= a;
            /*titulos[aux]=titulo;
            directores[aux]=d;
            generos[aux]=g;
            actores[aux]=a_m;
            actrices[aux]=a_f;
            años[aux]=a;*/
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
    public String getAño(){
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
    public void setAño(String n){
        this.año=n;
    }
    
    @Override
    public String toString(){
        String cadena="Descripción :"+this.getTitulo()+" fue rodada en "+this.getAño();
        cadena=cadena+" y dirigida por "+this.getDirector()+", cuenta con actores como "+this.getActor()+" y "+this.getActriz() +"\n";
        return cadena;
    }
    
    public boolean equals(Pelicula p){
        return (this.getTitulo().equals(p.getTitulo())&&(this.getDirector().equals(p.getDirector()))) ;
    }
    
    public String dameTitulo(int pos){
        return titulos[aux];
    }
    
    public String dameAño(int pos){
        return años[pos];
    }
    
    public String dameGenero(int pos){
        return generos[pos];
    }
    
    public String dameDirector(int pos){
        return directores[pos];
    }
    
    public String dameActor(int pos){
        return actores[pos];
    }
    
    public String dameActriz(int pos){
        return actrices[pos];
    }
}
