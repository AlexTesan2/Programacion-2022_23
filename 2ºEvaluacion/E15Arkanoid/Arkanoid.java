package E15Arkanoid;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Arkanoid extends Applet implements Runnable {
    public static final int IZQUIERDA=-1;
    public static final int DERECHA=1;
    public static final int NUM_FILAS=5;
    public static final int NUM_COLUMNAS=10;
    public static final  Color colores[]={Color.BLUE,Color.GREEN,Color.MAGENTA,Color.ORANGE,Color.cyan};
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pelota pelota;
    List<Ladrillo> ladrillos;
    Raqueta raqueta;
    
    public void init(){
        this.setSize(300, 300);
        pelota=new Pelota();
        ladrillos=new ArrayList<Ladrillo>();
        for (int i = 0; i < NUM_FILAS; i++) 
            for (int j = 0; j < NUM_COLUMNAS; j++) 
                ladrillos.add(new Ladrillo(j*(Ladrillo.ANCHURA+2)+1,i*(Ladrillo.ALTURA+2)+3, colores[i] ));
        
        raqueta=new Raqueta();
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
        
        for (int i = 0; i < ladrillos.size(); i++) 
            ladrillos.get(i).paint(noseve);
        pelota.paint(noseve);
        raqueta.pain(noseve);
        g.drawImage(imagen, 0, 0, this);
    } 
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) { 
            pelota.update(raqueta,ladrillos);
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
        
    }
    
    public boolean keyDown(Event ev, int tecla ){
        if (tecla == 1006)
            raqueta.update(IZQUIERDA);
        if (tecla == 1007)
            raqueta.update(DERECHA);
        return true;
    }
}
