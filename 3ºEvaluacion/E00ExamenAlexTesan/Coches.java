package E00ExamenAlexTesan;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Coches extends Rectangle{
    private Image imCoche;

    public static final int DIMX = 230;
    public static final int DIMY=130;
    public static final int POSY=12;
    
    
    public Coches(int posX, Image im){//Para los pequeños
        super(posX,POSY,DIMX,DIMY);
        this.imCoche=im;
    }
    
    public Coches(int posX,int posY, Image im){//Para el grande
        super(posX,posY,DIMX*2,DIMY*2);
        this.imCoche=im;
    }
    
    public void paint (Graphics g,Applet a) {
        g.drawImage(imCoche, x, y,width, height ,a);
    }
    
    public Image getImCoche() {
        return imCoche;
    }

    public void setImCoche(Image imCoche) {
        this.imCoche = imCoche;
    }
}
