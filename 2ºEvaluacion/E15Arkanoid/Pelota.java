package E15Arkanoid;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Pelota extends Rectangle {
    
    int velX;
    int velY;
    
    public Pelota(){
        super(100,100,10,10);
        velX=(int)(Math.random()*2)+2;
        velY=(int)(Math.random()*2)+2;
    }
    
    public void paint(Graphics g){
        g.setColor(java.awt.Color.red);
        g.fillOval(x, y, this.width, this.height);
    }
    
    public void update(Raqueta r, List<Ladrillo>lista ){
        if ((x<=0) || (x>(300-width)))
            velX = -velX;
        if ((y<=0) || (y>(300-width)))
            velY = -velY;
        x+=velX;
        y+=velY;
        
        if(this.intersects(r))
            velY=-velY;
        
        for (int i = 0; i < lista.size(); i++) {
            if(this.intersects(lista.get(i))){
                lista.remove(i);
                velY=-velY;
                break;
            }
        }
    }
}
