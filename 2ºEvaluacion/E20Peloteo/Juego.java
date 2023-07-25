package E20Peloteo;


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
    List <Pelota> pelotas;
    
    
    
    public void init(){
        this.setSize(300, 300);
        
        pelotas = new ArrayList <Pelota>();
        pelotas.add(new Pelota(100,100,400));
                
        imagen = this.createImage(300,300);
        noseve = imagen.getGraphics();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){

        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 300, 300);
        
        for (int i = 0; i < pelotas.size(); i++) {
            pelotas.get(i).paint(noseve);
        }
        
        if(fin){
            noseve.setColor(Color.white);
            noseve.setFont(new Font("TimesRoman", Font.BOLD,20));
            noseve.drawString("Ganaste", 110, 20);
        }
        
        g.drawImage(imagen, 0, 0, this);
        
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) {
            
            cronometro += TIEMPO;
            if(cronometro >= 1200){

                cronometro=0;
            }
            for (int i = 0; i < pelotas.size(); i++) {
                pelotas.get(i).update();
            }
            
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
    }
    
    
    public boolean mouseDown(Event ev, int x ,int y ){
        for (int i = 0; i < pelotas.size(); i++)  //debuelve una pelota
            if (pelotas.get(i).contains(x,y)) {
                if(pelotas.get(i).width>15){
                    pelotas.add(new Pelota(pelotas.get(i).x,pelotas.get(i).y,pelotas.get(i).width/2));
                    pelotas.add(new Pelota(pelotas.get(i).x,pelotas.get(i).y,pelotas.get(i).width/2));
                }
                pelotas.remove(i);
                break;
            
            }
        
        return true;
    }

}
