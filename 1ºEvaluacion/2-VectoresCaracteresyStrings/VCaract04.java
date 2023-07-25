//58: cambiar 'a' por la 'X'
package vectorescaracteresystrings;
public class VCaract04 {
    public static void main (String args[]){
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        for (int i=0;i<frase.length;i++)
            if(frase[i]=='a')
                frase[i]='X';
        System.out.println(frase);
    }
}
