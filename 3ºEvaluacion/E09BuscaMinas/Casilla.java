package E09BuscaMinas;//10 bombas aleatoriamente

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    private Image mina;
    Image reverso;
    private Boolean tapada;
    public static final int DIM = 17;
    private int alrededor;  //para saber cuantas minas tiene en sus cercanias
    
    public Casilla(int posX, int posY, Image rev){  //luego le pasaremos la im mina
        super(posX, posY, DIM, DIM);
        tapada = true;
        this.reverso = rev;
        alrededor=0;
        mina=null;   
    }
    
    public void dibujar(Graphics g,  Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        if(tapada)
            g.drawImage(reverso, x, y, width, height, a);
        else if(mina!=null)
            g.drawImage(mina, x, y, width, height, a);
        else{
            g.drawString((alrededor==0)?"":""+alrededor, x+(DIM/2), y+12);//(alredeor==0)?"":""+alrededor -- +4+13
        }
        
        g.drawRect(x, y, width, height);
    }
    
    
    
    //getters y seters     
    public Boolean isTapada() {
        return tapada;
    }

    public void Destapar(){
        tapada=false;
    }
    
    public Image getMina() {
        return mina;
    }

    public void setMina(Image mina) {
        this.mina = mina;
    }

    public int getAlrededor() {
        return alrededor;
    }

    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }
    
    public void incrementarAlrededor(){
        this.alrededor = alrededor+1;
    }
    
}
