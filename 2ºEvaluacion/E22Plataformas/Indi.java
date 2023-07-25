package E22Plataformas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Indi extends Rectangle{
    public static final int RADIO=15;
    public static final int VELCAIDA=2;
    public static final int VELX=3;
    
    public Indi(){
        super(150,-600,RADIO,RADIO);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.green);
        g.fillOval(x, y, RADIO, RADIO);
    }
    
    public void update(){
        y=y+VELCAIDA;
        if (x>280) x=280;
        if (x<0) x=0;
        if(y>1) Juego.imposible=true;
        
        if (Juego.imposible) {
            if (y<0) {
              y=0;  
            }
        }
    }
    
    public void izda(){
        x=x-VELX;
    }
    
    public void dcha(){
        x=x+VELX;
    }
    
    public void arriba(){
        y=y-2*(VELCAIDA);
    }
}
    

