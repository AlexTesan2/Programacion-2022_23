package Pruebas1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class MM extends Applet{
    Image imagen;
    Graphics noseve;
    public static int  NUM_FICHAS;
    public static int  TIPO_FICHAS=5;
    public static int SIZEX=600;
    public static int SIZEY=600;
    public static int CASX=4;
    public static int CASY=10;
    cas casillas[][];
    cas casillas2[][];
    Image imFichas[];
    Fi fichas[][];
    Fi fichasIni[];
    Fi fichaElegida;
    int posFila=0;
    int posCulum=1;
    int elemFila=0;
    Image bien,mal;
    boolean si,no=false;
    
    public void init(){
        dimensionar();
        instanciar();
    }

    public void dimensionar() {
        this.setSize(SIZEX,SIZEY);
        imagen = this.createImage(SIZEX,SIZEY);
        noseve = imagen.getGraphics();
    }
    
    public void instanciar() {
        casillas=new cas[CASX][CASY];
        casillas2=new cas[casillas.length][casillas[1].length];
        imFichas=new Image [TIPO_FICHAS];
        fichas=new Fi [TIPO_FICHAS][15];
        fichasIni=new Fi[casillas.length];
        
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j]=new cas((i*cas.DIM)+40,(j*cas.DIM)+40,Color.BLACK);
                casillas2[i][j]=new cas((i*cas.DIM)+70+(cas.DIM*casillas.length),(j*cas.DIM)+40,Color.BLUE);
            }
        }
        
        for (int i = 0; i < imFichas.length; i++) {
            imFichas[i]=getImage(getCodeBase(), "E10Ims/f"+(i+1)+".jpg");
        }
        
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                fichas[i][j]=new Fi (500,(2*i*Fi.dim)+60,imFichas[i]);
            }
        }
        
        for (int i = 0; i < fichasIni.length; i++) {
            fichasIni[i]=new Fi((i*cas.DIM)+41,40,imFichas[(int)(Math.random()*imFichas.length)]);
            //fichasIni[i].setTapada(true);
        }
        repaint();
        
        bien= getImage(getCodeBase(), "E08Ims/d1.jpg");
        mal=getImage(getCodeBase(), "E08Ims/re.jpg");
        
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.green);
        noseve.fillRect(0,0,SIZEX,SIZEY); 
        
        for (int i = 0; i < casillas.length; i++) {
            //casillas[i][0].paint(noseve);
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j].paint(noseve);
                casillas2[i][j].paint(noseve);
            }
        }
        
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                fichas[i][j].paint(noseve, this);
            }
        }
        //noseve.drawImage(imFichas[1], 12, 12, this);
        
        for (int i = 0; i < fichasIni.length; i++) {
            fichasIni[i].paint(noseve, this);
        }
        
        if(si){
            noseve.drawImage(bien, casillas2[posFila][posCulum].x, casillas2[posFila][posCulum].y, casillas2[posFila][posCulum].width,casillas2[posFila][posCulum].height,this);
            si=false;
        }
        if(no){
            noseve.drawImage(mal, casillas2[posFila][posCulum].x, casillas2[posFila][posCulum].y, casillas2[posFila][posCulum].width,casillas2[posFila][posCulum].height,this);
            no=false;
        }
        
        g.drawImage(imagen, 0, 0, this); 
    }
    
    public void update(Graphics g){
        paint(g);
    }  
    
    public boolean mouseDown(Event ev, int x, int y) {
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                if (fichas[i][j].contains(x, y)) {
                    fichaElegida=fichas[i][j];
                }
            }
        }
        return true;
    }
    
    public boolean mouseDrag(Event ev, int x, int y) {
        if(fichaElegida!=null){
            fichaElegida.move(x-cas.DIM/2, y-cas.DIM/2);
            repaint();
        }
        return true;
    }
    
    public boolean mouseUp(Event ev, int x, int y){ 
        if(fichaElegida==null) return false;
        if(elemFila !=4){
            if (casillas[posFila][posCulum].contains(fichaElegida)) {
                casillas[posFila][posCulum].setF(fichaElegida);
                
                /*fichaElegida.x=casillas[posFila][posCulum].x+2;
                fichaElegida.y=casillas[posFila][posCulum].y+2;*/
                comprobar();
                repaint();
                fichaElegida.setMovible(false);
                elemFila++;
                //posFila++;
            }
        }
        fichaElegida=null;
        return true;
    }
    
    public boolean comprobar(){
        if (fichaElegida.getImagen()==fichasIni[posFila].getImagen()) 
            si=true;
        else{
            for (int i = 0; i < fichasIni.length; i++) 
                if (fichaElegida.getImagen()==fichasIni[i].getImagen())
                    no=true;
        }
        return false;
    }
}
