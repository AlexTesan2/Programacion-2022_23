
package vectorescaracteresystrings;
import java.util.Locale;
public class String08 {
    public static void main (String args[]){
        String  frase[]={"En un","lugar en la mancha","de en cuyo nombre no ","quiero en acordarme"};
        String subCadena="en";
        for (int i=0;i<frase.length;i++)
            frase[i]=frase[i].replace(subCadena, subCadena.toUpperCase());
        frase[0]=frase[0].concat(" hola");
        for(int j=0;j<frase.length;j++)
            System.out.println(frase[j]);
        }
}
