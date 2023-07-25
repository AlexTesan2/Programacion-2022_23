package E01SpritesEjecutable;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Personajes {
    int actual;
    private Image imagenes [];
    
    public Personajes(Image imagenes[]){
        this.imagenes = imagenes;
        actual = 0;  
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagenes[actual], 0, 0, 200, 300, a);
    }
    
    public void update(){
        actual = (actual + 1) % imagenes.length;
    }
    
    public Image[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(Image[] imagenes) {
        this.imagenes = imagenes;
    }
}
