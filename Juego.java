/**
 * Representa el juego del sushiGo, con sus reglas. 
 * Se recomienda una implementaci√≥n modular.
 */
package com.uvigo.proyectosushigo.IU;
import IU.ES;
import com.uvigo.poyectosushigo.CORE.Baraja;
import com.uvigo.poyectosushigo.CORE.Jugador;
import com.uvigo.poyectosushigo.CORE.Mesa;
import com.uvigo.poyectosushigo.CORE.Mano;
import com.uvigo.poyectosushigo.CORE.Carta;





public class Juego {
    
    public static int numJugadores;
    public static int numCartasJugador;
    private static Baraja baraja;
    private static Jugador [] jugadores;
    private static Mesa mesa;
    private static Mano mano;
    private static Carta carta;
        
    //METODO NUMERO DE CARTAS QUE LEVA CADA XOGADOR
    
    
            public void puntosFinales(){
                
                        int var = 0;
                
                        for (int i = 0; i < numJugadores; i++) {    //PUTACION MAXIMA DE ROLLITOS

                            if(var < jugadores[i].numRollitosJugador()){
                                var = jugadores[i].numRollitosJugador(); 
                          
                         }
                        }
                        if(var > 0){ // Se hai xogadores con rollitos na mesa
                            Jugador rollos [] = new Jugador[numJugadores];  //ALAMACENAMOS JUGADORES CON MAX ROLLITOS

                            int a = 0;
                            for (int j = 0; j< numJugadores; j++){
                                if(var == jugadores[j].numRollitosJugadores()){
                                    rollos [a++] = jugadores[j];

                                }
                            }
                            for(int j = 0; j < numJugadores; j++){  //PUNTUACION JUGADORES SIN ROLLITOS
                                jugadores[j].calcularPuntosTotales();
                            }
                            for(int k = 0; k < a; k++){             //PUNTUACION TOTAL + PUNTUACION ROLLITOS= PUNTUACION FINAL
                                rollos[k].setPuntuacionTotal(6 /a);

                            }
                        }
                        
                }
                    
                private static void pasarCartasIzqd(Jugador[] jugadores){ //PASAMOS AS CARTAS AO XOGADOR DA ESQUERDA

                        Mano cartasMano = jugadores[0].getMano();

                        for(int i = 0; i<jugadores.length-1 ; i++){
                                jugadores[i].setMano(jugadores[i+1].getMano());
                        }

                        jugadores[jugadores.length-1].setMano(cartasMano);
                }
    public static void inicio (){

               int ronda=0;
               int maximoPuntosAcum=0;
               
               System.out.println("---------------Bienvenid@ a SUSHI GO!------------------");
               do {numJugadores = ES.pideNumero("Escribe el numero de jugadores/as que van a participar (minimo 2, m·ximo 5):");}
               while (numJugadores < 2 || numJugadores > 5);
                       
               switch (numJugadores) {
                    case 2:
                        numCartasJugador = 9;
                        break;
                    case 3:
                        numCartasJugador = 8;
                        break;
                    case 4:
                        numCartasJugador = 7;
                        break;
                    case 5:
                        numCartasJugador = 6;
                        break;
                    default:
                        break;
                }
               
               jugadores = new Jugador[numJugadores];
               
                for (int i = 0; i < numJugadores; i++){
                    jugadores[i] = new Jugador(ES.pideCadena("Introduce el nombre del jugador " + i));
                }

                System.out.println("---------- Comienza el juego! ---------");
                
            mesa = new Mesa();  //Creamos Mesa
            baraja=new Baraja(); //Creamos Baraxa
            
            do{
                boolean manoVacia= false;
                int PuntosAcum=0;
                ronda++;
              
              System.out.println("\n#####################################");
              System.out.println("Ronda: " + ronda);  
              
              System.out.println("Repartiendo cartas...\n"); //Repartimos cartas xogadores
                
                for(int j =0 ; j < numJugadores ; j++){
                    for(int i =0 ; i < numCartasJugador ; i++){
                        jugadores[i].aÒadirCartaMano(baraja.devolverArriba());
                    }
                }
                
                for(int i = 0; i<numJugadores; i++){ //INTERACCION CON TODOS OS XOGADORES
                  //VISUALIZAR MANO DEL JUGADOR POR RONDA

                        jugadores[i].verMano();

                    //VISUALIZAR MESA DEL JUGADOR POR RONDA

                         mesa.verMesa();
                      // FALTA seleccionar a carta, gardar a s˙a posiciÛn 

                       Carta c =jugadores[i].eliminarCartaMano(pos); //Quitamos carta mano
                       jugadores[i].colocarCartaMesa(c);    //AÒadir carta mesa
                       
                       //QUITAMOS AS CARTAS DA MESA AO FINAL DA RONDA
                        jugadores[i].eliminarCartasMesa();

                  }    
                
                   for(int i = 0; i < numJugadores; i++){
                       jugadores[i].pasarCartasIzqd();
                   } 
                            
                    //MOSTRAMOS PUNTOS FINALES E PARCIALES AO ACABAR A RONDA
                        System.out.println("Final de la ronda "+ ronda);

                    for (int i = 0; i < numJugadores; i++) {
                         System.out.println(jugadores[i].getNombre() + " consiguiÛ:  " + jugadores[i].calcularPuntos()+ " puntos esta ronda");
                    }
                    
                    
                    
                    
                }while(ronda != RONDAS);
                      
                      
                      System.out.println("Fin de la partida!");
                      System.out.println("Se mostrar·n los rollitos y puntos de los jugadores:");
                      
                    //MOSTRAMOS PUNTOS FINALES AO ACABAR A PARTIDA
                    for (int i = 0; i < numJugadores; i++) {
                         System.out.println(jugadores[i].getNombre() + " tiene " + jugadores[i].numRollitosJugador()+ " rollitos.\n");
                        
                    }  
                    
                    int maximoPuntos = jugadores[0].puntosFinales(); //VARIABLE ONDE VAMOS OBTER A PUNTUACION MAIS ALTA
                      for (int i = 0; i < numJugadores; i++) {//MOSTRAMOS PUNTUACION FINAL E OBTEMOS A MAXIMA PUNTUACION
                         
                         System.out.println(jugadores[i].getNombre() + " consiguiÛ:  " + jugadores[i].puntosFinales() + " puntos en total. y\n");
                         
                         if(jugadores[i].puntosFinales() > maximoPuntos){
                            maximoPuntos = jugadores[i].puntosFinales();
                         }
                    }

                    //GANADOR
                      System.out.println("------ El ganador(es) es(son): -------"); 
                      for(int i = 0; i <numJugadores ; i++){
                          if(maximoPuntos == jugadores[i].puntosFinales()){
                              System.out.println(jugadores[i].getNombre());
                          }
                      }
                    

                      System.out.println("------ Enhorabuena -------!");
                      System.out.println("---------FIN DEL JUEGO---------"); 
                    }


}
