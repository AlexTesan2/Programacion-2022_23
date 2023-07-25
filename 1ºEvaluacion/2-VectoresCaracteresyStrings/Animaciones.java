package e12;
import java.awt.Frame;
import java.awt.Graphics;
public class Animaciones extends Frame implements Runnable{//imementar es escribir programas
    Thread animacion;
    String frames[]={"*","**","***","****","*****","******","*******","******","*****","****","***","**"};
    int actual=0;
    public static void main(String[] args) {
        Animaciones app = new Animaciones();
    }
    
    public Animaciones(){
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
}
