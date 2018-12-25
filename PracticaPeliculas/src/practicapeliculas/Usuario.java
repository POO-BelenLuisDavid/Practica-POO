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
    StringBuilder muro= new StringBuilder();
    Peliculas peliculas = new Peliculas();
    int partidas_ganadas, partidas_perdidas, partidas_empatadas;
    Partida partidas_completas[], partidas_pendiente[];
   
    Usuario solicitudes_amigos_pendientes[]=new Usuario[N];//solicitudes que yo recibo   
    ArrayList<Usuario> mis_amigos=new ArrayList<Usuario>(); //solicitudes que me han aceptado y que he aceptado yo
   
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
        return "Nick: "+this.nick+"\n";
    }
    
    public void invitarAmigo(Usuario u){
        
        if(u!=null){
            for(int i =0; i<this.solicitudes_amigos_pendientes.length; i++){
                if(u.solicitudes_amigos_pendientes[i]==null){
                    u.solicitudes_amigos_pendientes[i]=this;
                    System.out.println("Solicitud enviada");
                    break;
                }
            }          
        }
    }
   
    public void aceptarInvitacion(Usuario u){
       
        if(this.solicitudes_amigos_pendientes[0]==null){
            System.out.println("No tienes solicitudes de amistad pendientes por contestar");
        }
        else{
            System.out.println(" 1.Aceptar\n 2.Rechazar\n");
            System.out.print ("Opcion: ");
            Scanner entrada = new Scanner (System.in);
            int numero=entrada.nextInt();
                switch(numero){
                    case 1: 
                            this.mis_amigos.add(u);
                            for(int i=0;i<this.solicitudes_amigos_pendientes.length;i++){
                                if((i+1<this.solicitudes_amigos_pendientes.length)&&(this.solicitudes_amigos_pendientes[i+1]!=null)){
                                    this.solicitudes_amigos_pendientes[i]=this.solicitudes_amigos_pendientes[i+1];
                                }
                                else{
                                    this.solicitudes_amigos_pendientes[i]=null;
                                } 
                            }                                         
                            u.mis_amigos.add(this);
                            System.out.println("Solicitud aceptada\n");
                            break;

                    case 2: 
                            rechazarInvitacion(u);
                            break;

                    default: 
                            System.out.println("Opcion no valida"); 
                            break; 
                }           
        }     
    }
    
    public void rechazarInvitacion(Usuario u){
        
        for(int i=0;i<this.solicitudes_amigos_pendientes.length;i++){
            if((i+1<this.solicitudes_amigos_pendientes.length)&&(this.solicitudes_amigos_pendientes[i+1]!=null)){
                this.solicitudes_amigos_pendientes[i]=this.solicitudes_amigos_pendientes[i+1];
            }
            else{
                this.solicitudes_amigos_pendientes[i]=null;
            }
        }
        System.out.println("Solicitud rechazada\n");        
    }
    
    public void compartirPelicula(Pelicula p){
        muro.append(p);
        for(Usuario u: mis_amigos){
            u.setMuro(muro);
        }
         
    }
    
    public void compartirPelicula(Pelicula p, Usuario u){
        muro.append(p);
        for(Usuario usu: mis_amigos){
            if(usu.getNick().equals(u.getNick())){
                usu.setMuro(muro);
            }
        }
    }
    
    public void compartirCritica(Critica c){
        muro.append(c);
        for(Usuario u: mis_amigos){
            u.setMuro(muro);
        }
    }
    
    
    public void compartirCritica(Critica c, Usuario u){
        muro.append(c);
        for(Usuario usu: mis_amigos){
            if(usu.getNick().equals(u.getNick())){
                usu.setMuro(muro);
            }
        }
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
        System.out.println("El usuario "+this.nick+" ha compartido ");
        System.out.println(s+"\n");
    }


}
