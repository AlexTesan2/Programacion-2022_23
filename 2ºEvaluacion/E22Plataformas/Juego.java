
package E22Plataformas;

import E21Saltador.Captus;
import E21Saltador.Dino;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable {
    
    public static final  Color colores[]={Color.MAGENTA,Color.ORANGE,Color.WHITE,Color.lightGray,Color.BLUE,Color.CYAN};
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    public static final int TIEMPO=30;
    boolean fin=false;
    boolean sub=false;
    public static boolean imposible=false;
    int score=0;
    
    List <Plataformas> plataformas;
    Indi indi;
    
    /**
     * @author alex
     */
    
    public void init(){
        this.setSize(300, 300);
        
        plataformas=new  ArrayList<Plataformas>();
        indi=new Indi();
        
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
        
        /*noseve.setColor(Color.black);
        noseve.drawString("SCORE:  "+ score, 110, 260);*/
        
        for (int i = 0; i < plataformas.size(); i++) {
            plataformas.get(i).paint(noseve);
        }
        
        indi.paint(noseve);
        
        if(fin){
            noseve.setColor(Color.white);
            noseve.setFont(new Font("TimesRoman", Font.BOLD,25));
            noseve.drawString("GAME", 110, 40);
            noseve.drawString("OVER", 110, 70);
        }
        
        g.drawImage(imagen, 0, 0, this);
    } 
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) { 
            
            
            cronometro+=TIEMPO;
            if(cronometro>=1500){
                plataformas.add(new Plataformas());
                cronometro=0;
            }
            
            for (int i = 0; i < plataformas.size(); i++) {
                plataformas.get(i).update();
            }
            indi.update();
            
            
            for (int i = 0; i < plataformas.size(); i++) {
                if(plataformas.get(i).intersects(indi)){
                    indi.y=plataformas.get(i).y-15;
                }
            }
            /**
             * @retun fin = true
             */
            if (indi.y>310) {
                fin=true;
                repaint();
                animacion.stop();
            }
            
            repaint();
            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {}
        }
        
    }
    
    public boolean keyDown (Event ev , int tecla){
        
        if(tecla==1006)
            indi.izda();
        if(tecla==1007)
            indi.dcha();
        
        if(tecla==1004)
           indi.arriba();
        
        return true;
    }
}
