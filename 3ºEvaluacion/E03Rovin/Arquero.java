package E03Rovin;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Arquero { //todo funciona sobre la imagen
    Image imagen;
    int posY;
    
    public Arquero(Image img){
        imagen=img;
        posY=150;
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, 20, posY,100,110, a);
    }
    
    public void update(int py){
        posY=py;
        if (posY<0) posY=0;
        if (posY>(550-imagen.getHeight(null))) posY=550-imagen.getHeight(null);
    }
}
