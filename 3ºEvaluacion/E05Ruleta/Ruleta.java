package E05Ruleta;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.util.List;
import java.awt.Point;
import java.util.ArrayList;


public class Ruleta extends Applet{
    Image imagen;
    Graphics noseve;
    public static final int FILAS=12;
    public static final int COLUMNAS=3;
    public static final int FICHAS=10;
    int valor=0;
    public Casilla tablero[][];
    public Ficha fichas[][];
    Image imagenes[];
    
    public int valores[]={1,5,10,25,50,100,500,1000,5000,10000};
    public int rojos[]={1,3,9,12,5,7,14,16,18,19,21,23,25,27,30,32,36,34};
    List <Integer> lRojos;
    int numero;//num aleat q sale al pulsar el boton
    int ultimos10[];
    int capital=1000000;//dinero inicial
    int acumulador;//se acumulan las ganancias y las perdidas de las jugadas
    
    public void init(){
        this.setSize(700,800);
        
        imagen = this.createImage(700,800);
        noseve = imagen.getGraphics();
        
        /*Panel panel=new Panel(); 
        Button boton = new Button("Jugar ");*/
        
        //metemos los valores rojos en la lista integer
        lRojos=new ArrayList<Integer>();
        for (int i = 0; i < rojos.length; i++) {
            lRojos.add(new Integer(rojos [i]));
        }
        
        //instanciar imagenes
        imagenes=new Image[10];
        for (int i = 0; i < imagenes.length; i++) {
            imagenes[i]=getImage(getCodeBase(),"E05img/ficha"+ (i+1) +".png");
        }
        //instanciamos las casillas
        tablero=new Casilla [FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if(lRojos.contains(new Integer((i*COLUMNAS)+j+1)))
                    tablero[i][j]=new Casilla(j*Casilla.DIM,i*Casilla.DIM, (i*COLUMNAS)+j+1, Color.red);
                else
                    tablero[i][j]=new Casilla(j*Casilla.DIM,i*Casilla.DIM, (i*COLUMNAS)+j+1, Color.black);
            }
        }
        //instanciamos fichas
        fichas = new Ficha[FICHAS][FICHAS];
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                fichas[i][j]=new Ficha((i*60)+100,imagenes[i],valores[i]);
            }
        }
        ultimos10=new int [10];
        
        
                
        this.setLayout(new BorderLayout() );
        this.add("South", new Button ("Empezar"));
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.green);
        noseve.fillRect(0,0,700,800); 
        
        MostrarCasillas();
        MostrarMonedas();
        mostrarNumero();
        MostrarVetor();
        noseve.setColor(Color.black);
        noseve.drawString("Total = "+capital, 260, 600);
    
        noseve.drawString(""+numero, 350, 80);
        g.drawImage(imagen, 0, 0, this); 
    }

    private void MostrarCasillas() {
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++)
                tablero[i][j].paint(noseve);
    }

    private void MostrarMonedas() {
        //noseve.drawImage(imagenes[3], 12, 12, this);
        
        for (int i = 0; i < fichas.length; i++) {//dibujo las monedas
            for (int j = 0; j < fichas[i].length; j++) {
                fichas[i][j].paint(noseve, this);
            }
        }
    }

    private void MostrarVetor() {
        for (int i = 0; i < 10; i++) {
            if(lRojos.contains(new Integer(ultimos10[i])))
                noseve.setColor(Color.red);
            else
                noseve.setColor(Color.black);
            noseve.drawString(""+ultimos10[i], 600, i*50+100);
            
            /*(lRojos.contains(new Integer(ultimos10[i])))? noseve.setColor(Color.red) : noseve.setColor(Color.black);
            //   noseve.setColor(Color.red)? noseve.drawString(""+ultimos10[i], 600, i*50+100):noseve.drawString(""+ultimos10[i], 600, i*50+100);
            noseve.drawString(""+ultimos10[i], 600, i*50+100);*/
            
        }
    }

    private void mostrarNumero() {  //si es rojo o negro, falta o pasa, par o impar
        if(lRojos.contains(new Integer(numero))){
            noseve.setColor(Color.red);
            noseve.drawString("ROJO", 350, 100);
        }
        else {
            noseve.setColor(Color.black);
            noseve.drawString("ROJO", 350, 100);
        }
        if(numero<=18)
            noseve.drawString("falta", 310, 150);
        else
            noseve.drawString("pasa", 310, 150);
        
        if((numero%2)==0)
            noseve.drawString("par", 310, 180);
        else
            noseve.drawString("impar", 310, 180);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public boolean mover(Point click){
        return true;
    }
    
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof Button){
            numero=(int)(Math.random()*37);
            desplazarVector();
            for (int i = 0; i < FICHAS; i++) {
                for (int j = 0; j < FICHAS; j++) {
                    for(Integer elemento: fichas[i][j].getApuestas())
                        if(numero==elemento.intValue())
                            acumulador += fichas[i][j].getValor()*(FICHAS*COLUMNAS);
                    if(fichas[i][j].getApuestas() != null)
                    //if(fichas[i][j]).getApuestas().size != null)
                        acumulador-=fichas[i][j].getValor();
                }
            }
            repaint();
            return true;
        }
        return false;
    }

    private void desplazarVector() {
        for (int i = 0; i < 10; i++)
            ultimos10[i-1]=ultimos10[i];
        ultimos10[9]=numero;
        repaint();
    }
    
    
    public Ficha apuntador;
    public boolean mouseDown (Event ev, int x, int y){
        for (int i = 0; i < FICHAS; i++) 
            for (int j = 0; j < FICHAS; j++) 
                if (fichas[i][j].contains(x,y)) 
                    apuntador=fichas[i][j];
        return true;   
    }
    
    public boolean mouseDrag (Event ev, int x, int y){
        if(apuntador!=null){
            apuntador.move(x-(Ficha.DIM/2), y-(Ficha.DIM/2));
            repaint();
        }
        return true;
    }
    
    public boolean mouseUp (Event ev, int x, int y){   
        
        apuntador.setApuestas(tablero);
        
        apuntador=null;
        repaint();
        return true;
    }
}//oliver villey
