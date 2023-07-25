//67 meter en frase2 la frase pero con las palabras en orden inverso
package vectorescaracteresystrings;
public class VCaract13 {
    public static void main(String[] args) {
        char frase[]={' ','E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a'};
        char cadena2[]=new char[150];
        int inicio=frase.length-1,fin=frase.length-1;
        int j=0;
        while(inicio>0){
            while(frase[inicio]!=' ')
                inicio--;
            for (int i =inicio; i <=fin; i++,j++) {
                cadena2[j]=frase[i];
            }
            fin=inicio=inicio-1;
        }
        System.out.println(cadena2);
    }
}
