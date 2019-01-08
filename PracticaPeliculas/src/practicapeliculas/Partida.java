/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Partida implements Serializable{
    
    
    Clasificacion clasificacion = new Clasificacion();
    Pregunta pregunta = new Pregunta();
    
    int identificador=0, ptos_jugador1=0, ptos_jugador2=0,preg=0;
    Usuario ganador;
    String resultado_final="";
    Usuario jugador1, jugador2;
    
    String preguntas[] = {"¿Cuál es el título de la película estrenada en el año ", "¿Cuál es el año de estreno de la película ", "¿A qué género corresponde la película ", "¿Quién dirigió la película ", "¿Qué actor protagonizó la película ", "¿Qué actriz protagonizó la película "};
    String soluciones[] = {"La pelicula era: ", "El año era: ", "El género era: ", "El director era: ", "El actor era: ", "La actriz era: "};
    String atributos1[] = {"Título: ", "Director: ", "Género: ", "Actor: ", "Actriz: ", "Año: "};
    String atributos2[] = {"Año: ", "Género: ", "Director: ", "Actor: ", "Actriz: ", "Título: "};
    String atributos3[] = {"Género: ", "Año: ", "Director: ", "Actor: ", "Actriz: ", "Título: "};
    String atributos4[] = {"Director: ", "Año: ", "Género: ", "Actor: ", "Actriz: ", "Título: "};
    String atributos5[] = {"Actor: ", "Año: ", "Género: ", "Director: ", "Actriz: ", "Título: "};
    String atributos6[] = {"Actriz: ", "Año: ", "Género: ", "Director: ", "Actor: ", "Título: "};
    
    public ArrayList<Partida> partidas;
    
    public Partida(){
        jugador1= new Usuario();
        jugador2= new Usuario();
        identificador++;
        partidas = new ArrayList<Partida>();
    }
    
    public ArrayList<Partida> getPartida(){
            return partidas;
        }
    
    public void setJugador1(Usuario u){
        this.jugador1=u;
    }
    
    public void setJugador2(Usuario u){
        this.jugador2=u;
    }
    
    public int getPuntosJugador1(){
        return ptos_jugador1;
    }
    public int getPuntosJugador2(){
        return ptos_jugador2;
    }
    public String getResultadoFinal(){
        return resultado_final;
    }
    
        
    public void pregunta(Usuario u, ArrayList<Pelicula> pe, String titulo, String director, String genero, String actor, String actriz, String año){
        preg++;
        if(preg == 1){
            //opciones(u, pe, titulo);
            cuerpoPreguntaJ1(u, pe, preguntas, soluciones, atributos1,titulo,director,genero,actor,actriz,año);
        }
        if(preg == 2){
            cuerpoPreguntaJ1(u, pe, preguntas, soluciones, atributos2,año,director,genero,actor,actriz,titulo);
        }
        if(preg == 3){
            cuerpoPreguntaJ1(u, pe, preguntas, soluciones, atributos3,genero,año,director,actor,actriz,titulo);
        }
        if(preg == 4){
            cuerpoPreguntaJ1(u, pe, preguntas, soluciones, atributos4,director,año,genero,actor,actriz,titulo);
        }
        if(preg == 5){
            cuerpoPreguntaJ1(u, pe, preguntas, soluciones, atributos5,actor,año,genero,director,actriz,titulo);
        }
        if(preg == 6){
            cuerpoPreguntaJ1(u, pe, preguntas, soluciones, atributos6,actriz,año,genero,director,actor,titulo);
        }
    }
    
    public void cuerpoPreguntaJ1(Usuario u, ArrayList<Pelicula> pe, String[] auxPreg, String[] auxSol, String[] auxAtr, String cero, String uno, String dos, String tres, String cuatro, String cinco){
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
                            }
                        }
                        else{
                            System.out.println("Eres malísimo");
                            System.out.println();
                            System.out.println(auxSol[preg-1]+cero+".  +0 pts");///////////
                            if(preg==6){
                                System.out.println("-----PARTIDA FINALIZADA-----");
                                System.out.println("Esperando respuesta de tu oponente...");
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void pregunta2(Usuario u, ArrayList<Pelicula> pe, String titulo, String director, String genero, String actor, String actriz, String año){
        preg++;
        if(preg == 1){
            //opciones(u, pe, titulo);
            cuerpoPreguntaJ2(u, pe, preguntas, soluciones, atributos1,titulo,director,genero,actor,actriz,año);
        }
        if(preg == 2){
            cuerpoPreguntaJ2(u, pe, preguntas, soluciones, atributos2,año,director,genero,actor,actriz,titulo);
        }
        if(preg == 3){
            cuerpoPreguntaJ2(u, pe, preguntas, soluciones, atributos3,genero,año,director,actor,actriz,titulo);
        }
        if(preg == 4){
            cuerpoPreguntaJ2(u, pe, preguntas, soluciones, atributos4,director,año,genero,actor,actriz,titulo);
        }
        if(preg == 5){
            cuerpoPreguntaJ2(u, pe, preguntas, soluciones, atributos5,actor,año,genero,director,actriz,titulo);
        }
        if(preg == 6){
            cuerpoPreguntaJ2(u, pe, preguntas, soluciones, atributos6,actriz,año,genero,director,actor,titulo);
        }
    }
    
    public void cuerpoPreguntaJ2(Usuario u, ArrayList<Pelicula> pe, String[] auxPreg, String[] auxSol, String[] auxAtr, String cero, String uno, String dos, String tres, String cuatro, String cinco){
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
            ptos_jugador2=+ptos_jugador2+50;
            System.out.println("¡CORRECTO!  +50 pts");
            if(preg==6){
                System.out.println("-----PARTIDA FINALIZADA-----");
                System.out.println("Esperando respuesta de tu oponente...");
                resultado(jugador1,jugador2,ptos_jugador1,ptos_jugador2);
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
                ptos_jugador2=+ptos_jugador2+40;
                System.out.println("¡CORRECTO!  +40 pts");
                if(preg==6){
                    System.out.println("-----PARTIDA FINALIZADA-----");
                    System.out.println("Esperando respuesta de tu oponente...");
                    resultado(jugador1,jugador2,ptos_jugador1,ptos_jugador2);
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
                    ptos_jugador2=+ptos_jugador2+30;
                    System.out.println("¡CORRECTO!  +30 pts");
                    if(preg==6){
                        System.out.println("-----PARTIDA FINALIZADA-----");
                        System.out.println("Esperando respuesta de tu oponente...");
                        resultado(jugador1,jugador2,ptos_jugador1,ptos_jugador2);
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
                        ptos_jugador2=+ptos_jugador2+20;
                        System.out.println("¡CORRECTO!  +20 pts");
                        if(preg==6){
                            System.out.println("-----PARTIDA FINALIZADA-----");
                            System.out.println("Esperando respuesta de tu oponente...");
                            resultado(jugador1,jugador2,ptos_jugador1,ptos_jugador2);
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
                            ptos_jugador2=+ptos_jugador2+10;
                            System.out.println("¡CORRECTO!  +10 pts");
                            if(preg==6){
                                System.out.println("-----PARTIDA FINALIZADA-----");
                                System.out.println("Esperando respuesta de tu oponente...");
                                resultado(jugador1,jugador2,ptos_jugador1,ptos_jugador2);
                            }
                        }
                        else{
                            System.out.println("Eres malísimo");
                            System.out.println();
                            System.out.println(auxSol[preg-1]+cero+".  +0 pts");///////////
                            if(preg==6){
                                System.out.println("-----PARTIDA FINALIZADA-----");
                                System.out.println("Esperando respuesta de tu oponente...");
                                resultado(jugador1,jugador2,ptos_jugador1,ptos_jugador2);
                            }
                        }
                    }
                }
            }
        }
    }
    public void resultado(Usuario jugador1, Usuario jugador2, int punt1, int punt2){
        
        String ganador="";
        if(punt1>punt2){
            //ganador=jugador1.getNick();
            System.out.println("-----El ganador es: "+jugador1.getNick()+"-----");
            jugador1.partidas_ganadas++;
            jugador2.partidas_perdidas++;
        }
        if(punt2>punt1){
            //ganador=jugador2.getNick();
            System.out.println("-----El ganador es: "+jugador2.getNick()+"-----");
            jugador2.partidas_ganadas++;
            jugador1.partidas_perdidas++;
        }
        if(punt1==punt2){
            System.out.println("Empate");
            jugador1.partidas_empatadas++;
            jugador2.partidas_empatadas++;
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
     
    
    public String toString(){
        String cadena = identificador+"\n";
        return cadena;
    }
    
        
}
