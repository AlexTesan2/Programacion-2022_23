package Pruebas1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Fi extends Rectangle{
    private Image Imagen;
    private boolean tapada;
    public static final int dim=cas.DIM-5;
    private boolean movible;
    
    public Fi (int posX,int posY,Image Im){
        super(posX,posY,dim,dim);
        Imagen=Im;
        tapada=false;
        movible=true;
    }
    
    public void paint (Graphics g,Applet a) {
        if (tapada) {
            g.setColor(Color.black);
            g.fillRect(x, y, width+5, height+5);
        }else{
            g.setColor(Color.red);
            g.drawRect(x, y, width, height);
            g.drawImage(Imagen, x, y, width, height, a);
        }
    }
    
    public void move(int posX, int posY){
        if(movible){
            x = posX;
            y = posY;
        }
    }

    public Image getImagen() {
        return Imagen;
    }

    public void setImagen(Image Imagen) {
        this.Imagen = Imagen;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    } 
    
    public boolean isMovible() {
        return movible;
    }

    public void setMovible(boolean movible) {
        this.movible = movible;
    }
}
