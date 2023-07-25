//83: poner una a despues del final de cada palabra con concat
package vectorescaracteresystrings;
public class String12 {
    public static void main(String[] args) {
        String frase="Habia una vez , un circo que siempre alegraba el corazón ";
        int fin= frase.indexOf(' ');
        while(fin!=-1){
            frase=frase.substring(0,fin).concat("a").concat(frase.substring(fin,frase.length()));
            fin=frase.indexOf(' ',fin+2);
        }
        System.out.println(frase);
    }
}
