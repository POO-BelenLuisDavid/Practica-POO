/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static practicapeliculas.practicapeliculas.Inicio_Sesion;

/**
 *
 * @author Acer
 */
public class Partida {
    
    
    Clasificacion clasificacion = new Clasificacion();
    Pregunta pregunta = new Pregunta();
    
    int identificador=0, ptos_jugador1=0, ptos_jugador2=0;
    boolean terminado1=false, terminado2=false;
    Usuario ganador;
    String resultado_final;
    
    
    
    public Partida(){
        identificador++;
    }
    
    public int getIdentificador(){
        return identificador;
    }
    
    public void datos(Usuario u, ArrayList<Pelicula> pe, String titulo, String director, String genero, String actor, String actriz, String año){
       ptos_jugador1=pregunta.seleccionarPregunta(u, pe, titulo, director, genero, actor, actriz, año);
        
        
        //partidaTerminada(u,ptos_jugador1);

    }
    
    public void datos2(Usuario u, ArrayList<Pelicula> peu, String titulo, String director, String genero, String actor, String actriz, String año){
        ptos_jugador2=pregunta.seleccionarPregunta(u, peu, titulo, director, genero, actor, actriz, año);
        
    }
    
    public int posAleatoria(ArrayList<Pelicula> pe){
        Random posicion = new Random();
        int pos = posicion.nextInt(pe.size());
        System.out.println("///////Posicion elegida: "+pos);
        return pos;
    }
    
    
     public void opcion(Usuario u, int puntos){
        
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Qué desea hacer?");
        System.out.println(" 1.Volver a la pantalla principal  2.Ver tabla de clasificaciones");
        System.out.print ("Opcion: ");
        int numero=entrada.nextInt();
        
        switch(numero){
            case 1:     System.out.println();
                        break;
                        
            case 2:     System.out.println("");
                        System.out.println("¿Cómo desea ordenar la clasifiación?");
                        System.out.println(" 1.Victorias  2.Puntos  3.Porcentaje de acirtos");
                        
                        Scanner entrada2 = new Scanner (System.in);
                        System.out.print ("Opcion: ");
                        int numero2=entrada.nextInt();
                        
                        switch(numero2){
                            case 1:    System.out.println();
                                       clasificacion.ordenarVictorias();
                                       break;
                            
                            case 2:     System.out.println();
                                        clasificacion.ordenarPuntos(u, puntos);
                                        break;
                                        
                            case 3:     System.out.println();
                                        clasificacion.ordenarPorcentajes();
                            
                            default:    System.out.println("Por favor, seleccione una opción correcta");
                            opcion(u,puntos);
                            break;
                        }
                        break;
                        
            default:    System.out.println("Por favor, seleccione una opción correcta");
                        opcion(u,puntos);
                        break;
                        
        }
     }
    
    /*public void partidaTerminada(Usuario u, int pts){
        
        if((terminado1==true)&&(terminado2==true)){
                System.out.println("-----PARTIDA TERMINADA CORRECTAMENTE-----");
                if(ptos_jugador1>ptos_jugador2){
                    System.out.println();
                    System.out.println(nombreAux+" ES EL GANADOR!!");
                }
                else{
                    System.out.println();
                    System.out.println(u.getNick()+" ES EL GANADOR!!");
                }
                terminado1=false;
                terminado2=false;
                opcion(u,puntosj);
            }
            else{
                opcion(u,puntosj);
            }
    }*/
    
    public String toString(){
        String cadena = identificador+"\n";
        return cadena;
    }
}
