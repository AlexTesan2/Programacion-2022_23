package E10Mastermaind;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ficha extends Rectangle{
    public static final int DIM=80;
    public static final int posX=700;
    private Image im;
    
    public Ficha(Image i,int posY){
        super(posX,posY, DIM,DIM);
        this.im=i;
    }
    
    public void dibujar(Graphics g,  Applet a){
        g.drawImage(im, x, y, DIM, DIM, a);
    }

    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }
    
}
