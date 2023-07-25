package E08PareajasCartas;//juego: dememory

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Parejas extends Applet implements Runnable{
    public static final int FILAS = 4;
    public static final int COLUMNAS = 4;
    public final static int SIZEX = 800;
    public final static int SIZEY = 800;
    private Image imagen; 
    private Graphics noseve;
    private Thread animacion;
    private int delay = 200;
    private Image reverso;
    private Image[] imagenes;
    private Casilla[][] casillas;
    private Casilla activa1;
    private Casilla activa2;
    private int contador;
    private int descubiertas;
    private int fallos;
    
    public void init(){   
        dimensionar(); 
        instanciarImgs();
        casillas = new Casilla[FILAS][COLUMNAS];
        crearCasillas();
        desordenarImagenes();
    }

    private void dimensionar() {
        this.setSize(SIZEX, SIZEY);
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics();
    }
    
    private void instanciarImgs() {
        reverso = getImage(getCodeBase(), "E08Ims/re.jpg");
        imagenes = new Image[FILAS*COLUMNAS/2];
        for(int i = 0; i < imagenes.length; i++)
            imagenes[i] = getImage(getCodeBase(), "E08Ims/d"+(i+1)+".jpg");
    }
    
    private void crearCasillas() {
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)
                casillas[i][j] = new Casilla((i*150)+70,(j*150)+70, imagenes[(i*FILAS + j)/2], reverso);
    }
    
    private void desordenarImagenes() { //para desordenar intercaabiamos la primera imagen con una que se encuenter en una pos aleatoria
        for(int i = 0; i < 200; i++){
            Image intercambio;
            int aleatorioFilas = (int)(Math.random()*FILAS);
            int aleatorioColumnas = (int)(Math.random()*COLUMNAS);
            intercambio = casillas[aleatorioFilas][aleatorioColumnas].getImagen();  //getImagen - coger imagen,    seImage - poner imagen
            casillas[aleatorioFilas][aleatorioColumnas].setImagen(casillas[0][0].getImagen());  
            casillas[0][0].setImagen(intercambio);
        }
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.green);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.setColor(Color.black);
        descubiertas = 0;
        for(int i = 0; i < FILAS; i++)  //dibujar casillas
            for(int j = 0; j < COLUMNAS; j++){
                casillas[i][j].paint(noseve, this);
                if(casillas[i][j].isDescubierta())
                    descubiertas++;
            }
        
        noseve.drawString("Fallos: " + fallos, SIZEX-100, SIZEY-10);
        
        if(descubiertas == 16){ //cuando se acaba el juego
            noseve.setColor(Color.WHITE);
            noseve.fillRect(0, 0, SIZEX, SIZEY);
            noseve.setColor(Color.BLACK);
            noseve.setFont(new Font("Arial", Font.BOLD, 56));
            noseve.drawString("Completado", SIZEX/2-170, SIZEY/2);
           // noseve.drawString("Fallos: " + fallos, SIZEX/2-140, SIZEY/2 + 100);
        }
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){
            contador++;
            if(contador == 1000/delay){
                repaint();
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
            /*
            if(contador==3000){
                if(activa1!=null) activa1.setVisible(false);
                if(activa2!=null) activa2.setVisible(false);
                activa1=activa2=null;
                temporal=0;
            }
            */
        }
    }

    public boolean mouseDown(Event ev, int x, int y){
        if(contador < (1000/delay))
            return false;
        for(int i = 0; i < FILAS; i++)
            for(int j = 0; j < COLUMNAS; j++)
                if(casillas[i][j].contains(x,y) && activa1 == null && !casillas[i][j].isDescubierta()){
                    casillas[i][j].setDescubierta(Boolean.TRUE);//setVisible(true)
                    activa1 = casillas[i][j];          //switch(temporal) {case 0: activa1=casillas[i][j];temporal=1;break;   case 1: activa2==casillas[i][j] if(activa1.getImagen()==activa2.getImagen()){temporal=2;break; activa1=activa2=NULL; }else{temporal=2;contador=0;}break; // case2: contador+=tiempo;  if(contador==3000){activa1.setVisible(false);activa2.setVisible(false); temporal=0; repaint()} }          //temporal es el numero de cartas descubiertas       
                    repaint();
                }else if(casillas[i][j].contains(x,y) && activa2 == null && !casillas[i][j].isDescubierta()){
                    casillas[i][j].setDescubierta(Boolean.TRUE);
                    activa2 = casillas[i][j];
                    repaint();
                }
        return false;
    }
    
    /*
        public boolean mouseDown(Event ev, int x, int y){
        if(contador < (1000/delay))
            return false;
        
        return false;
    }
    */
    
    public boolean mouseUp(Event ev, int x, int y){
        if(activa1 == null || activa2 == null)  //si no has clicado dos cartas, se lale
            return false;
        if(activa1.getImagen() != activa2.getImagen()){//si las dos imagenes son diferentes se ocultan
            activa1.setDescubierta(Boolean.FALSE);
            activa2.setDescubierta(Boolean.FALSE);
            contador = 0;
        }
        activa1 = null;
        activa2 = null;
        fallos++;

        return true;
    } 
}
