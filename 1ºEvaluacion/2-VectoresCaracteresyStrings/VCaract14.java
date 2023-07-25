//eliminar el caracter del vector origial
package vectorescaracteresystrings;
public class VCaract14 {
    public static void main(String[] args) {
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a'};
        char eliminable='n';
        for(int i=0;i<frase.length;i++)
            if(frase[i]==eliminable)
                for(int j=i;j<frase.length-1;j++){
                    frase[j]=frase[j+1];
                    frase[j+1]=' ';
                }
        System.out.println(frase);    
        
    }
}
