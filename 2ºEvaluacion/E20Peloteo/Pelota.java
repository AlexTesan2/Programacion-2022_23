package E20Peloteo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Pelota extends Rectangle {
    Color colores[]={Color.CYAN,Color.GREEN,Color.MAGENTA,Color.YELLOW};
    Color color;
    int velX,velY;
    
    public Pelota(int posX, int posY, int diametro){
        super(posX,posY, diametro, diametro);
        color=colores[(int)(Math.random()*colores.length)];
        velX=(int)(Math.random()*7)-3;
        velY=(int)(Math.random()*7)-3;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        x+=velX;
        y+=velY;
        if ((x<=0) || (x>=300-width)) {
            velX=-velX;
        }
        if ((y<=0) || (y>=300-width)) {
            velY=-velY;
        }
    }
}
