package E18Rana2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class frog extends Rectangle{
    public static final int DIM = 25;
    public static final int ARRIBA=1004;
    public static final int ABAJO=1005;
    public static final int IZQUIERDA=1006;
    public static final int DERECHA=1007;
    int vel=6;
    public frog(){
        super(140,275,DIM,DIM);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(x, y, width, height);
    }
    
    public void update(int direccion){
        
        switch (direccion) {
            case ARRIBA:
                y-=DIM;
                break;
            case ABAJO:
                y+=DIM;
                break;
            case IZQUIERDA:
                x-=DIM;
                break;
            case DERECHA:
                x+=DIM;
                break;
        }
        
        
    }
    
    public void paredesBasicas(){
        if (x>280)
            x=280;
        if (x<0)
            x=0;
        
        if(y<0){
            y=300;
            juego.contador++;
        }
    }
    
    
    public void arriba(){
        y-=vel;
    }
    
    public void abajo(){
        y+=vel;
    }
    
    public void izda(){
        x-=vel;
    }
    
    public void dcha(){
        x+=vel;
    }
}
