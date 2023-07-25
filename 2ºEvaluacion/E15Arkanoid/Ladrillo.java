package E15Arkanoid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ladrillo extends Rectangle{
    public static final int ANCHURA=28;
    public static final int ALTURA=10;
    Color color;
    
    public Ladrillo(int posX, int posY, Color c){
        super(posX,posY,ANCHURA,ALTURA);
        color=c;
    }
    
    public void paint (Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
