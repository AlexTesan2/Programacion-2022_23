package E02PuzleClases;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Piezza extends Rectangle{
    Image imagen;
    private boolean mover = true;
    public static final int DIMENSION = 60;
    private int posicion;
    
    public Piezza(Image img, int pos){
        super((int)(Math.random()*130)+300,(int)(Math.random()*400),DIMENSION,DIMENSION);
        imagen = img;
        posicion = pos;
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, a);
    }
    
    public void update(int posX, int posY){
        if(mover == true){
            x = posX - DIMENSION/2;
            y = posY - DIMENSION/2;
        }
    }
    
    public boolean isMover() {
        return mover;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}