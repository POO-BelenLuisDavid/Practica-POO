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
public class Usuario {
StringBuilder muro;
    int partidas_ganadas, partidas_perdidas, partidas_empatadas;
    Partida partidas_completas[], partidas_pendiente[];
    Usuario solicitudes_amigos_penndientes[];
    
    String nick;
    String clave;
    
    public Usuario(String nick, String clave, int partidas_ganadas, int partidas_perdidas, int partidas_empatadas){
        this.nick = nick;
        this.clave = clave;
        this.partidas_ganadas=partidas_ganadas;
        this.partidas_perdidas=partidas_perdidas;
        this.partidas_empatadas=partidas_empatadas;
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
        return "Nick: "+this.nick;
    }
    public void invitarAmigo(Usuario u){
        
    }
    
    public void aceptarInvitacion(Usuario u){
        
    }
    
    public void rechazarInvitacio(Usuario u){
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