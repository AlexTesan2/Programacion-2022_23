package E21Saltador;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Dino extends Rectangle{
    int cronometro;
    int tiempoArriba;
    boolean subo=false;
    
    public Dino(){
        super(60,180,20,50);
    }
    
    public void paint(Graphics g){
        g.setColor(java.awt.Color.red);
        g.fillOval(x, y, this.width, this.height);
    }  
    
    public void update(){
        if (y<180) 
            y++;
    }
}
