package E00Examen2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RectangulosArriba extends Rectangle{
    Color color;
    int velX;
    int velY;
    
    public RectangulosArriba(int pos){
        super((int)((Math.random()*150)+100),(int)((Math.random()*150)+100),Juego.propor1, Juego.propor1);
        velX=(int)(Math.random()*5)-1;
        velY= (int)(Math.random()*5)-1;
        color=Juego.COLORES[pos];
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void update(){
        if ((x<=6) || (x>(340-width)))
            velX = -velX;
        if ((y<=6) || (y>(325-width)))
            velY = -velY;
        x+=velX;
        y+=velY; 
    }
    
    
    /**/
}
