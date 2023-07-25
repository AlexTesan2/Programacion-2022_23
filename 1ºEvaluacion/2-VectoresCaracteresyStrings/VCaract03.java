//57: pasar una frase a mayusculas
package vectorescaracteresystrings;
public class VCaract03 {
    public static void main (String args[]){
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        for (int i = 0; i <frase.length; i++) 
            frase[i]=Character.toUpperCase(frase[i]);
        System.out.println(frase);
    }    
}
