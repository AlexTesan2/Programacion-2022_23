package E05Ruleta;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int DIM=60;
    Color color;
    int valor;
    Image img;
    
    public Casilla(int posX, int posY, int v, Color c){
        super(posX, posY, DIM , DIM);
        valor=v;
        color =c;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
        g.setColor(color);
        g.setFont(new Font("TimesRoman",Font.PLAIN,24));
        g.drawString(""+ valor, x+20, y+20);
    }
}
