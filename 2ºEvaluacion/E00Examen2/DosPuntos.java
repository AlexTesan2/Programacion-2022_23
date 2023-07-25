package E00Examen2;

import java.awt.Color;
import java.awt.Graphics;

public class DosPuntos {
    
    Color color;
    
    private int posIniX, posIniY, posFinX, posFinY;
    
    public DosPuntos(int px1, int py1, int px2, int py2, Color col){
        posIniX = px1;
        posIniY = py1;
        posFinX = px2;
        posFinY = py2;
        color=col;
    }
    
    public DosPuntos(int px1, int py1, Color col){
        this(px1,py1,px1,py1,col);
        //color = col;
    }
     
    public int getPosIniX() {
        return posIniX;
    }

    public void setPosIniX(int posIniX) {
        this.posIniX = posIniX;
    }

    public int getPosIniY() {
        return posIniY;
    }

    public void setPosIniY(int posIniY) {
        this.posIniY = posIniY;
    }

    public int getPosFinX() {
        return posFinX;
    }

    public void setPosFinX(int posFinX) {
        this.posFinX = posFinX;
    }

    public int getPosFinY() {
        return posFinY;
    }

    public void setPosFinY(int posFinY) {
        this.posFinY = posFinY;
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.drawLine(posIniX, posIniY, posFinX, posFinY);
    }
    
}
