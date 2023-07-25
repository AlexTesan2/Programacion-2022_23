package E16FlappyBird;
 //habra 2 rectangulos, el primero tendra una altura aleatoria, el otro la mista pos x, y la posy es random-50
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pared{
    
    private Rectangle rArriba;          //insert code , getter , seter
    private Rectangle rAbajo;
    
    public Pared(){
        rArriba=new Rectangle(300,0,40,(int)(Math.random()*150)+50);
        rAbajo=new Rectangle(300,rArriba.height+50,40, 300-(rArriba.height+50));
    }
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(rArriba.x, rArriba.y, rArriba.width, rArriba.height);
        g.fillRect(rAbajo.x, rAbajo.y, rAbajo.width, rAbajo.height);
    }
    
    public void update(){
        rArriba.x = rArriba.x-1;
        rAbajo.x  = rAbajo.x-1; 
    }

    public Rectangle getrArriba() {
        return rArriba;
    }

    public void setrArriba(Rectangle rArriba) {
        this.rArriba = rArriba;
    }

    public Rectangle getrAbajo() {
        return rAbajo;
    }

    public void setrAbajo(Rectangle rAbajo) {
        this.rAbajo = rAbajo;
    }
    
}
