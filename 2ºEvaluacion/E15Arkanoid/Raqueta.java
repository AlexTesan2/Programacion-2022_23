package E15Arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Raqueta extends Rectangle {
    private int velX;
    
    public Raqueta(){
        super(140,260,60,Ladrillo.ALTURA);
        velX=6;
    }
    
    public int getVelX(){
        return velX;
    }
    
    public void setVelX(){
        this.velX=velX;
    }
    
    public void pain(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }
    
    public void update(int direccion){//en q direccion se va a mover la raqueta
        x += velX*direccion;
        if (x<=0)
            x =0;
        if((x+40)>=300)
            x=260;
    }
}
