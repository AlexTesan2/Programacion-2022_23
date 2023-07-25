package E18Rana2;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class juego extends Applet implements Runnable{
    
    public static final int TIEMPO =30;
    public static final int IZQUIERDA=-1;
    public static final int DERECHA=1;
    public static final int ALTURA=100;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    public static boolean fin=false;    //podemos aceder a este atributo a traves del nombre de la clase
    public static int contador=0;
    
    //CAR car;
    List <CAR> cars;
    frog frog;
    
    
    public void init(){
        this.setSize(300, 300);
        
        cars=new ArrayList<CAR>();
        frog=new frog();
                
        imagen = this.createImage(300,300);
        noseve = imagen.getGraphics();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 0, 300, 300);
        noseve.setColor(Color.black);
        noseve.fillRect(0, 50, 300, ALTURA * 2);
        noseve.setColor(Color.white);
        noseve.fillRect(0, 147, 300, 2);
        
        frog.paint(noseve);
        
        //car.paint(noseve);
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).paint(noseve);
        }
        
        noseve.setColor(Color.black);
        noseve.setFont(new Font("TimesRoman", Font.BOLD,20));
        noseve.drawString("SCORE: "+ String.valueOf(contador), 20, 280);
       
        
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
           
            frog.paredesBasicas();
            cronometro += TIEMPO;
            if(cronometro >= 1000){
                
                if (Math.random() >= 0.5) {
                    cars.add(new CAR(300,(int)(Math.random()*(ALTURA - CAR.ALTO ))+50));
                }else{
                    cars.add(new CAR(-30,(int)(Math.random()*(ALTURA - CAR.ALTO ))+150));
                }
                cronometro=0;
            }
            
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).update(frog);
                if (fin) {
                    repaint();
                    animacion.stop();
                }
                if (!cars.get(i).isInRoad()) 
                    cars.remove(i);
            }
            
            /*for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).intersects(frog)) {
                    fin=true;
                    repaint();
                    animacion.stop();
                }
            }*/
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
    }
    
    public boolean keyDown (Event ev , int tecla){
        
        frog.update(tecla);

        return true;
    }

}