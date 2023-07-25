package E13Mondorian;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Mondorian1 extends Applet implements Runnable {
    public static final int DERECHA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int ARRIBA = 3;
    int direccion;
    int posX = 80;
    int posY = 100;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    
    public void init(){
        this.setSize(320, 350);
        direccion = DERECHA;
        imagen = this.createImage(320, 350);
        noseve = imagen.getGraphics();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); //llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 320, 350);
        noseve.setColor(Color.yellow);
        noseve.fillRect(0, 0, 90, 90);
        noseve.fillRect(260, 0, 40, 190);
        noseve.setColor(Color.blue);
        noseve.fillRect(80, 200, 220, 90);
        noseve.fillRect(100, 10, 90, 80);
        noseve.setColor(Color.lightGray);
        noseve.fillRect(posX, posY, 110, 90);
        noseve.setColor(Color.red);
        noseve.fillRect(0, 100, 70, 190);
        noseve.fillRect(200, 0, 45, 45);
        noseve.setColor(Color.magenta);
        noseve.fillRect(200, 55, 45, 135);
        g.drawImage(imagen, 0, 0, this);
    } 
    public void update(Graphics g){
        paint(g);
    }
    public void run(){
        while (true) {
            switch (direccion) {
                case ARRIBA:
                    posY--;
                    if (posY <= 100) {
                        direccion = IZQUIERDA;
                    }
                break;
                case ABAJO:
                    posY++;
                    if (posY >= 120) {
                        direccion = DERECHA;
                }
                break;
                case DERECHA:
                    posX++;
                    if (posX >= 100) {
                        direccion = ARRIBA;
                }
                break;
                case IZQUIERDA:
                    posX--;
                    if (posX <= 80) {
                        direccion = ABAJO;
                }
            }
            repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {}
        }
    }
}
