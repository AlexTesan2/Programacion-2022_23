package E00ExamenAlexTesan;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Controles extends Rectangle{
    private Image imCoche;
    public static final int DIMX=40;
    private int valor;
    
    public Controles(int posX,int posY,int dimY,Image im, int val){
        super(posX,posY,DIMX,dimY);
        this.imCoche=im;
        this.valor=val;
    }
    
    public void paint (Graphics g,Applet a) {
        g.drawImage(imCoche, x, y,width, height ,a);
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Image getImCoche() {
        return imCoche;
    }

    public void setImCoche(Image imCoche) {
        this.imCoche = imCoche;
    }
}
