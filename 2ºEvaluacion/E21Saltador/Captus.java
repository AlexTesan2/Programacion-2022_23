package E21Saltador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Captus extends Rectangle{
    int velX;
    Color color= Juego.colores[(int)(Math.random()*Juego.colores.length)];
    
    public Captus(){
        super(350,210,20,20);
        velX=(int)(Math.random()*3)+3;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void update(){
        x-=velX;
    }
    
}
