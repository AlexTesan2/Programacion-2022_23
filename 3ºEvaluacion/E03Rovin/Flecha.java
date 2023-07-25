package E03Rovin;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.List;

public class Flecha extends Point {
    public static final int VELX=10;
    Image imagen;
    public Flecha (Image img, int posY){
        super(110, posY);
        imagen=img;
    }
    
    public void paint(Graphics g,Applet a){
        g.drawImage(imagen, x-50, y, 80, 28, a);
    }
    
    public void update(List<Globo> globos) {
        x+=VELX;
    
        for(Globo g1: globos)//si intersecta, rompe el globo
            if (g1.contains(this)) {
                globos.remove(g1);
                break;
            }
        
    }
}
