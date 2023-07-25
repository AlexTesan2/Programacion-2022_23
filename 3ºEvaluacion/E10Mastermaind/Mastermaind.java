package E10Mastermaind;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Mastermaind extends Applet{
    
    public static final int TIPOSFICHAS = 5;
    public static final int CANTIDADFICHAS = 10;
    public final static int SIZEX = 800;
    public final static int SIZEY = 800;
    private Ficha [][] fichas;
    private Image [] ImFichas=new Image[TIPOSFICHAS];
    private Casillas[][] casillas=new Casillas[4][9];
    private Image imagen; 
    private Graphics noseve;
    private Thread animacion;
    private int delay = 200;
    private Image reverso;
    private Image minaI;
    private Image[] imagenes;

    public void init(){
        dimensionar(); 
        instanciarImgs();
        fichas = new Ficha[TIPOSFICHAS][CANTIDADFICHAS];
        crearFichas(); 
        crearCasillas();
    }

    private void dimensionar() {
        this.setSize(SIZEX, SIZEY);
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics();
    }
    
    private void instanciarImgs() {
        for (int i = 0; i < ImFichas.length; i++) {
            ImFichas[i]=getImage(getCodeBase(), "E10Ims/f"+(i+1)+".jpg");
        }
    }
    
    private void crearFichas() {
        for(int i = 0; i < TIPOSFICHAS; i++)
            for(int j = 0; j < CANTIDADFICHAS; j++)
                fichas[i][j] = new Ficha(ImFichas[i],30+(i*100));
    }
    
    private void crearCasillas() {
        for(int i = 0; i < casillas.length; i++)
            for(int j = 0; j < casillas[i].length; j++)
                casillas[i][j] = new Casillas(100+(50*i),100+(50*j));
    }
    
    /*private void buscarMinas(){
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
    }*/
    
    public void paint(Graphics g){
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        //noseve.drawImage(ImFichas[4], 20, 20, this);
        
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                fichas[i][j].dibujar(noseve, this);
            }
        }
        
        for(int i = 0; i < casillas.length; i++)
            for(int j = 0; j < casillas[i].length; j++)
                casillas[i][j].paint(noseve, this);
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){
        paint(g);
    }

    /*public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if(casillas[i][j].contains(x,y)){
                    casillas[i][j].Destapar();
                    explosion(casillas[i][j]);
                    repaint();
                }
            }
        }
        return false;
    }*/
}
