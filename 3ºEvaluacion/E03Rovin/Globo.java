package E03Rovin;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Globo extends Rectangle {
    public static final  int ANCHURA=40;
    public static final  int ALTURA=50;
    Image imagen;
    int velY;
    
    public Globo(Image img){ 
        super((int)(Math.random()*70)+300,405,ANCHURA,ALTURA);//img.getHeight(null)
        imagen=img;
        velY=(int)(Math.random()*4)+3;
    }
    
    public void paint(Graphics g,Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    
    public void update(){
        y-=velY;
    }
}