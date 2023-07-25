package E15Arkanoid2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Raqueta extends Rectangle{
    Color color;
    int velX;
    
    public Raqueta(){
        super(250,550,100,10);
        color = Color.WHITE;
        velX = 10;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x+10, y, width-20, height);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, 10, height);
        g.fillRect(x+width-10, y, 10, height);
        g.setColor(color);
        g.drawRect(x, y, width, height);
        
    }
    public void update(int direccion){
        x += (velX * direccion);
    }
}
