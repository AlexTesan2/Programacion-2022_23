//quitar espacios en blanco con concatenaciones y substrings         2 exxam 
package vectorescaracteresystrings;
public class String09 {
    public static void main(String[] args) {
        String frase="Habia una vez, un circo que siempre alegraba el corazón ";
        int posicion=frase.indexOf(' ');
        while(posicion!=-1){
            frase=frase.substring(0, posicion).concat(frase.substring(posicion+1, frase.length()));
            posicion=frase.indexOf(' ');
        }
        System.out.println(frase);
    }
}
