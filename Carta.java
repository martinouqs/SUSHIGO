/*
 * Representa una carta, formada por un nombre
 */

package com.uvigo.poyectosushigo.CORE;


public class Carta {

	public enum tipoCarta{
   	 
    	NIGUIRIDECALAMAR, NIGUIRIDESALMON, NIGUIRIDETORTILLA, WASABI,
    	MAKI1ROLLO, MAKI2ROLLO, MAKI3ROLLO, TEMPURA, SASHIMI, GYOZA
   	 
	}
    
	private tipoCarta carta;
        
        
	public Carta(tipoCarta carta) {
    	this.carta = carta;
	}
    
	public tipoCarta getCarta(){
    	return carta;
	}

	@Override
	public String toString() {
    	return "Carta:"+ carta;
	}
    
    
}

