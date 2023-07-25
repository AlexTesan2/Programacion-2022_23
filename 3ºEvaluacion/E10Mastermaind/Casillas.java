package E10Mastermaind;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casillas extends Rectangle {
    public static final int DIM=200;
    
    public Casillas(int posX, int posY){
        super(posX, posY, DIM, DIM);
    }
    
    public void paint(Graphics g,  Applet a){
        g.setColor(Color.BLACK);//pintar el borde
        g.drawRect(x, y, width, height);
    }
}