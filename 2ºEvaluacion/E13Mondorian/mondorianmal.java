package E13Mondorian;
public class mondorianmal{
    public static void main(String[] args) {
        System.out.println("ya se hara...");
    }
}
/*
import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class mondorianmal extends Applet implements Runnable {
    public static final int NUM_RECT = 9;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Rectangulo rectangulos[];
    
    
    int [] posicionesX={0,0,250,80,80,100,80,200,0,200};
    int [] posicionesY={0,0,160,220,90,110,0,55};
    int [] altura={};
    int [] anchura={};
    Color [] colores = {};
    
    public void init(){
        this.setSize(320, 350);
        imagen = this.createImage(320, 350);
        noseve = imagen.getGraphics();
        rectangulos=new Rectangulo[NUM_RECT];
        for (int i = 0; i < NUM_RECT; i++) {
            rectangulos[i]=new Rectangulo (posicionesX[i], posicionesY[i], altura[i],anchura[i],colores[i]);
        }
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); //llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 320, 350);
        for (int i = 0; i < NUM_RECT; i++) {
            rectangulos[i].dibujar(noseve);
        }
        g.drawImage(imagen, 0, 0, this);
    } 
    public void update(Graphics g){
        paint(g);
    }
    public void run(){
        while (true) {
            for (int i = 0; i < NUM_RECT; i++) {
                rectangulos[i].actualizar();
            }
            repaint();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {}
        }
    }
}
*/

/*package e13;
import static e13.mondrian.ABAJO;
import static e13.mondrian.ARRIBA;
import static e13.mondrian.DERECHA;
import static e13.mondrian.IZQUIERDA;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo { 
    public static final int DERECHA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int ARRIBA = 3;
    public int direccion;
    public int posX, posY, anchura, altura;
    public int topeDer, topeIzq, topeArriba, topeAbajo;
    Color color;
    
    public Rectangulo(int px, int py, int an, int al, Color c) {
    posX = px;
    posY = py;
    anchura = an;
    altura = al;
    color = c;
    direccion= DERECHA;
    topeDER = px+20;
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(posX, posY, anchura, altura);
    }
    
    public void actualizar(){
            switch (direccion) {
                case DERECHA:
                    posX++;
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
                case ARRIBA:
                    posY--;
                    if (posX <= 80) {
                        direccion = ABAJO;
                }
            }
}
*/