package Pruebas1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Parejas extends Applet implements Runnable{
    Image imagen;
    Graphics noseve;
    private Thread animacion;
    int contador=0;
    public static int  NUM_CARTAS=16;
    public static int SIZE=600;
    public static int FILAS=4;
    public static int COLUMNAS=4;
    Cartas [][] cartas;
    Image [] imagenes;
    Image rev;
    Cartas c1,c2;
    
    
    public void init(){
        this.setSize(SIZE,SIZE);
        imagen = this.createImage(SIZE,SIZE);
        noseve = imagen.getGraphics();
        
        cartas = new Cartas[FILAS][COLUMNAS];
        imagenes=new Image[NUM_CARTAS/2];
        
        for (int i = 0; i < imagenes.length; i++) {
            imagenes[i]= imagenes[i] = getImage(getCodeBase(), "E08Ims/d"+(i+1)+".jpg");
        }
        rev= getImage(getCodeBase(), "E08Ims/re.jpg");
        
        //cartas[1]=new Cartas(100,100,imagenes[1],rev);
        
        for (int i = 0; i < FILAS; i++) 
            for (int j = 0; j < COLUMNAS; j++) 
                cartas[i][j] = new Cartas((i*Cartas.SIZE)+100,(j*Cartas.SIZE)+100, imagenes[(i*FILAS + j)/2], rev);
        
        desordenar();
    }
    
    public void desordenar(){
        Image aux;
        Cartas carta1;
        Cartas carta2;
        for (int i = 0; i < 600; i++) {
            carta1=cartas[(int)(Math.random()*cartas.length)][(int)(Math.random()*cartas.length)];
            carta2=cartas[(int)(Math.random()*cartas.length)][(int)(Math.random()*cartas.length)];
            
            aux=carta1.getI();
            carta1.setI(carta2.getI());
            carta2.setI(aux);
        }
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.green);
        noseve.fillRect(0,0,SIZE,SIZE); 
        
        //cartas[1].paint(noseve, this);
        for (int i = 0; i < FILAS; i++) 
            for (int j = 0; j < COLUMNAS; j++) 
                cartas[i][j].paint(noseve, this);
                        
        g.drawImage(imagen, 0, 0, this); 
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void update(Graphics g){
        paint(g);
    }  

    public void run(){
        while(true){
            contador++;
            if(contador == 1000/200){
                repaint();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas[i].length; j++) {
                if ((cartas[i][j].isMostrar()==false)&&(cartas[i][j].contains(x,y)) && (c1==null)) {
                    cartas[i][j].setMostrar(true);
                    c1=cartas[i][j];
                    repaint();
                }else if((cartas[i][j].isMostrar()==false)&&(cartas[i][j].contains(x,y)) && (c2==null)) {
                    cartas[i][j].setMostrar(true);
                    c2=cartas[i][j];
                    repaint();
                }
            }
        }
        return false;
    }
    
    public boolean mouseUp(Event ev, int x, int y){
        if((c1 == null) || (c2 == null)){
            return false;
        }
        if ((c1 != null) && (c2 != null)) {
            if (c1.getI()!=c2.getI()) {
                c1.setMostrar(false);
                c2.setMostrar(false);
                contador=0;
            }
        }
        c1=c2=null;
        //repaint();
        return true;
    }
}
