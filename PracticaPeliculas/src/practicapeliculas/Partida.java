/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Partida {
    
    
    Clasificacion clasificacion = new Clasificacion();
    
    int identificador=0, ptos_jugador1=0, ptos_jugador2=0,preg=0;
    Usuario ganador;
    String resultado_final;
    
    String preguntas[] = {"¿Cuál es el título de la película estrenada en el año ", "¿Cuál es el año de estreno de la película ", "¿A qué género corresponde la película ", "¿Quién dirigió la película ", "¿Qué actor protagonizó la película ", "¿Qué actriz protagonizó la película "};
    String soluciones[] = {"La pelicula era: ", "El año era: ", "El género era: ", "El director era: ", "El actor era: ", "La actriz era: "};
    String atributos1[] = {"Título: ", "Director: ", "Género: ", "Actor: ", "Actriz: ", "Año: "};
    String atributos2[] = {"Año: ", "Género: ", "Director: ", "Actor: ", "Actriz: ", "Título: "};
    String atributos3[] = {"Género: ", "Año: ", "Director: ", "Actor: ", "Actriz: ", "Título: "};
    String atributos4[] = {"Director: ", "Año: ", "Género: ", "Actor: ", "Actriz: ", "Título: "};
    String atributos5[] = {"Actor: ", "Año: ", "Género: ", "Director: ", "Actriz: ", "Título: "};
    String atributos6[] = {"Actriz: ", "Año: ", "Género: ", "Director: ", "Actor: ", "Título: "};
    
    public Partida(){
        identificador++;
    }
    
    public void pregunta(Usuario u, ArrayList<Pelicula> pe, String titulo, String director, String genero, String actor, String actriz, String año){
        preg++;
        if(preg == 1){
            //opciones(u, pe, titulo);
            cuerpoPregunta2(u, pe, preguntas, soluciones, atributos1,titulo,director,genero,actor,actriz,año);
        }
        if(preg == 2){
            cuerpoPregunta2(u, pe, preguntas, soluciones, atributos2,año,director,genero,actor,actriz,titulo);
        }
        if(preg == 3){
            cuerpoPregunta2(u, pe, preguntas, soluciones, atributos3,genero,año,director,actor,actriz,titulo);
        }
        if(preg == 4){
            cuerpoPregunta2(u, pe, preguntas, soluciones, atributos4,director,año,genero,actor,actriz,titulo);
        }
        if(preg == 5){
            cuerpoPregunta2(u, pe, preguntas, soluciones, atributos5,actor,año,genero,director,actriz,titulo);
        }
        if(preg == 6){
            cuerpoPregunta2(u, pe, preguntas, soluciones, atributos6,actriz,año,genero,director,actor,titulo);
        }
    }
    
    public void cuerpoPregunta2(Usuario u, ArrayList<Pelicula> pe, String[] auxPreg, String[] auxSol, String[] auxAtr, String cero, String uno, String dos, String tres, String cuatro, String cinco){
        System.out.println("-----PREGUNTA "+preg+"-----");
        System.out.println();
        System.out.println(auxPreg[preg-1]+cinco+" ?");
        Scanner entrada1 = new Scanner (System.in);
        System.out.print("Opciones ->  ");
        opciones(u, pe, cero);
        System.out.print("5. "+cero);
        System.out.println();
        System.out.print("Respuesta ->  ");
        String respuesta1 = entrada1.nextLine();
        if(cero.equals(respuesta1)){
            ptos_jugador1=+ptos_jugador1+50;
            System.out.println("¡CORRECTO!  +50 pts");
            if(preg==6){
                System.out.println("-----PARTIDA FINALIZADA-----");
                System.out.println("Esperando respuesta de tu oponente...");
                clasificacion.ordenarPuntos(u, ptos_jugador1);
            }
            
        }
        else{
            System.out.println("Oh, que pena");
            System.out.println();
            System.out.println(auxPreg[preg-1]+cinco+" ?");
            System.out.println();
            System.out.println("Pista 1");
            System.out.println(auxAtr[2]+dos+". ");
            Scanner entrada2 = new Scanner (System.in);
            System.out.print("Opciones ->  ");
            opciones(u, pe, cero);
            System.out.print("5. "+cero);
            System.out.println();
            System.out.print("Respuesta ->  ");
            String respuesta2 = entrada1.nextLine();
            if(cero.equals(respuesta2)){
                ptos_jugador1=+ptos_jugador1+40;
                System.out.println("¡CORRECTO!  +40 pts");
                if(preg==6){
                    System.out.println("-----PARTIDA FINALIZADA-----");
                    System.out.println("Esperando respuesta de tu oponente...");
                    clasificacion.ordenarPuntos(u, ptos_jugador1);
                }
            }
            else{
                System.out.println("Has vuelto a fallar");
                System.out.println();
                System.out.println(auxPreg[preg-1]+cinco+" ?");
                System.out.println();
                System.out.println("Pista 2");
                System.out.println(auxAtr[2]+dos+". ");
                System.out.println(auxAtr[1]+uno+". ");
                Scanner entrada3 = new Scanner (System.in);
                System.out.print("Opciones ->  ");
                opciones(u, pe, cero);
                System.out.print("5. "+cero);
                System.out.println();
                System.out.print("Respuesta ->  ");
                String respuesta3 = entrada1.nextLine();
                if(cero.equals(respuesta3)){
                    ptos_jugador1=+ptos_jugador1+30;
                    System.out.println("¡CORRECTO!  +30 pts");
                    if(preg==6){
                        System.out.println("-----PARTIDA FINALIZADA-----");
                        System.out.println("Esperando respuesta de tu oponente...");
                        clasificacion.ordenarPuntos(u, ptos_jugador1);
                    }
                }
                else{
                    System.out.println("Otra vez mal...");
                    System.out.println();
                    System.out.println(auxPreg[preg-1]+cinco+" ?");
                    System.out.println();
                    System.out.println("Pista 3");
                    System.out.println(auxAtr[2]+dos+". ");
                    System.out.println(auxAtr[1]+uno+". ");
                    System.out.println(auxAtr[3]+tres+". ");
                    Scanner entrada4 = new Scanner (System.in);
                    System.out.print("Opciones ->  ");
                    opciones(u, pe, cero);
                    System.out.print("5. "+cero);
                    System.out.println();
                    System.out.print("Respuesta ->  ");
                    String respuesta4 = entrada1.nextLine();
                    if(cero.equals(respuesta4)){
                        ptos_jugador1=+ptos_jugador1+20;
                        System.out.println("¡CORRECTO!  +20 pts");
                        if(preg==6){
                            System.out.println("-----PARTIDA FINALIZADA-----");
                            System.out.println("Esperando respuesta de tu oponente...");
                            clasificacion.ordenarPuntos(u, ptos_jugador1);
                        }
                    }
                    else{
                        System.out.println("Otra vez mal...");
                        System.out.println();
                        System.out.println(auxPreg[preg-1]+cinco+" ?");
                        System.out.println();
                        System.out.println("ültima pista");
                        System.out.println(auxAtr[2]+dos+". ");
                        System.out.println(auxAtr[1]+uno+". ");
                        System.out.println(auxAtr[3]+tres+". ");
                        System.out.println(auxAtr[4]+cuatro+". ");
                        Scanner entrada5 = new Scanner (System.in);
                        System.out.print("Opciones ->  ");
                        opciones(u, pe, cero);
                        System.out.print("5. "+cero);
                        System.out.println();
                        System.out.print("Respuesta ->  ");
                        String respuesta5 = entrada1.nextLine();
                        if(cero.equals(respuesta5)){
                            ptos_jugador1=+ptos_jugador1+10;
                            System.out.println("¡CORRECTO!  +10 pts");
                            if(preg==6){
                                System.out.println("-----PARTIDA FINALIZADA-----");
                                System.out.println("Esperando respuesta de tu oponente...");
                                clasificacion.ordenarPuntos(u, ptos_jugador1);
                            }
                        }
                        else{
                            System.out.println("Eres malísimo");
                            System.out.println();
                            System.out.println(auxSol[preg-1]+cero+".  +0 pts");///////////
                            if(preg==6){
                                System.out.println("-----PARTIDA FINALIZADA-----");
                                System.out.println("Esperando respuesta de tu oponente...");
                                clasificacion.ordenarPuntos(u, ptos_jugador1);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public int posAleatoria(ArrayList<Pelicula> pe){
        Random posicion = new Random();
        int pos = posicion.nextInt(pe.size());
        System.out.println("///////Posicion elegida: "+pos);
        return pos;
    }
    
    public void opciones(Usuario u, ArrayList<Pelicula> pe, String respuesta){
        int i=1,j=1;
        for(Pelicula p: pe){
            
            if(j<=5){//variable para controlar cuantas opciones se muestran
                if(preg==1){
                   if(!respuesta.equals(p.getTitulo())){
                    //System.out.println("Repetida");
                    System.out.print(i+". "+p.getTitulo()+"  \\  ");
                    i++;
                    } 
                }
                if(preg==2){/////////////////////DA UNA OPCION DE MAS
                   if(!respuesta.equals(p.getAño())){
                    //System.out.println("Repetida");
                    System.out.print(i+". "+p.getAño()+"  \\  ");
                    i++;
                    } 
                }
                if(preg==3){
                   if(!respuesta.equals(p.getGenero())){
                    //System.out.println("Repetida");
                    System.out.print(i+". "+p.getGenero()+"  \\  ");
                    i++;
                    } 
                }
                if(preg==4){
                   if(!respuesta.equals(p.getDirector())){
                    //System.out.println("Repetida");
                    System.out.print(i+". "+p.getDirector()+"  \\  ");
                    i++;
                    } 
                }
                if(preg==5){
                   if(!respuesta.equals(p.getActor())){
                    //System.out.println("Repetida");
                    System.out.print(i+". "+p.getActor()+"  \\  ");
                    i++;
                    } 
                }
                if(preg==6){////////////////////////////
                   if(!respuesta.equals(p.getActriz())){
                    //System.out.println("Repetida");
                    System.out.print(i+". "+p.getActriz()+"  \\  ");
                    i++;
                    } 
                }
              j++; 
            }
        }
    }
     
    
    
}
