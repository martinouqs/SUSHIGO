/*
* Representa la baraja del sushiGo, 94 cartas, cada una representa a una comida 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: estando la baraja desordenada, devolverá la carta situada encima del montón de cartas
 */
package com.uvigo.poyectosushigo.CORE;
import java.util.ArrayList;
import java.util.Collections;
import pila.EnlazadaPila;
import pila.Pila;
import com.uvigo.poyectosushigo.CORE.Carta;


public class Baraja {
	private Pila<Carta>  toret;
    
	public Baraja(){
    	ArrayList<Carta> baraja  = new ArrayList<>();
    	toret = new EnlazadaPila<Carta>();
    	inicializarCartas(baraja);
    	Collections.shuffle(baraja);
    	for (int i=0; i<baraja.size() ; i++){
        	toret.push(baraja.get(i));
    	}   	 
	}
    
    
 	private void inicializarCartas(ArrayList<Carta> baraja){
    	for (int i = 0; i < 5; i++) {
        	baraja.add(new Carta (Carta.tipoCarta.NIGUIRIDECALAMAR));
    	}
    	for (int i = 0; i < 10; i++) {
        	baraja.add(new Carta (Carta.tipoCarta.NIGUIRIDESALMON));
    	}
    	for (int i = 0; i < 5; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.NIGUIRIDETORTILLA));
    	}
    	for (int i = 0; i < 6; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.WASABI));
    	}
    	for (int i = 0; i < 6; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.MAKI1ROLLO));
    	}
    	for (int i = 0; i < 12; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.MAKI2ROLLO));
    	}
    	for (int i = 0; i < 8; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.MAKI3ROLLO));
    	}
    	for (int i = 0; i < 14; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.TEMPURA));
    	}
    	for (int i = 0; i < 14; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.SASHIMI));
    	}
    	for (int i = 0; i < 14; i++) {
        	baraja.add(new Carta(Carta.tipoCarta.GYOZA));
    	}
 	}
	 
 	public Carta devolverArriba(){
     	return toret.pop();
 	}
}

