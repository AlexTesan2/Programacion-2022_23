package E00ExamenAlexTesan;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Fondo {
    private Image im;
    private boolean principio;//con este booleano determino si la imagen de fondo aparece ap principio o detras del anterior 
    private int posX;
    
    public Fondo(Image i, boolean pr, int posAnterior){
        this.im=i;
        this.principio=pr;
        
        if(principio) posX=0;
        else posX=Juego.SIZEX+posAnterior;
    }
    
    public void paint (Graphics g,Applet a) {
        
        g.drawImage(im, posX, 0,Juego.SIZEX, Juego.SIZEY ,a);
    }
    
    public void update(int vel){
        posX-=vel*2;
    }
    
    public Image getIm() {
        return im;
    }

    public void setIm(Image im) {
        this.im = im;
    }
    
    public boolean isPrincipio() {
        return principio;
    }

    public void setPrincipio(boolean principio) {
        this.principio = principio;
    }
    
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}