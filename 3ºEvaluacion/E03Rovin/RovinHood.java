package E03Rovin;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class RovinHood extends Applet implements Runnable {
   
    public static final  int NUMGLOBOS=3;
    public static final int TIEMPO =50;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    
    Image robin, flechaImg;  //dos imagenes con diferente nombre
    Image globosImgs[]=new Image[3];  //vector de tres imagenes
    Arquero arquero;
    List<Globo>globos;
    List<Flecha>flechas;
    
    public void init(){     
        this.setSize(500, 500);
        imagen = this.createImage(500,500);
        noseve = imagen.getGraphics();
        
        robin= getImage(getCodeBase(),"E03Imgs/arquero3.png");
        arquero=new Arquero(robin);//instanciar, llamar al metodo constructor y pasarle la imagen
        
        flechaImg= getImage(getCodeBase(),"E03Imgs/dis.png");
        flechas=new ArrayList <Flecha>();
        
        
        globosImgs[0]=getImage(getCodeBase(),"E03Imgs/g6.png");
        for (int i = 1; i < NUMGLOBOS; i++) 
            globosImgs[i]=getImage(getCodeBase(),"E03Imgs/g"+ (i+1) +".png");
        
        globos=new ArrayList <Globo>();
        //globos.add(new Globo(globosImgs[(int)(Math.random()*3)]));  
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); //llama metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 500, 500);
        
        arquero.paint(noseve, this);
        //noseve.drawImage(robin, 100, 100, this);
        
        for(Globo g1: globos)
            g1.paint(noseve, this);
        
        for(Flecha f1: flechas)
            f1.paint(noseve, this);
        
        g.drawImage(imagen, 0, 0, this);
    } 
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) { 
            cronometro += TIEMPO;
            if(cronometro >= 500){
                globos.add( new Globo(globosImgs[(int)(Math.random()*globosImgs.length)]));
                cronometro=0;        
            }
            
            for(Globo g1: globos) //actualizamos la posicion de los globos
                g1.update();
            //if (globos.get(0).y <-100) globos.remove(0); //eliminamos los globos que se salen de la pantalla
            
            
            for(Flecha f1: flechas)//actualizamos la posicion de las flechas
                f1.update(globos);
            
            if ( (flechas.size()>0) &&(flechas.get(0).x>600)) flechas.remove(0);
             //if ( (!flechas.isEmpty()) &&(flechas.get(0).x>300)) flechas.remove(0);
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
        
    }
    
    public boolean  mouseMove(Event ev, int x,  int y){
        arquero.update(y-45);
        repaint();
        return true;
    }
    
    public boolean  mouseDown(Event ev, int x,  int y){
        flechas.add(new Flecha(flechaImg,y-27));
        repaint();
        return true;
    }
    
}