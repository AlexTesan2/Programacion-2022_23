package E17Naves;

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
    Gun gun;
    List <Bala> balas;
    List <Nave> naves;
    int aleatorio;
    
    public void init(){     
        this.setSize(300, 300);
        
        gun= new Gun();
        balas=new ArrayList<Bala>();
        naves=new ArrayList<Nave>();
        
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
        
        
        gun.paint(noseve);
        
        for (int i = 0; i < balas.size(); i++) 
            balas.get(i).paint(noseve);
        
        for(int i=0; i< naves.size(); i++)
            naves.get(i).paint(noseve);
        
        
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
            if(cronometro >= 500){
                naves.add(new Nave());
                
                for(int i = 0; i < naves.size(); i++){
                    aleatorio=(int)(Math.random()*1000);
                    if(aleatorio>980){
                        naves.get(i).Kamikace();
                        break;
                }
            }
                
                cronometro=0;
            }
            
            for (int i = 0; i < balas.size(); i++) {
                balas.get(i).update();
                repaint();  
            }
            
            if( (balas.size()>0) && (balas.get(0).y <-10))  balas.remove(0); //si la 1º condicion es falso, ya no ele la 2º
                        
            
            
            for (int i = 0; i < naves.size(); i++) {
                naves.get(i).update();
                repaint();  
            }
            
            /*for (int i = 0; i < naves.size(); i++) {
                if((naves.get(i).x>280) || (naves.get(i).x<0))
                    naves.get(i).rebote();
            }*/
            
            for (int i = 0; i < naves.size(); i++) {
                for (int j = 0; j < balas.size(); j++) {
                    if(balas.get(j).intersects(naves.get(i))){
                        balas.remove(j);
                        naves.remove(i);
                        break;
                    }
                }
            }
            
            
            //perder
            for (int i = 0; i < naves.size(); i++) {
                if((naves.get(i).y>300) || (naves.get(i).intersects(gun))){
                    fin=true;
                    repaint();
                    animacion.stop();
                }
            }
            
            
            /*if(){
                fin=true;
                repaint();
                animacion.stop();
            }*/
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
        
    }
    
    public boolean mouseMove(Event ev, int x, int y ){
        gun.update(x);
        return true;
    }
    
    public boolean mouseDown(Event ev, int x , int y ){    
        balas.add(new Bala(gun.x));
        return true;
    }
}

/*public boolean keyDown(Event ev, int tecla ){
        if(tecla== 1006)
            gun.update(IZQUIERDA);
        if(tecla==1007)
            gun.update(DERECHA);
        return true;
    }*/