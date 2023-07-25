package E17Naves;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Gun extends Rectangle{
    private int velX;
    
    public Gun(){               //valores iniciales
        super(145,275,20,25);
        velX=4;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
    
    public void update(int PosX){
        this.x= PosX-7;
        if(x<=0)
            x=0;
        if(x>=300)
            x=300;
        
    }
}


/*public void update(int direccion){
        if(direccion== Juego.DERECHA)
            this.x+=3;
        else 
            this.x -=3;
    }*/