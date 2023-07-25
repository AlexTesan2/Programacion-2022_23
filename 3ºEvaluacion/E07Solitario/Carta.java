package E07Solitario;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle{ //para poder usar intersecs y contains
    
    public static final int POS_INIC = -200;
    public static final int WIDTH = 100; //las cartas nunca cambian de tamaño pero si de posicion
    public static final int HEIGHT = 150;
    public static final int ROJO = 1;
    public static final int NEGRO = 2;
    public static final int ESPADAS = 0;
    public static final int DIAMANTES = 1;
    public static final int CORAZONES = 2;
    public static final int TREBOLES = 3;
    
    public Image imagen;
    private int valor;
    private int color;
    private int palo;

    public Carta(Image imagen, int valor, int palo, int color){
        super(POS_INIC, POS_INIC, WIDTH, HEIGHT);
        this.imagen = imagen;
        this.valor = valor;
        this.palo = palo;
        this.color = color;
    }

    public void paint(Graphics g, Applet applet){
        g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
    }

    public void setPosicion(int X, int Y){//sirve para cuando movamos la carta al hacer click y arrastrarla
        x = X;
        y = Y;
    }
    
    // getters y setters
    
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getPosX() {
        return x;
    }
    public void setPosX(int posX) {
        this.x = posX;
    }
    public int getPosY() {
        return y;
    }
    public void setPosY(int posY) {
        this.y = posY;
    }
    //si no se necesita modificar una variable privada, basta con utilizar el get (el set se puede evitar)
    public int getPalo() {
        return palo;
    }
    public int getColor() { //Solo hacemos get porque nunca lo vamos a modificar
        return color;
    }
}
    
 
