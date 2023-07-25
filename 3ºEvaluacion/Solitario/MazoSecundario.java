package Solitario;

import java.applet.Applet;
import java.awt.Graphics;

public class MazoSecundario {
    public static int posX=150;
    public static int posY=20;
    java.util.ArrayList<Carta> mazosec;
    
    public MazoSecundario(){
        mazosec= new java.util.ArrayList();
    }
    
    public void añadir(Carta c){
        mazosec.add(c);
    }
    
    public Carta extraer(){
        return mazosec.get(mazosec.size()-1);
    }
    
    public void eliminar(){
       mazosec.remove(mazosec.size()-1);
    }
    
    
    public void recolocar(){
        mazosec.get(mazosec.size()-1).setPos(posX, posY);
    } 
    
    public void mostrar (Graphics g, Applet a) {
        for (int i = 0; i < mazosec.size(); i++) {
            mazosec.get(i).paint(g, a);
        }
    }
    
    public void paint(Graphics g, Applet a){
        for(Carta actual : mazosec){
            actual.paint(g, a);
            actual.setPos(posX, posY);
        }
        
    }
}
