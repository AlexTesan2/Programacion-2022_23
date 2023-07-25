package E11Dibujos;

import java.awt.Graphics;

public class DosPuntos {
    
    public static final int LINEA = 0;
    public static final int OVALO = 1;
    public static final int RECTANGULO = 2;
    private int posIniX, posIniY, posFinX, posFinY;
    private int tipo;
    
    public DosPuntos(int px1, int py1, int px2, int py2, int tipo){
        posIniX = px1;
        posIniY = py1;
        posFinX = px2;
        posFinY = py2;
        this.tipo = tipo; 
    }
    
    public DosPuntos(int px1, int py1, int tipo){
        this(px1,py1,px1,py1, tipo);//llamamos al metodo constructor aterior, 
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public void paint(Graphics g){
        switch (tipo) {
            case LINEA:
                g.drawLine(posIniX, posIniY, posFinX, posFinY);
                break;
            case OVALO:
                g.drawOval(posIniX, posIniY, posFinX-posIniX, posFinY-posIniY);
                break;
            case RECTANGULO:
                g.drawRect(posIniX, posIniY, posFinX-posIniX, posFinY-posIniY);
        }
    }
}