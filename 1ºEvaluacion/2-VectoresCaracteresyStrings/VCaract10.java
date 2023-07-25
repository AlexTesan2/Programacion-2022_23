//64      sustituir un caracter por una subcadena y hacerlo utilizando una new cadena de caracters
package vectorescaracteresystrings;
public class VCaract10 {
    public static void main(String[] args) {
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        char caracter='a';
        char subcadena[]={'A','B','C','D','E'};
        char cadena2[]= new char[150];
        
        for (int i = 0,j=0; i < frase.length; i++,j++) {
            if(frase[i]==caracter)
                for (int k = 0; k < subcadena.length; k++,j++)
                    cadena2[j]=subcadena[k];
            else
                cadena2[j]=frase[i];
        }
        System.out.println(cadena2);
    }
}
