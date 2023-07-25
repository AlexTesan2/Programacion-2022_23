package E14Pelota;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable { //requiere de un run()
    
    public static final int  NUM_PELOTAS=50; //definir: declara variable de tipo puntero
    Thread animacion;
    Image imagen;
    Graphics noseve;
    List<Pelota>pelotas;     
    
    public void init(){
        this.setSize(400, 400);
        imagen=this.createImage(400, 400);//esto sirve para evitar parpadeo
        noseve=imagen.getGraphics();
        
        pelotas=new ArrayList<Pelota>();
        for (int i = 0; i < NUM_PELOTAS; i++) 
            pelotas.add(new Pelota((int) (Math.random()*40)+10));//le paso el diametro
    
            //pelota = new Pelota((int)(Math.random()*40)+10);
    }
    
    public void start(){
        animacion=new Thread(this);
        animacion.start();  //llamada al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 400, 400);
        
        for (int i = 0; i < pelotas.size(); i++) 
            pelotas.get(i).paint(noseve);
        
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){    //bucle infinito
            for (int i = 0; i < pelotas.size(); i++)    //pelota.update();//update pelota --> moviminto haxcia derecha
                pelotas.get(i).update();
            repaint();      //borrar y volver a pintar
            try {
                Thread.sleep(10);   //se duerme cada 10 miliseg
            } catch (InterruptedException e) {}
        }
    }
    
    //eliminar las pelotas al tocarlas
    public boolean mouseDown(Event ev, int x ,int y ){
        for (int i = 0; i < pelotas.size(); i++)  //debuelve una pelota
            if (pelotas.get(i).contains(x,y)) 
                pelotas.remove(i);
        
        return true;
    }
}
