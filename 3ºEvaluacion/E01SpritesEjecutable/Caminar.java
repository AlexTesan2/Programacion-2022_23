package E01SpritesEjecutable;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Caminar extends Applet implements Runnable {
    
    public static final int FILAS = 3;
    public static final int COLUMNAS = 4;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    
    Image img;
    Image fotogramas[][];
    //String elementos[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v"};
    String elementos[] = {"g", "h", "v"};
    Personajes persona;
    
    
    public void init(){
        this.setSize(400,400);
        imagen = this.createImage(400,400);
        noseve = imagen.getGraphics();
        
        fotogramas = new Image[FILAS][COLUMNAS];
        
        for(int i=0; i<FILAS;i++)
            for(int j=0; j<COLUMNAS;j++)
                fotogramas[i][j] = getImage(getCodeBase(), "E01SpritesImagenes/" + elementos[i] + (j+1) + ".gif");
        persona = new Personajes (fotogramas[0]);
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,400,400);
        persona.paint(noseve, this);
        
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){
            persona.update();
            repaint();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){}
        }
    }
    
    public boolean keyDown(Event ev, int tecla){
        switch(tecla){
            case 71:
            case 103:
                    persona.setImagenes(fotogramas[0]);
                break;
            case 72:
            case 104:
                    persona.setImagenes(fotogramas[1]);
                break;
            case 86:
            case 118:
                    persona.setImagenes(fotogramas[2]);
                break;       
        }
        return true;
    }
}
