package E18Rana2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class CAR extends Rectangle{
    
    public static final int ANCHO=35;
    public static final int ALTO=15;
    int velX;
    Color color=Color.yellow;
    private boolean inRoad=true;
    
    public CAR(int posX, int posY){
        super(posX,posY,ANCHO,ALTO);
        velX=(int)(Math.random() * 3)+2;//velocidad aleatoria entre 2 y 5
        
        if(posX >= 300){ 
            velX=-velX;
            color=Color.CYAN;
        }
    }
    
    public boolean isInRoad() {
        return inRoad;
    }

    public void setInRoad(boolean inRoad) {
        this.inRoad = inRoad;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void update(frog rana){
        this.x += velX;
        if((x<-40)||(x>330))
            inRoad=false;
        
        if (rana.intersects(this)) {
            juego.fin=true;
        }
    }
}
