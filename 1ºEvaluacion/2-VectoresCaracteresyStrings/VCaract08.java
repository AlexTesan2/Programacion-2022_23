//modificar frase transformando cada palabra de manera que el primer y ultiimo caracter de cada palabra se intercambiam 
package vectorescaracteresystrings;
public class VCaract08 {
    public static void main (String args[]){
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        int inicio=0, fin=0;
        char intercambio;
        while(fin!=frase.length){
            while(frase[fin]!=' ')
                fin++;
            intercambio=frase[inicio];
            frase[inicio]=frase[fin-1];
            frase[fin-1]=intercambio;
            inicio=fin=fin+1;
        }
        System.out.println(frase);
    }
}
