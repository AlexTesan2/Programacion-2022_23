package Solitario;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle {//click=contains, 
    private Image imagen;
    private int valor;
    private int palo;
    private int color;
    public static final int ANCHURA=70;
    public static final int ALTURA=120;
    public static final int posInX=-500;
    public static final int posInY=-500;
    public static int PICAS=0;
    public static int ROMBOS=1;
    public static int CORAZONES=2;
    public static int TREBOLES=3;
    public static  int ROJO=1;
    public static int NEGRO=2;
    /*enum SUITCOLOR{RED,BLACK};
    enum SUITCLASS{SPADES,DIAMONTS,HEARTS,TREBOLS};
    private SUITCLASS suit;
    private SUITCOLOR coloor;
    */
    
    
    public Carta(Image imagen,int valor, int color, int palo){
        super(-200, posInY, ANCHURA,ALTURA);
        this.palo=palo;
        this.valor=valor;
        this.imagen=imagen;
        this.color=color;
        
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height,a);
    }
    
    public  void setPos(int px, int py){
        x=px;
        y=py;
        
        //paredes invisibles
        if(y<0)y=0;
        if(y>680)y=680;
        if(x<0)x=0;
        if(x>730)x=730;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public int getPalo() {
        return palo;
    }

    public void setPalo(int palo) {
        this.palo = palo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    //set posicion
    
}
