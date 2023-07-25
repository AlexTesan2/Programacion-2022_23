package Pruebas1;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    private boolean minado=false;
    private boolean tapada=false;
    private Image i;
    private Image r;
    public static int SIZE=10;
    
    public Casilla(int posX,int posY,Image im,Image re){
        super(posX,posY,SIZE,SIZE);
        this.i=im;
        this.r=re;
    }
    
    public void paint (Graphics g,Applet a) {
        
    }
    
    public Image getI() {
        return i;
    }

    public void setI(Image i) {
        this.i = i;
    }

    public Image getR() {
        return r;
    }

    public void setR(Image r) {
        this.r = r;
    }
    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }
    
    public boolean isMinado() {
        return minado;
    }

    public void setMinado(boolean minado) {
        this.minado = minado;
    }
}
