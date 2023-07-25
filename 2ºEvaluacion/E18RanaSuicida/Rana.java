package E18RanaSuicida;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Rana extends Rectangle{
    
    int vel=6;
    public Rana(){
        super(140,275,20,20);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        if(x>280)
            x=280;
        if(x<0)
            x=0;
        if(y>280)
            y=280;
        if(y<0)
            y=0;
    }
    
    
    public void arriba(){
        y-=vel;
    }
    
    public void abajo(){
        y+=vel;
    }
    
    public void izda(){
        x-=vel;
    }
    
    public void dcha(){
        x+=vel;
    }
}
