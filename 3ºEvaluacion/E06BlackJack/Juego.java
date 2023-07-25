package E06BlackJack;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet {
    Image imagen;
    Graphics noseve;
    int valor=0;
    Image baraja[];
    String[] clases={"clubs","diamonds", "hearts","spades"};
    public static int  NUM_CARTAS=52;
    public static int CPP=90;//cartas por palo
    String[] nombres={"_of_clubs.png","_of_diamonds.png", "_of_hearts.png","_of_spades.png"};
    Baraja barajaa;
    Mano jugador, croupier;
    TextField apuesta;
    
    
    public void init(){
        this.setSize(700,800);
        
        imagen = this.createImage(700,600);
        noseve = imagen.getGraphics();
        
        setup();
        
        baraja=new Image[NUM_CARTAS];
        /*for (int i = 0; i < baraja.length; i++) {
            for (int j = 0; j <clases.length; j++) {
                baraja[i]=getImage(getCodeBase(),"E06Ims/"+ (i+1) +"_"+"of"+"_"+clases[j]+".png");
            }
        }*/
        for (int i = 0; i < baraja.length; i++) 
            baraja[i]=getImage(getCodeBase(),"E06Ims/"+ ((i%CPP) + 1) +nombres[i/CPP]);
        
        barajaa=new Baraja(baraja);
        barajaa.barajar();
        
        croupier=new Mano();
        jugador=new Mano();
        
       /* if(jugador.puntuacion()>21) jugador.teHasPasado(true);
        if( jugador.teHasPasado()){
            while(croupier.puntuacion()<17){
               croupier.anadir(barajaa.sacar());
            }
        }*/
        
        /*croupier.anadir(barajaa.sacar());
        croupier.anadir(barajaa.sacar());
        jugador.anadir(barajaa.sacar());
        jugador.anadir(barajaa.sacar());*/
    }

    private void setup() throws HeadlessException {
        this.setLayout(new BorderLayout());
        Panel panel = new Panel();
        Button boton1 =new Button("Carta !");
        Button boton2 =new Button("Me planto ");
        panel.add(boton1);
        panel.add(boton2);
        this.add("South" , panel);
        
        Panel panel2=new Panel();
        Label etiqueta=new Label("Introduzca su apuesta: ", Label.RIGHT);
        apuesta=new TextField("", 10);
        panel2.add(etiqueta);
        panel2.add(apuesta);
        this.add("North", panel2);
    }
    
    public void paint(Graphics g){
        
        noseve.setColor(Color.green);
        noseve.fillRect(0,0,700,600); 
        
        noseve.setColor(Color.black);
        noseve.drawLine(0,300,700,300);
        //noseve.drawImage(baraja[5],0,0, this);
        
        noseve.drawString("Croupier : "+croupier.puntuacion(), 100, 100);
        noseve.drawString("Tu : "+jugador.puntuacion(), 100, 400);
       
        croupier.paint(noseve, this, 100);
        jugador.paint(noseve, this, 400);
        
        g.drawImage(imagen, 0, 0, this); 
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof TextField){
            apuesta.setEditable(false);
            croupier.anadir(barajaa.sacar());
            croupier.anadir(barajaa.sacar());
            jugador.anadir(barajaa.sacar());
            jugador.anadir(barajaa.sacar());
            repaint();
            return true;
        }else 
        if(ev.target instanceof Button){
            if(ev.arg.equals("Carta !")){   //if("Carta !").equals(ev.arg)
                jugador.anadir(barajaa.sacar());
                if(jugador.teHasPasado()){
                    while(!croupier.alacanza17()){
                        croupier.anadir(barajaa.sacar());
                    }
                }
                repaint();
                return true;
            }else if (ev.arg.equals("Me planto"))
                juegaElCroupier();
            repaint();
            return true;
        }
        return false;
    }
    
    public void juegaElCroupier(){
        while(croupier.alacanza17())
           // croupier.anadir(carta(baraja.sacar));
        repaint();
    }
    
}
