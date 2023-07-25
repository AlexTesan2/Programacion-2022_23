package Solitario;//este ejercicio tiene muchos conceptos avanzados, estudiar bien 

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Solitario extends Applet{
    Image imagen;
    Image imagenes[];
    Image imgReverso;
    Rectangle reverso;
    Graphics noseve;
    Baraja baraja;
    MazoSecundario mSecundario;
    Carta activa;
    mazoPalo mPalos[];
    mazoJuego mJuegos[];
    
    public static final int NUM_PALOS=4;
    public static final int NUM_CARTAS=52;
    public static final int CPP=13;
    String nombres[]= {"_of_clubs.png","_of_diamonds.png", "_of_heards.png","_of_spades.png"};
    
    public void init(){
        this.setSize(800,800);
        imagen = this.createImage(800,800);
        noseve = imagen.getGraphics();
        imagenes=new Image[NUM_CARTAS];
        
        for (int i = 0; i < NUM_CARTAS; i++) {
            imagenes[i]= getImage(getCodeBase(),"E06Ims/"+ ((i%CPP) + 1) +nombres[i/CPP]);
        }
        imgReverso=getImage(getCodeBase(),"E06Ims/reverso.png");
        reverso=new Rectangle (20,20, Carta.ANCHURA, Carta.ALTURA);
        baraja=new Baraja(imagenes);
        mSecundario = new MazoSecundario();
        mPalos=new mazoPalo[NUM_PALOS];
        for (int i = 0; i < NUM_PALOS; i++) {           
            mPalos[i]=new mazoPalo(400+(i*100));
        }
        
        mJuegos=new mazoJuego[7];
        for (int i = 0; i < 7; i++) {
           mJuegos[i]=new mazoJuego(100+(i*100));
        }
        
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.green);
        noseve.fillRect(0,0,800,800); 
        
        noseve.setColor(Color.black);
        for (int i = 0; i < NUM_PALOS; i++) 
            mPalos[i].mostrar(noseve, this);
        for (int i = 0; i < 7; i++) 
            mJuegos[i].mostrar(noseve, this);
        
        
        noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
        mSecundario.paint(noseve, this);
       
        
        
        g.drawImage(imagen, 0, 0, this); 
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public boolean mouseDown(Event ev,int x,int y){
        if (reverso.contains(x,y)) {
            mSecundario.añadir(baraja.sacar());
            mSecundario.recolocar();
            repaint();
        }
        if(mSecundario.extraer().contains(x,y)){
            activa=mSecundario.extraer();
        }
        return true;
    }
    
    public boolean mouseDrag(Event ev,int x,int y){
        if(activa!=null){
            activa.setPos(x-(Carta.ANCHURA/2), y-(Carta.ALTURA/2));
            repaint();
        }
        return true;
    }
    
   /* public boolean mouseUp(Event ev,int x,int y){
        if(activa!=null){
            mSecundario.recolocar();
            activa=null;
            repaint();
        }
        return true;
    }*/
    
    
    
    public boolean mouseUp(Event ev,int x,int y){   //if tmb sirve para saber si un elem existe o es null
        if(activa!=null){
            boolean encontrado=false;
            for (int i = 0; i < NUM_PALOS; i++) {
                if(mPalos[i].intersects(activa)){//si la carta intersecta en dos cuadrados entraria en los dos, por eso usamos un bucle con break
                    if(mPalos[i].annadir(mSecundario.extraer())){//se pone a cirerto si se encuentra un lugar donde soltar la carta
                        mSecundario.eliminar();
                        encontrado=true;
                        break;
                    }
                }
            }
            if(!encontrado) mSecundario.recolocar();
            activa=null;
            repaint();
        }
        return true;
    }
    
    
    
    public boolean action(Event ev, Object obj){
    
        return false;
    }
}
