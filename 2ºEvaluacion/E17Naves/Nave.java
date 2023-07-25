package E17Naves; //-200, 0 , vel aleat(2,6)---vel x=0 , vel y = 10

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Nave extends Rectangle{
    int velX;
    int velY;
    Color color;
    int kamikace;
    
    public Nave(){
        super((int)(Math.random()*279),(int)(Math.random()*30)-15,30,12);
        velX=(int)(Math.random()*9)-1;
        velY=(int)(Math.random()*4)+1;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }
    
    public void update(){
        if((x<0) || (x>280)) velX= -velX;
        x+=velX;
        y+=velY;
        
        /*if((int)(Math.random()*100)>50){
            velX=0;
            velY=10;
        }*/
    }
    
    public void rebote(){
        velX=-velX;
    }
    
    public void Kamikace(){
        velX=0;
        velY=10;
    }
    
}
