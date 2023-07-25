
package E10MasterMaind2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class Ficha extends Rectangle{

    private Image imagen;
    public static final int DIMENSION = 50;
    public boolean tapada;
    
    public Ficha(Image img, int posX, int posY, boolean tap){
        super(posX,posY,DIMENSION,DIMENSION);
        tapada = tap;
        imagen = img;;
    }

    
    public void paint(Graphics g, Applet a){
        if(tapada){
            g.setColor(Color.black);
            g.fillRect(x-5, y-5, DIMENSION+10, DIMENSION+10);
        }else
            g.drawImage(imagen, x, y, DIMENSION, DIMENSION, a);
    }
    
    public void move(int posX, int posY){
        x = posX;
        y = posY;
    }
    
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}