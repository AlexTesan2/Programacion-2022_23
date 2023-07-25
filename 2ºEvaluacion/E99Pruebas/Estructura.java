/*package E99pruebas;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable{
    public static final int TIEMPO =30;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    boolean fin=false;
    
    public void init(){     
        this.setSize(300, 300);
        
        imagen = this.createImage(300,300);
        noseve = imagen.getGraphics();
        
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); //llama metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 300, 300);

        
        if(fin){
            noseve.setColor(Color.WHITE);
            noseve.setFont(new Font("TimesRoman", Font.BOLD,20));
            noseve.drawString("GAME", 110, 100);
            noseve.drawString("OVER", 110, 130);
        }
        
        
        g.drawImage(imagen, 0, 0, this);
    } 
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) { 
            cronometro += TIEMPO;
            if(cronometro >= 5000){
                
                cronometro=0;        
            }

            
            if(){
                fin=true;
                repaint();
                animacion.stop();
            }
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
        
    }
    
    /*public boolean keyDown(Event ev, int tecla ){
        if(tecla==32)//espacio 
        return true;
    }
}
*/
