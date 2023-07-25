package E16FlappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pajaro extends Rectangle{
    public Pajaro(){
        super(10,10,10,10);           //        super(10,10,10,10);
    }
    
    public void paint(Graphics g){   //le pones tu el nombre a paint
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        y++;
        if(y<=-5)
            y=0;
    }
    
    public void subir(){
        y-=6;
    }
}
