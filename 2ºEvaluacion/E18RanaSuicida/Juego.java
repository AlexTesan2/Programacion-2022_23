package E18RanaSuicida;

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
    public static final int IZQUIERDA=-1;
    public static final int DERECHA=1;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    boolean fin=false;
    boolean victoria=false; 
    Rana rana;
    List<Coche> coches;
    
    
    public void init(){
        this.setSize(300, 300);
        
        rana=new Rana();
        coches=new ArrayList <Coche>();
                
        imagen = this.createImage(300,300);
        noseve = imagen.getGraphics();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 0, 300, 300);
        
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 70, 300, 180);
        
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 155, 300, 10);
        
        rana.paint(noseve);
        
        for (int i = 0; i < coches.size(); i++) {
            coches.get(i).paint(noseve);
        }
        
        if(fin){
            noseve.setColor(Color.MAGENTA);
            noseve.setFont(new Font("TimesRoman", Font.BOLD,20));
            noseve.drawString("GAME", 110, 20);
            noseve.drawString("OVER", 110, 40);
        }
        
        if(victoria){
            noseve.setColor(Color.MAGENTA);
            noseve.setFont(new Font("TimesRoman", Font.BOLD,20));
            noseve.drawString("LEVEL", 110, 275);
            noseve.drawString("COMPLETED", 90, 295);
        }
        
        g.drawImage(imagen, 0, 0, this);
        
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) {
            
            rana.update();
            
            cronometro += TIEMPO;
            if(cronometro >= 1200){
                coches.add(new Coche());
                cronometro=0;
            }
            
            for (int i = 0; i < coches.size(); i++) {
                coches.get(i).update();
            }
            
            for (int i = 0; i < coches.size(); i++) {
                if (coches.get(i).getcArriba().x<-50) {
                    coches.remove(i);
                }
                if (coches.get(i).getcAbajo().x>320) {
                    coches.remove(i);
                }
            }
            
            
            for (int i = 0; i < coches.size(); i++) 
                if((coches.get(i).getcAbajo().intersects(rana)) || coches.get(i).getcArriba().intersects(rana)){
                    fin=true;
                    repaint();
                    animacion.stop();
                }
            
           
            if (rana.y<30) {
                victoria=true;
                repaint();
                animacion.stop();
            }
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
    }
    
    public boolean keyDown (Event ev , int tecla){
        
        if(tecla==1004)
            rana.arriba();
        if(tecla==1005)
            rana.abajo();
        if(tecla==1006)
            rana.izda();
        if(tecla==1007)
            rana.dcha();
            
        return true;
    }

}
