package E19Tenis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Raqueta {

    private Rectangle raqizda;
    private Rectangle raqder;
    int velY=3;
    
    public Raqueta(){
       raqizda=new Rectangle(15, 150, 15, 120) ;
       raqder=new Rectangle(270,150,15,120);
    }
    
    /*public Raqueta extends Rectangle(){    crear dos raquqtas en el tenis y pasaarles la posic eje x
        private int vlY
        public Raqueta(posX){
            super()
        }
    }*/
    
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(raqizda.x, raqizda.y, raqizda.width, raqizda.height);
        g.fillRect(raqder.x, raqder.y, raqder.width, raqder.height);
    }

    
    public void update( int tecla){//119 , 115
        switch (tecla) {
            case 1004:
                raqder.y=raqder.y-velY;
                break;
            case 1005:
                raqder.y=raqder.y+velY;
                break;
            case 119:
                raqizda.y=raqizda.y-velY;
                break;
            case 115:
                raqizda.y=raqizda.y+velY;
                break;
        }
    }
    
    public void margenes(){
        if(raqizda.y<=0)
            raqizda.y=0;
        if(raqizda.y>180)
            raqizda.y=180;
        if(raqder.y<=0)
            raqder.y=0;
        if(raqder.y>180)
            raqder.y=180;
    }
    
    
    public Rectangle getRaqizda() {
        return raqizda;
    }

    public void setRaqizda(Rectangle raqizda) {
        this.raqizda = raqizda;
    }

    public Rectangle getRaqder() {
        return raqder;
    }

    public void setRaqder(Rectangle raqder) {
        this.raqder = raqder;
    }
}
