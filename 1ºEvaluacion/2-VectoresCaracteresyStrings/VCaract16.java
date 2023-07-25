//primera y ultima letra de cada palabra en mayus 
package vectorescaracteresystrings;
public class VCaract16 {
    public static void main(String[] args) {
        char frase[]={'e','n',' ','u','n',' ','l','u','g','a','r',' ','e','n',' ','l','a',' ','m','a','n','c','h','a',' '};
        int inicio=0;
        int fin=0;
        while(inicio<frase.length){
            while(frase[fin]!=' ')
                fin++;
            frase[inicio]=Character.toUpperCase(frase[inicio]);
            frase[fin-1]=Character.toUpperCase(frase[fin-1]);
            inicio=fin=fin+1;
        }
        System.out.println(frase);
    }
}
