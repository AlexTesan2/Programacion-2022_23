package E04LaberintoNumerico;   //Recursividad

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Tablero extends Applet{
    Image imagen;
    Graphics noseve;
    Image ims[];
    int numImagenes=25;
    int DIM=5;
    Lugar lugares[][];
    AudioClip error, acierto, exito;
    Point hueco;
    
    public void init(){
        this.setSize(400,400);
        
        imagen = this.createImage(400,400);
        noseve = imagen.getGraphics();
        
        ims=new Image[numImagenes];
        lugares=new Lugar[DIM][DIM];
        
        for (int i = 0; i < numImagenes-1; i++) {  //damos valores a las imagenes
            ims[i]=getImage(getCodeBase(),"E04Imgs/"+ (i+1) +".gif");
        }
        //imagenes[24]= null;
        
        for (int i = 0; i < DIM; i++) //creamos los lugares
            for (int j = 0; j < DIM; j++) 
                lugares[i][j]=new Lugar(ims[(i*DIM)+j], j* Lugar.DIMENSION, i*Lugar.DIMENSION, (i*DIM)+j+1);
        
        try{  //hay que someter el  url a tratamiento de excepcoiones
            
            error=getAudioClip(new URL (getCodeBase(),"E04Sounds/error.wav"));
            exito=getAudioClip(new URL (getCodeBase(),"E04Sounds/exito.wav"));
            acierto=getAudioClip(new URL (getCodeBase(),"E04Sounds/correct.wav"));
            
        }catch(MalformedURLException e){};
        
        hueco=new Point (DIM-1, DIM-1);
        
        this.setLayout(new BorderLayout() );
        this.add("South", new Button ("Empezar"));
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,400,400); 
        //noseve.drawImage(ims[1], 0, 0, this);
        
        for (int i = 0; i <DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                lugares[i][j].paint(noseve, this);
            }
        }
        g.drawImage(imagen, 0, 0, this); 
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public boolean mover(Point click){
        Point desplazamiento, hasta;
        desplazamiento=new Point(delta(click.x, hueco.x),delta(click.y, hueco.y));//obtengo una pos x, y que es la diferencia entre la posicion click y el hueco
        
        if((desplazamiento.x==0) && (desplazamiento.y==0))  //si las dos pos son 0 has pulsado sobre el hueco
            return false;
        if((desplazamiento.x!=0) && (desplazamiento.y!=0))  //si ninguna de las pos es 0, no estas ni el la colum ni el la fila correcta
            return false;
        hasta= new Point(click.x+desplazamiento.x, click.y+desplazamiento.y );
        
        if(!((hasta.x==hueco.x)&&(hasta.y==hueco.y)))//se realizara la recursividad hasta que nos encontremos ante la tecla anterior al hueco
            mover(hasta);
        lugares[hueco.x][hueco.y].setImg(lugares[click.x][click.y].getImg());
        lugares[click.x][click.y].setImg(null);
        lugares[hueco.x][hueco.y].setValor(lugares[click.x][click.y].getValor());
        lugares[click.x][click.y].setValor(25);
        hueco=click;
        repaint();
        
        return true;
    }
    
    public int delta(int a, int b){
        if(a==b) return 0;//si la posición del hueco en un eje coincide con la posición del click en el mismo eje, devuelve 0
        else return ((b-a)/Math.abs(b-a));// abs devuelve el valor absoluto del numero partido de si mismo (sin signo), 1,-1
    }
    
        
    public boolean  mouseDown(Event ev, int x,  int y){//este metodo pone los sonidos
        
        Point click;    //click tiene dos posiciones x e y 
        click=new Point(y/Lugar.DIMENSION, x/Lugar.DIMENSION);
        if(!mover(click))//si mover da false, suena error y sino, acierto
            error.play();
        else{
            acierto.play();
            boolean ordenado=true;
            for (int i = 0; i < DIM; i++) {//comprueba si todos los cuadrados estan en su lugar,
                for (int j = 0; j < DIM; j++) {
                    if(lugares[i][j].getValor()!=((i*DIM)+j+1)) 
                        ordenado=false;
                }
            }
            if (ordenado) exito.play();
        }
        return true;
    }
    
    
    public boolean action(Event ev, Object obj){
        
        if(ev.target instanceof Button )//si toco el boton, el teclado se desordenará aleatoriamente
            for (int i = 0; i < 500; i++) 
                mover(new Point((int)(Math.random()*DIM),((int)(Math.random()*DIM))));
        return false;
    }
}
