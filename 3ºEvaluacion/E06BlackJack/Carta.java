package E06BlackJack;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta{
    Image imagen;
    private int valor;
    private int posX, posY;
    private int ANCHURA=70;
    private int ALTURA=100;
    
    public Carta(Image img, int v){
        imagen=img;
        //valor=(v>10)?10:v;
        if (v>10) valor=10;
        else valor=v;
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, posX, posY,ANCHURA,ALTURA, a);
    }
    //getters y seters...
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
