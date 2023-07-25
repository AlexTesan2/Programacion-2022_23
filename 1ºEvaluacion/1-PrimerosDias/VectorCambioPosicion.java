//todos los elementos de un vector se mueven una posicion hacia la izda y el primero se pone al final
package primeros.dias;
public class VectorCambioPosicion {
    public static void main (String args[]){
        int vect[]={10,-20,30,-40,50,60};
        int cambiador=vect[0];
        int i;
        for( i = 0; i< vect.length-1; i++){  //i=1
            vect[i]= vect[i+1];              //vect[i-1] = vect[i]
            System.out.print(vect[i]+"  ");
        }
        vect[i]=cambiador;                   //vect[vect.leng-1]= cambiador
        System.out.print(vect[i]+"\n");
    }
}  

