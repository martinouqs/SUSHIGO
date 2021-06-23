/*
* Representa las cartas que tiene un jugador en la mano (las que dispone para jugar).
* Estructura: Se utilizarán TAD adecuado. 
* Funcionalidad: añadir carta a la mano, quitar carta de la mano, visualizar cartas de la mano,...
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mano{
	private Lista<Carta> cartas;

	public Mano() {
    	cartas = new ArrayList<>();
	}
        
        public int size(){
        return cartas.size();
        }
        
	public void a�adirCarta(Carta carta) {
   	cartas.add(carta);
	}
    
	public Carta eliminarCarta(int pos){
    	return cartas.remove(pos);
	}
    
	public void mostrarCartas(){
    	for (Carta carta : cartas) {
        	System.out.println(carta.toString());
    	}
	}
    
    

}
