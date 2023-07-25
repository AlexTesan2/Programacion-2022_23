package E21Saltador;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable {

    public static final  Color colores[]={Color.MAGENTA,Color.ORANGE,Color.BLACK,Color.WHITE,Color.lightGray};
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    public static final int TIEMPO=30;
    boolean fin=false;
    boolean sub=false;
    int score=0;
    
    Dino dino;
    List <Captus> enanos;
    
    public void init(){
        this.setSize(300, 300);
   
        dino= new Dino();
        enanos=new  ArrayList<Captus>();
        
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
        noseve.setColor(Color.CYAN);
        noseve.fillRect(0, 0, 300, 300);
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 232, 300, 70);
        noseve.setColor(Color.black);
        noseve.fillRect(0, 230, 300, 2);
        
        dino.paint(noseve);
        
        noseve.setColor(Color.black);
        noseve.drawString("SCORE:  "+ score, 110, 260);
        
        for (int i = 0; i < enanos.size(); i++) {
            enanos.get(i).paint(noseve);
        }
        if(fin){
            noseve.setColor(Color.black);
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
                enanos.add(new Captus());
                cronometro=0;
            }
            if(dino.y<180)
                dino.update();
            if(dino.y<149)
                dino.update();
            
            for (int i = 0; i < enanos.size(); i++) {
                enanos.get(i).update();
                
                if (enanos.get(i).x<-10) {
                    enanos.remove(i);
                    score++;
                }
            }
            
            for (int i = 0; i < enanos.size(); i++) {
                if (enanos.get(i).intersects(dino)) {
                    fin=true;
                    repaint();
                    animacion.stop();
                }
            }
            
            if (sub) {
                dino.y = dino.y-5;
                if (dino.y<120) {
                    sub=false;
                }
            }
            
            
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {}
        }
        
    }
    
    public boolean keyDown (Event ev , int tecla){
        
        if((tecla==1004) && (dino.y == 180)){
            sub=true;
        }
        return true;
    }
}
