package E06DibujandoOvalo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ovalo {    //Aquí creamos el ovalo, despues se pintará sobre graficts.
    int altura;
    int ancho;
    int posX;
    int posY;
    Color color;
    Random r;
    
    public Ovalo(){
        r=new Random();
        inicializar();
    }
    
    public void inicializar(){      //Se dan valores aleatorios a las propiedades del ovalo asi como las tres tonalidades del color
        altura=r.nextInt(100)+100;
        ancho=r.nextInt(100)+100;
        posX=r.nextInt(200);
        posY=r.nextInt(200);
        color= new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
    }
    
    public void pintar (Graphics g){
        g.setColor(color);
        g.fillOval(posX, posY, ancho, altura);
    }
}

//Una subclase tiene todos los atributos de la superclase y ademas los que le añades.