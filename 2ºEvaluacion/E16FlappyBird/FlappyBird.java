package E16FlappyBird;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class FlappyBird extends Applet implements Runnable{
    public static final int TIEMPO =30;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pajaro pajaro;
    List<Pared>paredes;
    int cronometro=0;
    boolean fin=false;
    
    public void init(){
        this.setSize(300,300);
        
        pajaro = new Pajaro();
        paredes=new ArrayList <Pared>();
        paredes.add(new Pared());
        
        imagen=this.createImage(300,300);
        noseve=imagen.getGraphics();        //imagen recoge todo lo q hay en Graphics
    }
    
    public void start(){
       animacion=new Thread(this);
       animacion.start();
    }
    
    public void  paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 300, 300);
        
        pajaro.paint(noseve);
        for (int i = 0; i < paredes.size(); i++) 
            paredes.get(i).paint(noseve);
        
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
        while(true){
            pajaro.update();
            for(int i=0; i<paredes.size();i++)
                paredes.get(i).update();
            
            cronometro+=TIEMPO;
            if(cronometro>=5000){
                paredes.add(new Pared());
                cronometro=0;
            }
            
            if(paredes.get(0).getrAbajo().x == -50)
               paredes.remove(0);
            
            if(pajaro.intersects(paredes.get(0).getrAbajo()) || pajaro.intersects(paredes.get(0).getrArriba())){
                fin=true;
                repaint();
                animacion.stop();
            }
             
            if(pajaro.y >= 300){
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
    
    public boolean keyDown (Event ev , int tecla){
        if(tecla==32)//espacio
            pajaro.subir();
        return true;
    }
}
