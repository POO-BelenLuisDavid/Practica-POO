/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.io.File;

/**
 *
 * @author Acer
 */
public class Clasificacion {
    
    private int N=20, orden=0;
    private String[] clasi_nom;
    private int[] clasi_puntos;
    private String[] copia;
    
    public Clasificacion(){
        clasi_nom = new String[N];
        clasi_puntos = new int[N];
        copia = new String[N];
    }
    
    public String[] getClasificacion(){
         return clasi_nom;
    }
    
    public void actualizar(){
    }
    
    public void visualizar(String[] imprimir){
         for(int i=0; i<clasi_nom.length; i++){
            System.out.println(i+1+". "+imprimir[i]);
        }
    }
    
    public void ordenarVictorias(){
        
    }
    
    public void ordenarPorcentajes(){
        
    }
    
    public void ordenarPuntos(Usuario u, int puntos){
        clasi_nom[orden]=u.getNick();
        clasi_puntos[orden]=puntos;
        
        for(int i=0; i<clasi_nom.length; i++){
            copia[i]=clasi_nom[i];
        }
        System.out.println("TODO OK");
        
        visualizar(copia);
        
        orden++;
        
    }
    
    public void volcarTXT(File f){
        
    }
    
}
