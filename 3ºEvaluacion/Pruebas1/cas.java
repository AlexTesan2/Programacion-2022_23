package Pruebas1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class cas extends Rectangle{
    public static int DIM=40;
    Color color;
    int x,y;
    private Fi f;

    public cas (int posX,int posY, Color c){
        super(posX,posY,DIM,DIM);
        this.color=c;
        x=posX;
        y=posY;
    }
    
    public void paint (Graphics g) {
        g.setColor(color);
        g.drawRect(x, y, DIM, DIM);
    }
    
    public Fi getF() {
        return f;
    }

    public void setF(Fi f) {
        this.f = f;
    }
}
