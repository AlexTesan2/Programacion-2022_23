package E17Naves;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala extends Rectangle{
    int velY;
    
    public Bala(int x){
        super(x+5,260, 5, 30);
        int velY=15;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);
    }
    
    public void update(){
        y=y-3; 
    }
}
