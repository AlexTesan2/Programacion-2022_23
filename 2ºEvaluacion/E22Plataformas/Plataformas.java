package E22Plataformas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Plataformas extends Rectangle {
    
    public static final double VELY = 1.8;
    Color color= Juego.colores[(int)(Math.random()*Juego.colores.length)];
    
    public Plataformas(){
        super((int)(Math.random()*270),-5,70,5);
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void update(){
        y=(int)(y+VELY);
    }
}
