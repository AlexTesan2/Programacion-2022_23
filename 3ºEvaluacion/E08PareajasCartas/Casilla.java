package E08PareajasCartas;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    private Image imagen;
    private Image reverso;
    private Boolean descubierta;
    public static final int DIM = 140;
    
    public Casilla(int posX, int posY, Image img, Image rev){
        super(posX, posY, DIM, DIM);
        descubierta = false;
        this.imagen = img;
        this.reverso = rev;
    }
    
    
    public void paint(Graphics g,  Applet a){
        
        if(descubierta)
            g.drawImage(imagen, x, y, width, height, a);
        else
            g.drawImage(reverso, x, y, width, height, a);
        
        g.setColor(Color.BLACK);//pintar el borde
        g.drawRect(x, y, width, height);
    }
    
    public Boolean isDescubierta() {
        return descubierta;
    }
    

    public void setDescubierta(Boolean descubierta) {
        this.descubierta = descubierta;
    }

    //getters y seters 
    
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

}
