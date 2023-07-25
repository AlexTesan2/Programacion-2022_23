package E06BlackJack;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

public class Mano {
    
    ArrayList<Carta> cartas;

    public Mano(){
        cartas=new ArrayList<Carta>();
    }
    
    public void anadir(Carta carta){
        cartas.add(carta);
    }
    
    public int puntuacion(){//as 1 o 11 no pasarse de 21
        int acumulador=0;
        boolean as=false;
        for(Carta carta: cartas){
            acumulador += carta.getValor();
            if(carta.getValor()==1)
                as=true;
        }
        if((as)&&(acumulador<12)) acumulador +=10;
    
        return acumulador;
    } 
    
    public void paint (Graphics g, Applet a, int posY) {
        
        for (int i = 0; i < cartas.size(); i++) {
            cartas.get(i).setPosX(i*30 +250);
            cartas.get(i).setPosY(posY);
            cartas.get(i).paint(g, a);
        }
    }
    
    public boolean teHasPasado(){
        return puntuacion() > 21; 
    }
    
    public boolean alacanza17(){
        return puntuacion() >= 17;
    }
}
