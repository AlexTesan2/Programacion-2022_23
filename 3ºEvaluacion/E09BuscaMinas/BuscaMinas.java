package E09BuscaMinas;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class BuscaMinas extends Applet{
    
    public final static int TOTALMINAS = 10;
    public static final int FILAS = 10;
    public static final int COLUMNAS = 10;
    public final static int SIZEX = 400;
    public final static int SIZEY = 400;
    private Image imagen; 
    private Graphics noseve;
    private Image reverso;
    private Image minaI;
    private Casilla[][] casillas;
    private boolean finMalo=false;
    private boolean finBueno=false;

    public void init(){
        dimensionar(); 
        instanciarImgs();
        casillas = new Casilla[FILAS][COLUMNAS];
        crearCasillas();
        //minarJuego();
        aleatorios();
        buscarMinas();
        
    }

    private void dimensionar() {
        this.setSize(SIZEX, SIZEY);
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics();
    }
    
    private void instanciarImgs() {
        reverso = getImage(getCodeBase(), "E09Ims/casilla.png");
        minaI=getImage(getCodeBase(), "E09Ims/mina.png");
    }
    
    private void crearCasillas() {
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)
                casillas[i][j] = new Casilla(100+(i*18),100+(j*18), reverso);//100+(j*Casilla.DIM)
    }
    
    private void minarJuego(){// mi version
        for (int i = 0; i < TOTALMINAS; i++) {
            int aleat1= (int)(Math.random()*10);
            int aleat2= (int)(Math.random()*10);
            if(casillas[aleat1][aleat2].getMina()==null)
                casillas[aleat1][aleat2].setMina(minaI);
            else
                i=i-1;
        }
    }
    
    
    private void aleatorios(){
        int aleatorios[]=obtenerAleatorios();
        for (int i = 0; i < TOTALMINAS; i++) {
            casillas[aleatorios[i]/FILAS][aleatorios[i]%FILAS].setMina(minaI);
        }
    }
    
    
    
    public int[] obtenerAleatorios(){//version profe
        int resultados[]=new int [TOTALMINAS];
        int vector[]=new int [FILAS*FILAS];
        for (int i = 0; i < FILAS*FILAS; i++) 
            vector[i]=i;
        for (int i = 0; i < TOTALMINAS; i++) {
            int aleatorio=(int)(Math.random()*((FILAS*FILAS)-i));//aleatorio es una posicion en vector, conforme aumenta la i del bucle, disminuye el tamaño del vector
            resultados[i]=vector[aleatorio];//en resultados se guarda el valor de vector en la posicion aleatoro
            vector[aleatorio]=vector[(FILAS*FILAS)-i-1];//en la posicion aleatorio se pone el valor que se encuentra en la ultima posicion, para al repetir el bucle la ultima pos no se lea y no haya asi peligro de repetir la misma posicion
        }
        return resultados;
    }
    
    private void buscarMinas(){
        for (int i = 0; i < FILAS; i++) {   //recorro tods las filas y las columnas en busca de minas 
            for (int j = 0; j < COLUMNAS; j++) {
                if(casillas[i][j].getMina()!=null){ //si enuntro alguna mina...
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            if((i-1+x>=0) && (i-1+x<10) && (j-1+y>=0) && (j-1+y<10))//si no supera los bordes
                                casillas[i-1+x][j-1+y].setAlrededor(casillas[i-1+x][j-1+y].getAlrededor()+1);//aumeno en uno el valor de alredor a cada casilla
                        }
                    }
                }
            }
        }
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.white);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.setColor(Color.white);
        
        for(int i = 0; i < FILAS; i++)  //dibujar casillas
            for(int j = 0; j < COLUMNAS; j++){
                casillas[i][j].dibujar(noseve, this);
            }

        if(finMalo) terminarJuegoDeLaPeorFormaPosible();
        if(finBueno) activarFinalBueno();
        
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void terminarJuegoDeLaPeorFormaPosible(){
        noseve.setColor(Color.red);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.setColor(Color.white);
        noseve.setFont(new Font("TimesRoman", Font.BOLD,50));
        noseve.drawString("GAME OVER", 40, 50);
        noseve.setFont(new Font("TimesRoman", Font.BOLD,80));
        noseve.setColor(Color.black);
        noseve.drawString("BOOM!", 70, 230);
    }
    
    public void activarFinalBueno(){
        noseve.setColor(Color.GREEN);
        noseve.fillRect(100, 100, 180, 180);
        noseve.setFont(new Font("TimesRoman", Font.BOLD,25));
        noseve.setColor(Color.black);
        noseve.drawString("Enhorabuena,", 100, 150);
        noseve.drawString("encontraste", 100, 180);
        noseve.drawString("todas las minas ", 100, 210);
    }
    
    public void update(Graphics g){
        paint(g);
    }

    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if(casillas[i][j].contains(x,y)){
                    casillas[i][j].Destapar();
                    explosion(casillas[i][j]);
                    victoria();
                    repaint();
                }
            }
        }
        return false;
    }
    
    public void explosion(Casilla cas){
        if(cas.getMina()!=null){
            finMalo=true;
        }
    }
    
    public void victoria(){
        int contador=0;
        for (int i = 0; i < FILAS; i++) 
            for (int j = 0; j < COLUMNAS; j++) 
                if(casillas[i][j].isTapada()==true)
                    contador++;
        if(contador==TOTALMINAS)
            finBueno=true;
    }
}
