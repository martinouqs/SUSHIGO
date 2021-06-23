/*
 * Representa a un jugador de la partida, identificado por el nombre 
 * Funcionalidad: escoge una carta de su mano; la colocar√° en su mesa; coge cartas de la baraja para la mano,
 *                entrega las cartas de su mano; coge las cartas de otra mano; calcula su puntuaci√≥n por ronda;
 *                calcula su puntuaci√≥n total; cuenta cuantos rollitos tiene en su mesa; ....
 */
package com.uvigo.poyectosushigo.CORE;
import java.util.ArrayList;
import com.uvigo.poyectosushigo.CORE.Baraja;
import java.util.Objects;
import com.uvigo.poyectosushigo.CORE.Carta;

public class Jugador{ 
    
    //Datos del Jugador
    public String nombre;      
    private int[] puntos;
    private int puntuacionTotal;
    private Mano mano; 
    private CartasMesa mesa;
	
public Jugador (String nombre){
    this.nombre = nombre;
    this.mano = new Mano(); 
    this.puntos = new int[RONDAS];
    this.mesa = new CartasMesa();
    this.puntuacionTotal = 0;
} 

    public void  setPuntuacionTotal(int val){
        this.puntuacionTotal += val;
    }
    public String getNombre() { //Getter
        return nombre;
    }
    public int getPuntos(int ronda) {
        return puntos[ronda];
    }
    public Mano getMano() {  
        return mano;
    }

    public void setNombre(String nombre) { //Setter
        this.nombre = nombre;
    }

    public void setPuntos(int ronda, int puntos) {
        this.puntos[ronda] +=  puntos;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }


    
    public void calcularPuntosTotales(){ //SUMAMOS OS PUNTOS DE CADA RONA = PUNTOS TOTALES
        
        for(int i = 0; i < puntos.length; i++){
            puntuacionTotal += puntos[i];
        }
    }
    public int getPuntosTotales(){
        return puntuacionTotal;
    }
        //Cartas en la mano
     public int numCartas(){      //cantidad de cartas en la mano
         return this.mano.size();
     }
     public void verMesa(){
     mesa.visualizarMesa();
     }
     public void aÒadirCartaMano(Carta c){
         mano.aÒadirCarta(c);
     }
     public void eliminarCartaMano(int pos){
         mano.eliminarCarta(pos);
     }
     public void eliminarCartasMesa(){
      mesa.descartarCartas();
     }
     public void verMano(){       //muestra la mano del jugador
        mano.mostrarCartas();
     }
     public void colocarCartaMesa(Carta c){
     mesa.colocarCarta(c);
     }
     public void calcularPuntos(int ronda){ // PUNTOS CADA RONDA
     puntos[ronda] = mesa.calcularPuntos();
     }
     public Carta getCartaAt(int c){ //c  = carta  (Toma una carta)
         return this.mano.get(c);
     }
     public int numRollitosJugador(){
      return mesa.numRollitos();
     }
     public boolean sinCartas(){    //Denota que no hay cartas en la mano
         return this.mano.isEmpty();
     }

         //Cartas en la Mesa
     public void setCartas(ArrayList<Carta> cartas){   //pone las cartas en la mesa
         this.mano = cartas; 
     }
   
    @Override   //dice cuantos puntos tiene en total el jugador (en toto el juego)
    public String toString() {
        return nombre + "tiene " + puntos + "puntos";
    }

}
