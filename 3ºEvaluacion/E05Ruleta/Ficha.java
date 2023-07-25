package E05Ruleta;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Ficha extends Rectangle{
    Image img;
    private int valor;
    public static final int POSX=450;
    public static final int DIM=50;
    ArrayList <Casilla> apuestas;
    
    public Ficha(int y,Image im, int val){
        super(POSX, y,DIM,DIM);
        this.img=im;
        valor=val;
        apuestas=new ArrayList<Casilla>();
    }
    
    public void paint(Graphics g , Applet a){
        g.drawImage(img, x, y, width, height, a);
        for(Casilla casilla : apuestas) System.out.println(""+casilla.valor);
    }
    
    public void setApuestas(Casilla[][] cas){
        apuestas.clear();
        for (int i = 0; i < Ruleta.FILAS; i++) {
            for (int j = 0; j <Ruleta.COLUMNAS; j++) {
                if(this.intersects(cas[i][j]))
                    apuestas.add(cas[i][j]);
            }
        }
    }
    
    public void move(int posX, int posY){
        x=posX;
        y=posY;
    }

    Iterable<Integer> getApuestas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
