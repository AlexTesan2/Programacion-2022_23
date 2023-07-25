package E12Animacion;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;

public class Animacion extends Frame implements Runnable{  //implementar es escribir programas
    Thread animacion;
    String frames[]={"*","**","***","****","*****","******","*******","******","*****","****","***","**"};
    int actual=0;
    public static void main(String[] args) {
        Animacion app = new Animacion();
    }
    
    public Animacion(){
        super ("Animacion sencilla");
        pack();
        this.setSize(200, 200);
        this.setVisible(true);
        
        animacion=new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        g.drawString(frames[actual], 75, 75);
    }
    
    public void run(){
        while(true){
            actual=(actual+1)%frames.length;
            repaint();
            try{
                Thread.sleep(300);
            }catch(InterruptedException e){}
        }
    }
    
    public boolean handleEvent(Event ev){
        if(ev.id==Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }
}
