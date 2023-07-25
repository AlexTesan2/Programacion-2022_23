/*Realizar el juego que “una” los rectángulos inmóviles, situados en la parte inferior de la pantalla,
con los rectángulos móviles que circulan por su parte superior.  Siguiendo los siguientes pasos:

-Crear una clase para los rectángulos inmóviles de la parte inferior.  1 punto
-Crear una clase para los rectángulos móviles de la parte superior.  1 punto
/Crear una clase para las líneas que unirán los rectángulos inmóviles con los móviles.  1 punto
De cada una de estas clases, deberás crear una lista en el programa principal y resolver correctamente
cuando cargas sus elementos, cómo se actualizan, cómo interactúan… 2 puntos
/Las líneas adquirirán el color del rectángulo inmóvil sobre el que se haga click. 0,5 puntos
-Las líneas se irán pintando mientras el botón izquierdo del ratón permanezca pulsado, siempre y cuando 
se haya hecho click sobre un rectángulo inmóvil previamente.  2 puntos
Al soltar el ratón sobre un rectángulo móvil del mismo color, la línea permanecerá 
unida a este y continuará redibujándose según la trayectoria que este siga.  Si no se suelta
el ratón sobre un rectángulo móvil del mismo color, la línea desaparece.  2,5 puntos
*/
package E00Examen2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable{
    public static final int NUMCUADRADOS=5;
    public static final Color COLORES[]={Color.RED,Color.ORANGE, Color.GREEN, Color.YELLOW, Color.pink};
    public static final int propor1=50;
    public static final int TIEMPO =30;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int cronometro=0;
    boolean fin=false;
    int posx;
    int posy;
    Color col;
    
    List<RectangulosAbajo>rAbajo;
    List<RectangulosArriba>rArriba;
    DosPuntos actual;
    List <DosPuntos> lineas;
    
    
    public void init(){     
        this.setSize(350, 400);
        
        rAbajo=new ArrayList <RectangulosAbajo>();
        rArriba=new ArrayList <RectangulosArriba>();
        lineas=new ArrayList <DosPuntos>();
        
        for (int i = 0; i < NUMCUADRADOS; i++) {
            rAbajo.add(new RectangulosAbajo(i));
            rArriba.add(new RectangulosArriba(i));
        }
        
        
        imagen = this.createImage(350,400);
        noseve = imagen.getGraphics();
        
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); //llama metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 350, 400);
        
        
        for (int i = 0; i < rAbajo.size(); i++) {
            rAbajo.get(i).paint(noseve);
        }
        
        for (int i = 0; i < rArriba.size(); i++) {
            rArriba.get(i).paint(noseve);
        }
        
        for (int i = 0; i < lineas.size(); i++) {
            lineas.get(i).paint(noseve);
        }
        
        
        if(actual != null)
            actual.paint(noseve);
        

        
        
        g.drawImage(imagen, 0, 0, this);
    } 
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while (true) { 

            for (int i = 0; i < rArriba.size(); i++) {
                rArriba.get(i).update();
            }

            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        }
        
    }
    //las lineas hacen un poco lo que les da la gana
    public boolean mouseDown (Event ev, int x, int y){
        
        for (int i = 0; i < rAbajo.size(); i++) {
            if (rAbajo.get(i).contains(x, y)) {
                actual= new DosPuntos(rAbajo.get(i).x,rAbajo.get(i).y,rAbajo.get(i).color);
                //repaint();
                posx=rAbajo.get(i).x;
                posy=rAbajo.get(i).y;
                col=rAbajo.get(i).color;   
            }
        }
        
        return true;   
    }
    
    public boolean mouseDrag (Event ev, int x, int y){
        actual.setPosFinX(x);
        actual.setPosFinY(y);
        repaint();
        return true;
    }
    
    public boolean mouseUp (Event ev, int x, int y){   
        for (int i = 0; i < rArriba.size(); i++) {
            if (rArriba.get(i).contains(x, y)) {
                if(rArriba.get(i).color==col){
                    actual.setPosFinX(rArriba.get(i).x);
                    actual.setPosFinY(rArriba.get(i).y);
                    actual= new DosPuntos(posx,posy, rArriba.get(i).x,rArriba.get(i).y,rArriba.get(i).color);
                    lineas.add(actual);
                    //actual= null;
                }
                else actual=null;
            }//else actual=null;
        }
        return true;
    }
}
