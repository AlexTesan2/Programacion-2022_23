//desplazar las letras de cada palabra un espacio hacia la derecha y cambiar primera por ultima letra 
package vectoresdimensionales;
public class VectoresCaracteres9 {
    public static void main (String args[]){
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' ',' ',' ',' '};
        int inicio=0, fin=0;
        char intercambio;
        while(inicio<frase.length){
            while(frase[fin] != ' ')
                fin++;
            intercambio=frase[fin-1];
            for(int j=fin-1; j>inicio;j--){
                frase[j]=frase[j-1];
                frase[inicio]=intercambio;
            }
            inicio = fin = fin + 1;
            
        }
        System.out.println(frase);
        desplazarI(frase,fin,inicio);
        System.out.println(frase);
    }
    public static void desplazarI(char[] frase, int fin, int inicio){
        char intercambio; 
        intercambio=frase[inicio];
        for(int j=inicio+1; j<fin-1;j++)
                frase[j-1]=frase[j];
            frase[fin-1]=intercambio;
    }
}