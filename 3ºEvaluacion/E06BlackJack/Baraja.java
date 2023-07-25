package E06BlackJack;

import java.awt.Image;
import java.util.ArrayList;

public class Baraja {
    ArrayList<Carta> lista;
    Image[] ims;
    
    public Baraja(Image [] imagenes){
        lista = new ArrayList<Carta>();
        for (int i = 0; i < Juego.NUM_CARTAS; i++) 
            lista.add(new Carta(imagenes[i],(i%Juego.CPP)+1));
    }
    
    public void barajar(){
        int posAleat1;
        int posAleat2;
        Carta Auxiliar;
        for (int i = 0; i < 100; i++) {
            posAleat1=(int)(Math.random()*lista.size());//int c1=(int)(Math.random()*Juego.NUM_CARTAS)
            posAleat2=(int)(Math.random()*lista.size());
            
            Auxiliar=lista.get(posAleat1);
            lista.set(posAleat1, lista.get(posAleat2));
            lista.set(posAleat2,Auxiliar);
        }//set: posicion a modificar y valor modificado 
    }
    
    public Carta sacar(){//devolver carta y sacarla de la lista
        Carta auxiliar = lista.get(0);
        lista.remove(0);
        return auxiliar;
    }
}

/*public Carta sacar(){//devolver carta y sacarla de la lista
        Carta auxiliar = lista.get(0);//guarda la direccion de memoria del primer elem de la lista
        int posAleatoria;
        posAleatoria=(int)(Math.random()*lista.size());
        auxiliar=lista.get(posAleatoria);
        lista.remove(posAleatoria);
        return auxiliar;
    }*/