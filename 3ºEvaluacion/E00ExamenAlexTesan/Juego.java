/*Tenéis que hacer el juego que mostramos en pantalla.  Se puede cambiar de coche haciendo 
click en alguno de los coches de arriba.  Se acelerará o se frenará pulsando los pedales, 
el de la derecha acelera, el de la izquierda frena.  El coche no se mueve, es la imagen de
fondo la que se desplaza hacia la izquierda.  Se desplazará más rápido dependiendo de la 
velocidad, que también aparece en pantalla, la velocidad se modifica pulsando los pedales.
Se puntuará:
Análisis de las clases, sus atributos y métodos
5 puntos.
Clase principal, el Applet, atributos, instanciación, eventos, métodos… 
5 puntos*/

package E00ExamenAlexTesan;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable{
    Thread animacion;
    Image imagen;
    Graphics noseve;
    public static int SIZEX=1800;
    public static int SIZEY=900;
    public static int NUM_COCHES=4;
    Coches coches[];
    Coches granCoche;
    Image imCoches[];
    int velocidad=0;
    Controles acelerador;
    Image imgAcelerador;
    Image imgFreno;
    Controles freno;
    List<Fondo>fondo;
    Image imagenFondo;
    
    public void init(){
        dimensionar();
        instanciar();
    }

    public void dimensionar() {
        this.setSize(SIZEX,SIZEY);
        imagen = this.createImage(SIZEX,SIZEY);
        noseve = imagen.getGraphics();
        //reverso = getImage(getCodeBase(), "E08Ims/re.jpg");
    }
    
    public void instanciar() {
        coches=new Coches[NUM_COCHES];
        imCoches=new Image[NUM_COCHES];
        fondo=new ArrayList <Fondo>();
        
        imgAcelerador=getImage(getCodeBase(), "E00ExamenIms/acelerador.png");
        imgFreno=getImage(getCodeBase(),    "E00ExamenIms/freno.png");
        imagenFondo=getImage(getCodeBase(), "E00ExamenIms/tira.jpg");
        
        for (int i = 0; i < imCoches.length; i++)
            imCoches[i]=getImage(getCodeBase(), "E00ExamenIms/coche"+(i+1)+".png");
        for (int i = 0; i < coches.length; i++) 
            coches[i]=new Coches(i*Coches.DIMX*2+140,imCoches[i]);
        
        granCoche=new Coches(20,SIZEY-(SIZEY/2),imCoches[0]);
        acelerador=new Controles(1300,650+Controles.DIMX,Controles.DIMX,imgAcelerador,-2);
        freno=new Controles(1380,650,Controles.DIMX*2 ,imgFreno,+2);
        
        fondo.add(new Fondo(imagenFondo,true,0));
        
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.white);
        noseve.fillRect(0,0,SIZEX,SIZEY); 
        
        for (int i = 0; i < fondo.size(); i++) {
            fondo.get(i).paint(noseve, this);
        }
        
        
        for (int i = 0; i < coches.length; i++) 
           coches[i].paint(noseve, this);
        granCoche.paint(noseve, this);
        acelerador.paint(noseve, this);
        freno.paint(noseve, this);
        
        noseve.setFont(new Font("TimesRoman", Font.BOLD,50));
        noseve.drawString(""+velocidad, 50, 50);
        g.drawImage(imagen, 0, 0, this); 
    }
    
    public void update(Graphics g){
        paint(g);
    }  
    
    public void run(){
        while(true){
            if (velocidad>0){ 
                for (int i = 0; i < fondo.size(); i++) 
                    fondo.get(i).update(velocidad);
                
                if((fondo.get(0).getPosX()<0) && fondo.size()<2)
                    fondo.add(new Fondo(imagenFondo,false,fondo.get(0).getPosX()));
                
                for (int i = 0; i < fondo.size(); i++)
                    if(fondo.get(i).getPosX()<-SIZEX)
                        fondo.remove(fondo.get(i));
                
            }
            if (velocidad<0) velocidad=0;
            repaint();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){}
        }
    }
    
    public boolean mouseDown(Event ev, int x, int y) {
        
        for (int i = 0; i < coches.length; i++)
            if (coches[i].contains(x, y)) {
                granCoche.setImCoche(coches[i].getImCoche());
                repaint();
            }
        if(acelerador.contains(x, y)) 
            velocidad+=acelerador.getValor();
        else if (freno.contains(x, y))
            velocidad+=freno.getValor();
        repaint();
        return true;
    }

}