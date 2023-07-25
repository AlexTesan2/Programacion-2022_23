package E19Tenis;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
public class Tenis extends Applet implements Runnable{
    
    public static final int TIEMPO =30;
    public static final int IZQUIERDA=-1;
    public static final int DERECHA=1;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    boolean fin=false;
    Raqueta raqueta;
    Pelota pelota;
    public static int nadal=0;
    public static int alcatraz=0;
    
    
    
    public void init(){
        this.setSize(300, 300);
        raqueta = new Raqueta();
        pelota= new Pelota();
                
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
        raqueta.paint(noseve);
        pelota.paint(noseve);
        
        
        noseve.setColor(Color.white);
        noseve.drawString("Nadal ("+nadal+") - ("+alcatraz+") Acatraz", 100, 10);
        
        if(fin){
            noseve.setColor(Color.MAGENTA);
            noseve.setFont(new Font("TimesRoman", Font.BOLD,20));
            noseve.drawString("GAME", 110, 20);
            noseve.drawString("OVER", 110, 40);
        }
        
        g.drawImage(imagen, 0, 0, this);
        
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) {
            
            pelota.update();
            raqueta.margenes();
            
            /*cronometro += TIEMPO;
            if(cronometro >= 1200){
                pelota.velY--;
                cronometro=0;
            }*/
            
            if((pelota.intersects(raqueta.getRaqder())) || (pelota.intersects(raqueta.getRaqizda()))){
                pelota.velX=-pelota.velX;
                pelota.velY=(pelota.velY+((int)(Math.random()*3)-1));
            }
            
            //modo infinito
            
            //raqueta.getRaqder().y=pelota.y-50;
            
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
    }
    
    public boolean keyDown (Event ev , int tecla){
        raqueta.update(tecla);
        return true;
    }

}