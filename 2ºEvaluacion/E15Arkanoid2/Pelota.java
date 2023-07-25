package E15Arkanoid2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle{
    Color color;
    int velX;
    int velY;
    
    public Pelota(Color color){
        super(290,529,20,20);
        this.color = color;
        velX = 3;
        velY = -3;
    }
    
    public void actualizar(){ 
        if(x >= (600 - this.width)|| x <= 0)
            velX = -velX;
        if (y <= 0)
            velY *= -1;
        x += velX;
        y += velY;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
        g.setColor(Color.ORANGE);
        g.drawOval(x, y, width, height);
    }
}
