package E07Solitario;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    ArrayList<Carta> lista;
    
    public Baraja(Image[] imagenes){
        lista = new ArrayList<Carta>();
        for (int i = 0; i < imagenes.length; i++) {
            lista.add(new Carta(imagenes[i], (i % Solitario.CPP) + 1, ((i/13) == 0 || (i/13) == 3)? Carta.NEGRO:Carta.ROJO , (i/13)));
        }
    }
    
    public void barajar(){ 
        Collections.shuffle(lista);//shuffle desordena una lista
    }

    public Carta sacar(){
        Carta auxiliar = lista.get(0); //creamos una carta temporal que guarda la dirección de donde se encuentra el objeto en la lista
        lista.remove(0);
        return auxiliar;
    }
}