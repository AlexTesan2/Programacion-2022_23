package EXAMEN;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class EstructuraBasica extends Applet {
    Image imagen;
    Graphics noseve;
    public static int  NUM_CARTAS;
    public static int SIZEX=600;
    public static int SIZEY=600;
    
    public void init(){
        this.setSize(SIZEX,SIZEY);
        imagen = this.createImage(SIZEX,SIZEY);
        noseve = imagen.getGraphics();
        //reverso = getImage(getCodeBase(), "E08Ims/re.jpg");
        
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.green);
        noseve.fillRect(0,0,SIZEX,SIZEY); 
        
        g.drawImage(imagen, 0, 0, this); 
    }
    
    public void update(Graphics g){
        paint(g);
    }  

}
