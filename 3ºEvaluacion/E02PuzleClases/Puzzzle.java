package E02PuzleClases;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Puzzzle extends Applet {
    public static final int PIEZAS = 25;
    public static final int DIM = 5;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Image img;
    Image imagenes[];
    Piezza piezas[];
    Piezza actual;
    Rectangle destinos[][];
    
    
    public void init(){
        this.setSize(500,500);
        imagen = this.createImage(500,500);
        noseve = imagen.getGraphics();
        
        piezas = new Piezza[PIEZAS];
        imagenes = new Image[PIEZAS]; 
        for(int i=0; i<PIEZAS;i++){
            imagenes[i] = getImage(getCodeBase(), "E02PuzleImagenes/" + (i+1) + ".png");
            piezas[i] = new Piezza(imagenes[i], i);
        }
        destinos = new Rectangle[DIM][DIM];
        for(int i=0; i < DIM; i++)
            for(int j=0; j < DIM; j++)
                destinos[i][j] = new Rectangle(j * Piezza.DIMENSION, i * Piezza.DIMENSION, Piezza.DIMENSION, Piezza.DIMENSION);
    }
    

    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,500,500); 
        noseve.setColor(Color.WHITE);
        
        for(int i=0; i < DIM; i++)
            for(int j=0; j < DIM; j++){
                noseve.drawRect(destinos[i][j].x, destinos[i][j].y, destinos[i][j].width, destinos[i][j].height);           
            }     
        
        for(Piezza pieza: piezas)
            pieza.paint(noseve, this);
            g.drawImage(imagen, 0, 0, this);
        } 
    
    public void update(Graphics g){
        paint(g);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        for(Piezza pieza : piezas){
            if(pieza.contains(x,y)){
               actual = pieza;
               actual.update(x, y);
               //break;
            }
        }
        return true;
    }
    
    public boolean mouseDrag(Event ev, int x, int y){
        if(actual != null){
            actual.update(x, y);
            repaint();
        }
        return true;
    }
    
    public boolean mouseUp(Event ev, int x, int y){
        if(actual != null){
            for(int i=0; i < DIM; i++)
                for(int j=0; j < DIM; j++)
                    if( (actual.intersects(destinos[i][j]))  && (actual.getPosicion() == (i*DIM) + j)){
                        actual.x = j * Piezza.DIMENSION;
                        actual.y = i * Piezza.DIMENSION;
                        actual.setMover(false);
                    }
        }
        repaint();
        actual = null;
        return true;
    }
}           
