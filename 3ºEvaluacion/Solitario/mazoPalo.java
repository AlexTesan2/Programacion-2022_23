package Solitario;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class mazoPalo extends Rectangle{
    public static final int posY=20;
    java.util.List<Carta> mazo;
    int palo;
    
    public mazoPalo(int X){
        super(X,posY,Carta.ANCHURA,Carta.ALTURA);
        mazo = new java.util.ArrayList();
    }
    
    public void recolocar(){
        mazo.get(mazo.size()-1).setPos(x, y);
    }
    
    public void mostrar(Graphics g,Applet a){
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        for (int i = 0; i < mazo.size(); i++) 
            mazo.get(i).paint(g, a);
    }
    
    public boolean annadir(Carta c){
        if(mazo.size()==0){//si el tammaño de la ista es cero, 
            if(c.getValor()==1){//solo aceptaré una carta con el valor uno 
                mazo.add(c);
                recolocar();
                palo=c.getPalo();//solo podre meter catas del mismo palo
                return true;
            }
        }else{
            if(palo==c.getPalo())//si la new carta es del = palo
                if(mazo.get(mazo.size()-1).getValor()==c.getValor()-1){     //estudiar esta linea
                    mazo.add(c);
                    recolocar();
                    return true;
                }      
        }
        return false;
        
    }      
}
