package E14Pelota;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle{
    Color colr;
    int velX;
    int velY;
    Color colores[]={Color.GREEN, Color.CYAN,Color.RED, Color.yellow,Color.ORANGE, Color.WHITE, Color.magenta};
    
    public Pelota(int diametro){
        super((int)((Math.random()*250)+100),(int)((Math.random()*250)+100),diametro, diametro);
        this.colr=colores[(int)(Math.random()*colores.length)];
        velX=(int)(Math.random()*5)+1;
        velY= (int)(Math.random()*5)+1;
    }
    
    public void paint(Graphics g){
        g.setColor(colr);
        g.fillOval(x, y, this.width, this.height);
    }
    
    public void update(){
        if ((x<=0) || (x>(400-width)))
            velX = -velX;
        if ((y<=0) || (y>(400-width)))
            velY = -velY;
        x+=velX;
        y+=velY; 
    }
}
