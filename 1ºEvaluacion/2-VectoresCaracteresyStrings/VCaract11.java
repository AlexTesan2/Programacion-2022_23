//poner la frase al reves : sobre cadena 2 
package vectorescaracteresystrings;
public class VCaract11 {
    public static void main(String[] args) {
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        char cadena2[]= new char[150];
        for (int i = 0,j=cadena2.length-1; i < frase.length; i++,j--) 
            cadena2[j]=frase[i];
        System.out.println(cadena2);
    }
}
