package com.uvigo.poyectosushigo.CORE;
import core.Carta;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Iterator;


    
/*
* Representa las cartas que coloca el jugador en la mesa (únicamente las suyas).
* Estructura: Se utilizarán TADs adecuados para su respresentación. En concreto:Una lista de pilas 
* Funcionalidad: colocar una carta en la mesa, calcular la puntuación de las cartas de la mesa, calcular el número de rollitos, visualizar cartas de la mesa, descartar cartas de la mesa, etc
*/


public class CartasMesa {
    
    
    
    
    private List<Stack<Carta>> montonMesa; 


    public CartasMesa(){
         this.montonMesa = new ArrayList<>();
         
    }
    
    //COMPROBAMOS SE A CARTA ESTÁ NA MESA OU NON
    private int esta(Carta carta){
        
        if(montonMesa.isEmpty()){
            return -1;
        }else{
            int i = 0;
            
            while(i < montonMesa.size() && montonMesa.get(i).peek().getCarta.equals(carta.getCarta)){
                i++;
            }
            if(i == montonMesa.size()){
                return -1;
            }else{
            return i; //Se non está vacío devolve a posición da carta
            }
        }
    }
    

    
    public void colocarCarta(Carta carta) {

    int pos;
    
    // dependendo da carta 
    switch (carta.getCarta()) { //obtemos o tipo de carta
        
            case TEMPURA: 
                
               pos = esta(carta);
                
                if (pos == -1) {//Carta NON ESTÁ na mesa
                                
                    Stack<Carta> tempura = new Stack<>();// Creo nova pila
                    tempura.push(carta); //Meto carta na pila     
                    montonMesa.add(tempura); //Meto a pila na lista
                        
                }else {//Carta ESTÁ.
                    
                    montonMesa.get(pos).push(carta);
                }
            break;
            case MAKI1ROLLO: 
                
               pos = esta(carta);
                
                if (pos == -1) {//Carta NON ESTÁ na mesa
                                
                    Stack<Carta> maki1 = new Stack<>();// Creo nova pila
                    maki1.push(carta); //Meto carta na pila     
                    montonMesa.add(maki1); //Meto a pila na lista
                        
                }else {//Carta ESTÁ.
                    
                    montonMesa.get(pos).push(carta);
                }
            break;
            case MAKI2ROLLO: 
                
               pos = esta(carta);
                
                if (pos == -1) {//Carta NON ESTÁ na mesa
                                
                    Stack<Carta> maki2 = new Stack<>();// Creo nova pila
                    maki2.push(carta); //Meto carta na pila     
                    montonMesa.add(maki2); //Meto a pila na lista
                        
                }else {//Carta ESTÁ.
                    
                    montonMesa.get(pos).push(carta);
                }
            break;
            case MAKI3ROLLO:
                
               pos = esta(carta);
                
                if (pos == -1) {//Carta NON ESTÁ na mesa
                                
                    Stack<Carta> maki3 = new Stack<>();// Creo nova pila
                    maki3.push(carta); //Meto carta na pila     
                    montonMesa.add(maki3); //Meto a pila na lista
                        
                }else {//Carta ESTÁ.
                    
                    montonMesa.get(pos).push(carta);
                }
            break;
            case GYOZA: 
                
               pos = esta(carta);
                
                if (pos == -1) {//Carta NON ESTÁ na mesa
                                
                    Stack<Carta> gyoza = new Stack<>();// Creo nova pila
                    gyoza.push(carta); //Meto carta na pila     
                    montonMesa.add(gyoza); //Meto a pila na lista
                        
                }else {//Carta ESTÁ.
                    
                    montonMesa.get(pos).push(carta);
                }
                break;
               case SASHIMI: 
                
                    pos = esta(carta);

                     if (pos == -1) {//Carta NON ESTÁ na mesa

                         Stack<Carta> sashimi = new Stack<>();// Creo nova pila
                         sashimi.push(carta); //Meto carta na pila     
                         montonMesa.add(sashimi); //Meto a pila na lista

                     }else {//Carta ESTÁ.

                         montonMesa.get(pos).push(carta);
                     }
                break;
                
                case NIGUIRIDECALAMAR: 
                    
                    pos = esta(new Carta(Carta.tipoCarta.WASABI)); 
                   
                    if(pos == -1){ //Carta NON ESTÁ na mesa
                        
                        Stack<Carta> niguiriCalamar = new Stack<>();// Creo nova pila
                         niguiriCalamar.push(carta); //Meto carta na pila     
                         montonMesa.add(niguiriCalamar); //Meto a pila na lista
                         
                    }else{
                        
                         montonMesa.get(pos).push(carta);
                    }     
                break;
                
                case NIGUIRIDETORTILLA:
                    
                    pos = esta(new Carta(Carta.tipoCarta.WASABI));
                    
                    if(pos == -1){ //Carta NON ESTÁ na mesa
                        
                        Stack<Carta> niguiriTortilla = new Stack<>();// Creo nova pila
                        niguiriTortilla.push(carta); //Meto carta na pila     
                        montonMesa.add(niguiriTortilla); //Meto a pila na lista
                        
                    }else{
                        
                         montonMesa.get(pos).push(carta);
                    } 
                break;
                
                case NIGUIRIDESALMON: 
                    
                    pos = esta(new Carta(Carta.tipoCarta.WASABI));
                    
                    if(pos == -1){ //Carta NON ESTÁ na mesa
                        
                         Stack<Carta> niguiriSalmon = new Stack<>();// Creo nova pila
                         niguiriSalmon.push(carta); //Meto carta na pila     
                         montonMesa.add(niguiriSalmon); //Meto a pila na lista
                         
                    }else{
                        
                         montonMesa.get(pos).push(carta);
                    } 
                break;
                
                case WASABI: 
                
                         Stack<Carta> wasabi = new Stack<>();// Creo nova pila
                         wasabi.push(carta); //Meto carta na pila     
                         montonMesa.add(wasabi); //Meto a pila na lista

                break;
        }
        System.out.println("Carta engadida ao montón.");
    }
        
