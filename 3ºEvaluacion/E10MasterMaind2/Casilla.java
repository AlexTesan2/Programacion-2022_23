
package E10MasterMaind2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Casilla extends Rectangle{
    private Ficha ficha;
    public int valor;
    public static final int DIMENSION = 60;
    public Color color;
    
    
    public Casilla(int posX, int posY, int v, Color c){
        super(posX,posY,DIMENSION,DIMENSION);
        valor = v;
        color = c;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.drawRect(x, y, DIMENSION, DIMENSION);
    }
    
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}