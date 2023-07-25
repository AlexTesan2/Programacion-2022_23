package E00Examen2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RectangulosAbajo extends Rectangle{
    Color color;
    
    public RectangulosAbajo(int pos){
        super((70*pos)+10, 345, Juego.propor1, Juego.propor1);
        color=Juego.COLORES[pos];
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
