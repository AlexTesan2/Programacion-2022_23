package E04LaberintoNumerico;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Lugar extends Rectangle {
    public static final int DIMENSION=48;
    private Image img;
    private int valor;


    public Lugar(Image img, int posX, int posY, int v){  //le pasan la imagen y su posicion
        super(posX,posY, DIMENSION, DIMENSION);
        this.img=img;
        valor=v;
    }
    
    public void paint(Graphics g,Applet a){//dibuja la imagen en su posicion sobre el applet
        if(img != null)
            g.drawImage(img, x, y, a);
    }
    
    
    //geters y seters
    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
