package Pruebas1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Cartas extends Rectangle{

    public static final int SIZE=90;
    private Image i;
    private Image rev;
    private boolean mostrar=false;
    
    public Cartas(int posX,int posY,Image im,Image re){
        super(posX,posY,SIZE,SIZE);
        this.i=im;
        this.rev=re;
    }
    
    public void paint (Graphics g, Applet a) {
        if (mostrar) {
            g.drawImage(i, x, y,width,height, a);
        }else{
            g.drawImage(rev, x, y,width,height, a);
        }
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }

    public Image getI() {
        return i;
    }

    public void setI(Image i) {
        this.i = i;
    }

    public Image getRev() {
        return rev;
    }

    public void setRev(Image rev) {
        this.rev = rev;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }
}
