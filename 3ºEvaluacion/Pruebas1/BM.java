package Pruebas1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BM extends Applet {
    Image imagen;
    Graphics noseve;
    public static int  NUM_CARTAS;
    public static int SIZEX=200;
    public static int SIZEY=200;
    public static int MIMAS=10;
    Casilla casillas[][];
    Image rev,min;
    
    public void init(){
        this.setSize(SIZEX,SIZEY);
        imagen = this.createImage(SIZEX,SIZEY);
        noseve = imagen.getGraphics();
        rev=getImage(getCodeBase(), "E09Ims/casilla.png");
        min=getImage(getCodeBase(), "E09Ims/mina.png");
        casillas = new Casilla[MIMAS][MIMAS];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j]=new Casilla((i*10)+10,(j*10)+10,min,rev);
            }
        }
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.white);
        noseve.fillRect(0,0,SIZEX,SIZEY); 
        
        g.drawImage(imagen, 0, 0, this); 
    }
    
    public void update(Graphics g){
        paint(g);
    }  

}
