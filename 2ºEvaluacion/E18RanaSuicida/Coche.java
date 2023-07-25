package E18RanaSuicida;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coche {
    private Rectangle cArriba;
    private Rectangle cAbajo;

    Color colores[]={Color.BLUE, Color.YELLOW, Color.ORANGE, Color.cyan,Color.lightGray};
    Color colorU, colorD;
    
    public Coche(){
        cArriba=new Rectangle(320,90,(int)(Math.random()*30)+30,(int)(Math.random()*30)+30);
        cAbajo =new Rectangle(-20,180,(int)(Math.random()*30)+30,(int)(Math.random()*30)+30);
        
        colorU=colores[(int)(Math.random()*colores.length)];
        colorD=colores[(int)(Math.random()*colores.length)];
    }
    
    public void paint(Graphics g){
        g.setColor(colorU);
        g.fillRect(cArriba.x, cArriba.y,cArriba.width,cArriba.height);
        
        g.setColor(colorD);
        g.fillRect(cAbajo.x, cAbajo.y,cAbajo.width, cAbajo.height);
    }
    
    public void update(){
        cArriba.x= cArriba.x-3;
        cAbajo.x = cAbajo.x+3;
    }
    
    
    
    public Rectangle getcArriba() {
        return cArriba;
    }

    public void setcArriba(Rectangle cArriba) {
        this.cArriba = cArriba;
    }

    public Rectangle getcAbajo() {
        return cAbajo;
    }

    public void setcAbajo(Rectangle cAbajo) {
        this.cAbajo = cAbajo;
    }
}





/*package E18RanaSuicida;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coche extends Rectangle {
    
    Color colores[]={Color.BLUE, Color.YELLOW, Color.ORANGE, Color.cyan,Color.lightGray};
    int Y[]={180,130};
    Color color;
    
    public Coche(){
        super(-10,180,(int)(Math.random()*30)+30,(int)(Math.random()*15)+30);

        color=colores[(int)(Math.random()*colores.length)];
    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void update(){
        x+=4;
    }
    
}*/
