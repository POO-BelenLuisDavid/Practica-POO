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
    ArrayList<Critica> criticas_compartidas=new ArrayList<Critica>();
    

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
        
        int aux=0;
        for(int i=0; i<u.solicitudes_amigos_pendientes.length; i++){
            if(u.solicitudes_amigos_pendientes[i]==this){
                System.out.println("Ya has enviado solicitud a este usuario\n");
                aux++;
            }
        }
        for(int j=0; j<this.mis_amigos.size(); j++){
            if(this.mis_amigos.get(j).equals(u)){
                System.out.println("Este usuario ya es tu amigo\n");   
                aux++;
            }
        }
        
        if(aux==0){
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
        ArrayList<Pelicula> peliculasaux=this.peliculas.getPeliculas();
        int cont=0;
        for(Pelicula peli: peliculasaux){
            if((p.getTitulo().equals(peli.getTitulo()))){  //podria añadir una restricción para que, en caso de que el amigo 
                for(Usuario u: mis_amigos){                //ya tenga la peli entre sus pelis, salte un mensaje de error.
                    u.setMuro(muro);
                    peliculas.anadirPelicula(peli,u);                    
                    peliculas.anadirPeliculaCompartida(peli,u);
                    cont++;
                }      
            }
        }
        if(cont==0){
            System.out.println("Nombre de la peli incorrecto");
        }
    }
    
    public void compartirPelicula(Pelicula p, Usuario u){
        muro.append(p);
        int cont=0;
        int cont2=0;
        boolean sePuede=false;  
        boolean sePuede2=false;
        ArrayList<Pelicula> peliculasaux=this.peliculas.getPeliculas();
        Pelicula peli2= new Pelicula();

        for(Usuario usu: mis_amigos){
            if(usu.getNick().equals(u.getNick())){
                sePuede=true;
            }
        }
        if(sePuede==true){
            for(Pelicula peli: peliculasaux ){
                if(p.getTitulo().equals(peli.getTitulo())){  //podria añadir una restricción para que, en caso de que el amigo 
                    sePuede2=true;                             //ya tenga la peli entre sus pelis, salte un mensaje de error.
                    cont++;
                    peli2=peli;
                    break;
                }
            }
            if(sePuede2==true){
                u.setMuro(muro);
                peliculas.anadirPelicula(peli2, u);
                cont2++;
            }
            if(cont2>0){
                peliculas.anadirPeliculaCompartida(peli2, u);
            }
            if(cont==0){
                System.out.println("Nombre de la peli incorrecto");
            }
        }
    }
    
    public void compartirCritica(Critica c){
        muro.append(c);
        ArrayList<Critica> criticasaux=this.peliculas.getCriticas();
        int cont=0;
        
        for(Critica crit: criticasaux){
            if(c.getPelicula().equals(crit.pelicula)){
                for(Usuario u: mis_amigos){
                    u.setMuro(muro);
                    peliculas.anadirCriticaCompartida(crit, u);
                    cont++;
                }
            }
        }
        if(cont==0){
            System.out.println("Nombre de la peli incorrecto");
        }
    }
    
    public void compartirCritica(Critica c, Usuario u){
        muro.append(c);
        int cont=0;
        boolean sePuede=false;  
        boolean sePuede2=false;
        ArrayList<Critica> criticasaux= peliculas.getCriticas();
        Critica crit2= new Critica();
        
        for(Usuario usu: mis_amigos){
            if(usu.getNick().equals(u.getNick())){
                sePuede=true;
            }
        }
        if(sePuede==false){
            System.out.println("Nombre de amigo incorrecto");
        }
        if(sePuede==true){
            for(Critica crit: criticasaux){
                if(crit.getPelicula().equals(c.getPelicula())){
                    sePuede2=true;
                    cont++;
                    crit2=crit;
                }
            }
        }
        if(sePuede2==true){
            //u.setMuro(muro);
            peliculas.anadirCriticaCompartida(crit2, u);
        }
        if(cont==0){
                System.out.println("Nombre de la crítica incorrecto");
            }
    }
    
    public void compartirPArtida(Partida p){
        
    }
    public void compartirPArtida(Partida p, Usuario u){
        
    }
    
    public void compartirTodo(){
        
        for(Critica c: peliculas.getCriticas()){
            compartirCritica(c);     
        }
        
        for(Pelicula p: peliculas.getPeliculas()){
            compartirPelicula(p);
        }
        
        //FALTA PARTIDA.
        
    }
    public void compartirTodo(Usuario u){
        
       
    }
    
    public void anadirPelicula(Pelicula p, Usuario u){
        peliculas.anadirPelicula(p, u);
    }
    public void anadirPeliculaPropia(Pelicula p, Usuario u){
        peliculas.anadirPeliculaPropia(p, u);
    }
    
    public void anadirCritica(Critica c, Pelicula p){
        peliculas.anadirCritica(c,p);
    }
    
    
    public void iniciarPartida(Usuario u){
        
        Partida pa = new Partida(); 
        pa.setJugador1(u);
        ArrayList<Pelicula> pe = u.peliculas.getPeliculas();
        
        System.out.println("Partida iniciada por "+u.getNick());
        System.out.println();

        int pos1 = pa.posAleatoria(pe);
        pa.pregunta(u,pe,pe.get(pos1).getTitulo(), pe.get(pos1).getDirector(), pe.get(pos1).getGenero(), pe.get(pos1).getActor(), pe.get(pos1).getActriz(), pe.get(pos1).getAño());
        int pos2 = pa.posAleatoria(pe);
        pa.pregunta(u,pe,pe.get(pos2).getTitulo(), pe.get(pos2).getDirector(), pe.get(pos2).getGenero(), pe.get(pos2).getActor(), pe.get(pos2).getActriz(), pe.get(pos2).getAño());
        int pos3 = pa.posAleatoria(pe);
        pa.pregunta(u,pe,pe.get(pos3).getTitulo(), pe.get(pos3).getDirector(), pe.get(pos3).getGenero(), pe.get(pos3).getActor(), pe.get(pos3).getActriz(), pe.get(pos3).getAño());
        int pos4 = pa.posAleatoria(pe);
        pa.pregunta(u,pe,pe.get(pos4).getTitulo(), pe.get(pos4).getDirector(), pe.get(pos4).getGenero(), pe.get(pos4).getActor(), pe.get(pos4).getActriz(), pe.get(pos4).getAño());
        int pos5 = pa.posAleatoria(pe);
        pa.pregunta(u,pe,pe.get(pos5).getTitulo(), pe.get(pos5).getDirector(), pe.get(pos5).getGenero(), pe.get(pos5).getActor(), pe.get(pos5).getActriz(), pe.get(pos5).getAño());
        int pos6 = pa.posAleatoria(pe);
        pa.pregunta(u,pe,pe.get(pos6).getTitulo(), pe.get(pos6).getDirector(), pe.get(pos6).getGenero(), pe.get(pos6).getActor(), pe.get(pos6).getActriz(), pe.get(pos6).getAño());
        
    }
    public void completarPartida(Partida p){
        
        p.setJugador2(this);
        
        
    }
    public void setMuro(StringBuilder s){
        System.out.println("Pelicula compartida con "+this.nick);
        //System.out.println(s+"\n");
    }


}
