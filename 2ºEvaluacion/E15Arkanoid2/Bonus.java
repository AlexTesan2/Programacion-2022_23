package E15Arkanoid2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bonus extends Rectangle {
    Color color;
    public static final int RADIO = 15;

    
    public Bonus(int x, int y, Color color){
        super(x, y, 0, 0);
        this.height = RADIO;
        this.width = RADIO;
        this.color = color;
        
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
        g.drawOval(x, y, width, height);
    }
    public void update(){
        y++;
    }
}