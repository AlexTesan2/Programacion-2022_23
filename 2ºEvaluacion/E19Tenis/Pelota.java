package E19Tenis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle {
    
    int velX=3;
    int velY=3;
    
    public Pelota(){
        super(150,150,20,20);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        x+=velX;
        y+=velY;
        
        if ((x<=0) || (x>=300-width)) {
            if(x<=0){
                Tenis.alcatraz++;
                this.velX=3;
            }
            if(x>=300-width){
                Tenis.nadal++;
                this.velX=-3;
            }
            this.x=150;
            this.y=150;
            this.velY=0;
        }
        
        
        if((y<=0) || (y>=300-width))
            velY=-velY;
    }
    
}
