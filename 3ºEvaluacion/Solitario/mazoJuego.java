package Solitario;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class mazoJuego extends Rectangle{
    public static final int posY=250;
    java.util.List<Carta> mazo;
    int palo;
    
    public mazoJuego(int X){
        super(X,posY,Carta.ANCHURA,Carta.ALTURA);
        mazo = new java.util.ArrayList();
    }
    
    public void mostrar(Graphics g,Applet a){
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        for (int i = 0; i < mazo.size(); i++) 
            mazo.get(i).paint(g, a);
    }
    
    public void annadir(Carta c){
        if(mazo.size()==0){ 
            mazo.add(c);
            //recolocar();
            palo=c.getPalo();//solo podre meter catas del mismo palo
        }else{
            if(palo==c.getPalo())//si la new carta es del = palo
                if(mazo.get(mazo.size()-1).getValor()==c.getValor()-1){     //estudiar esta linea
                    mazo.add(c);
                    //recolocar();
                    //return true;
                }      
        }
        //return false;
    }
}
