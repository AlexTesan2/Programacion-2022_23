package Solitario;

import java.awt.Image;
import java.util.Collections;

public class Baraja {
    java.util.List<Carta> mazoPrincipal;
    public Baraja(Image imagenes[]){
        mazoPrincipal=new java.util.ArrayList();
        for (int i = 0; i < imagenes.length; i++) {
            mazoPrincipal.add(new Carta(imagenes[i], (i%13)+1, ((i/13)== 0 || (i/13)==3)? Carta.NEGRO:Carta.ROJO, (i/13)));
        }
        Collections.shuffle(mazoPrincipal);
    }
    

    
    public Carta sacar(){
        Carta auxiliar=mazoPrincipal.get(0);
        mazoPrincipal.remove(0);
        return auxiliar;
    }
}
