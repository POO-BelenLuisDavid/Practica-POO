/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicapeliculas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Usuario implements Serializable{
    
    int N=10;
    StringBuilder muro;
    Peliculas peliculas = new Peliculas();
    int partidas_ganadas, partidas_perdidas, partidas_empatadas;
    Partida partidas_completas[], partidas_pendiente[];
   
    Usuario solicitudes_amigos_pendientes[]=new Usuario[N];//solicitudes que yo envío   
    Usuario mis_amigos[]=new Usuario[N]; //solicitudes que me han aceptado y que he aceptado yo
    Usuario solicitudes_rechazadas[]=new Usuario[N];// solicitudes que yo envío y me rechazan
    Usuario solicitudes_recibidas[]=new Usuario[N];// solicitudes que me han enviado
    
    
    //private static ArrayList<Usuario>solicitudes_recibidas; //solicitues que me han hecho
    
    String nick;
    String clave;
    
    public Usuario(String nick, String clave, int partidas_ganadas, int partidas_perdidas, int partidas_empatadas){
        this.nick = nick;
        this.clave = clave;
        this.partidas_ganadas=partidas_ganadas;
        this.partidas_perdidas=partidas_perdidas;
        this.partidas_empatadas=partidas_empatadas;
    }
    
    public Usuario (){
 
    }
    /*public ArrayList<Usuario> getSolicitudes_recibidas(){
         return solicitudes_recibidas;
     }*/
    
    /*private static ArrayList<Usuario> amigos; 
    public Usuario(){  
         amigos = new ArrayList<Usuario>(); 
     }*/

    
    public String getNick() {
        return nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean equals (Usuario u){
        return this.nick.equals(u.nick);
    }
    
    @Override
    public String toString () {
        return "Nick: "+this.nick;
    }
    
    public void invitarAmigo(Usuario u){
        
        if(u!=null){
            for(int i =0; i<this.solicitudes_amigos_pendientes.length; i++){
                if(this.solicitudes_amigos_pendientes[i]==null){
                    this.solicitudes_amigos_pendientes[i]=u;
                    for(int k=0; k<u.solicitudes_recibidas.length; k++){
                        if(u.solicitudes_recibidas[k]==null){
                            u.solicitudes_recibidas[k]=this;
                            break;
                        }   
                    }
                    System.out.println("Solicitud enviada");
                    break;
                }
            }          
        }
        else{
        System.out.println(" 1.Ver solicitudes pendientes\n 2.Ver solicitudes rechazadas\n 3.Listado de amigos\n 4.Volver");
        System.out.print ("Opcion: ");
        Scanner entrada = new Scanner (System.in);
        int numero=entrada.nextInt();
            switch(numero){
                case 1:     System.out.println("Solicitudes pendientes:");
                            for(int j =0; j<this.solicitudes_amigos_pendientes.length; j++){
                                if(this.solicitudes_amigos_pendientes[j]!=null){
                                    System.out.println(solicitudes_amigos_pendientes[j].getNick()); 
                                    //break;
                                }//aqui quiero poner un else por si no hay invitaciones pendientes ponerlo
                                // en plan else{ System.out.print("No tienes invitaciones pendientes de ser contestadas"
                            }
                            break;
                case 2:     System.out.println("Mis solicitudes enviadas rechazadas son:");
                            for(int j =0; j<this.solicitudes_rechazadas.length; j++){
                                if(this.solicitudes_rechazadas[j]!=null){
                                    System.out.println(solicitudes_rechazadas[j].getNick()); 
                                    break;
                                }
                                else{
                                    System.out.println("No tienes solicitudes rechazadas");
                                    break;
                                }
                            }
                            break;
                case 3:    System.out.println("Mis amigos son:");       
                            int cont=0;
                            for(int i=0; i<this.mis_amigos.length; i++){
                                if(this.mis_amigos[i]!=null){
                                    cont++;
                                    System.out.println(cont+ ".-" + this.mis_amigos[i].getNick());  
                                    break;
                                }                 
                            }
                            System.out.println("------------------");
                            break;
                case 4:    System.out.println("Volviendo al menú");                        
                            break;                       
            } 
        } 
    }
   
    public void aceptarInvitacion(Usuario u){
        
        System.out.println("Estas son las solicitudes de amistad recibidas pendientes:");
        System.out.println("(Recuerda que se aceptan o rechazan a los usuarios por orden)");
        int cont=0;
        for(int i=0; i<this.solicitudes_recibidas.length; i++){
            if(this.solicitudes_recibidas[i]!=null){
                cont++;
                System.out.println(cont+ ".-" + solicitudes_recibidas[i].getNick());  
            }                 
        }
        System.out.println("------------------");
        
        System.out.println(" 1.Aceptar\n 2.Rechazar\n 3.Volver");
        System.out.print ("Opcion: ");
        Scanner entrada = new Scanner (System.in);
        int numero=entrada.nextInt();
            switch(numero){
                case 1:
                    //Aceptar
                    for(int i =0; i<this.solicitudes_recibidas.length; i++){
                        if(this.solicitudes_recibidas[i]!=null){
                            this.mis_amigos[i]=u;
                            for(int k=0; k<u.mis_amigos.length; k++){
                                if(u.mis_amigos[k]==null){
                                    u.solicitudes_recibidas[k]=this;
                                    break;
                                }   
                            }
                            System.out.println("Solicitud enviada");
                            break;
                        }
                    }
                    //for(int i=0; i<this.solicitudes_recibidas.length; i++){
                        //if(this.solicitudes_recibidas[i]!=null){
                           // this.mis_amigos[i]=this.solicitudes_recibidas[i]; 
                           // u.mis_amigos[0]= this;
                            /*for(int j=0; j<u.mis_amigos.length; j++){
                                if(u.mis_amigos[j]==null){
                                    u.mis_amigos[j]=this;
                                    break;
                                }
                                    
                                    /*if(u.solicitudes_amigos_pendientes[j+1]!=null){
                                        u.solicitudes_amigos_pendientes[j]= u.solicitudes_amigos_pendientes[j+1];
                                    }else{
                                        u.solicitudes_amigos_pendientes[j]=null;
                                    } 
                                }
                                
                            }/*
                            this.solicitudes_recibidas[i]=this.solicitudes_recibidas[i+1];
                            /*for(int j=0; j<u.solicitudes_amigos_pendientes.length; j++){
                                if(u.solicitudes_amigos_pendientes==this.solicitudes_recibidas){
                                    
                                }
                            }*/
                        //}
                    
                    System.out.println("Solicitud aceptada\n");
                    //aceptarInvitacion(u);
                case 2: 
                    rechazarInvitacion(u);
                    break;
                
                case 3: 
                    System.out.println("Volviendo al menú");                        
                    break; 
            }  
    }
    
    
    public void rechazarInvitacion(Usuario u){
        //Rechazar
        System.out.println("Solicitud rechazada\n");
        
    }
    
    public void compartirPelicula(Pelicula p){
         
    }
    
    public void compartirPelicula(Pelicula p, Usuario u){
        
    }
    
    public void compartirCritica(Critica c){
    }
    
    
    public void compartirCritica(Critica c, Usuario u){
    }
    
    public void compartirPArtida(Partida p){
        
    }
    public void compartirPArtida(Partida p, Usuario u){
        
    }
    
    public void compartirTodo(){
        
    }
    public void compartirTodo(Usuario u){
        
       
    }
    
    public void anadirPelicula(Pelicula p){
        peliculas.anadirPeliculas(p);
        System.out.println("Pelicula añadida");
    }
    
    public void anadirCritica(Critica c, Pelicula p){
        
    }
    
    
    public void iniciarPartida(Usuario u){
        
    }
    public void completarPartida(Partida p){
        
    }
    public void setMuro(StringBuilder s){
        
    }


}