        public int numRollitos(){ //CALCULAMOS O NUMERO DE ROLLITOS
            
        int nrollitos = 0;
        
         int pos;
 
                
                       pos = esta(new Carta(Carta.tipoCarta.MAKI1ROLLO));

                   if(pos != -1){

                       nrollitos += montonMesa.get(pos).size();

                   }

            
                    pos = esta(new Carta(Carta.tipoCarta.MAKI2ROLLO));

                    if(pos != -1){

                        nrollitos += montonMesa.get(pos).size();

                    }

                    pos = esta(new Carta(Carta.tipoCarta.MAKI3ROLLO));

                    if(pos != -1){

                        nrollitos += montonMesa.get(pos).size();

                    }

            
            return nrollitos;    //Devolve o numero de rollitos do xogador
        } 
        
        public int calcularPuntos(){ //CALCULAMOS OS PUNTOS
            int puntos = 0;
            
            //Recorremos lista
            for (int j = 0; j < montonMesa.size(); j ++) { 
                
                int cont = 0;
                
                switch (montonMesa.get(j).peek().getCarta()) { //obtemos o tipo de pila segundo as cartas almacenadas
        
                    case TEMPURA: //Calcular puntos tempura

                        cont = montonMesa.get(j).size()/2;
                        puntos = cont*5; 
                        
                    break;
                    
                    case SASHIMI: //Calcular puntos sashimi
                        
                        cont = montonMesa.get(j).size()/3;
                        puntos = cont*10;
                        
                    break;
                    
                    case GYOZA: //Calcular puntos gyoza
                       cont = montonMesa.get(j).size();
                       if(cont == 1){
                           puntos += 1;
                       }else if(cont == 2){
                           puntos += 3;
                       }else if(cont == 3){
                           puntos += 6;
                       }else if(cont == 4){
                           puntos += 10;
                       }else if(cont >= 5){
                               puntos += 15;
                               }
                    break;
                    
                    case WASABI: 
                        
                        Carta aux; //Variable auxiliar onde vamos almacenar o tipo de Nigiri
                        
                        if(montonMesa.get(j).size()%2 == 0){
                            aux = montonMesa.get(j).peek();
                        }
                        if(aux == carta.getCarta().NIGUIRIDECALAMAR){
                            puntos = puntos + 9;
                        }else if(aux == carta.getCarta().NIGUIRIDESALMON){
                            puntos = puntos + 6;
                        }else{puntos = puntos + 3;}
                        
                    break;
                    
                    case NIGUIRIDECALAMAR:
                        cont = montonMesa.get(j).size();
                        puntos = cont*3;
                    break;
                    
                    case NIGUIRIDESALMON:
                        cont = montonMesa.get(j).size();
                        puntos = cont*2;
                    break;
                    
                    case NIGUIRIDETORTILLA:
                        cont = montonMesa.get(j).size();
                        puntos = cont*1;
                    break;
                }
                 
            }
            return puntos;
        }

        //VISUALIZAR MESA
        public void visualizarMesa() {
            System.out.println("\n·············O meu montón de cartas é:·············");
            Iterator iter = montonMesa.iterator();
                while (iter.hasNext())
                    System.out.println(iter.next());
                 }
        public String toString (){
             return esta()+colocarCarta(Carta)+numRollitos()+calcularPuntos();
        }
        //QUITAR TODAS AS CARTAS DA MESA
        public void descartarCartas() {
            this.montonMesa = new ArrayList<>();  //CREAMOS UNHA NOVA MESA 
        }

}
