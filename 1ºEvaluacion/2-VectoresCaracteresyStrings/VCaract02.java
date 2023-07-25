//56 : a funcion le paso la frase y devuelve otra frase en la que cada palabra termine en 'X'
package vectorescaracteresystrings;
public class VCaract02 {
    public static void main (String args[]){
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        char fraseMod[]=new char [50];
        modificarFrase (frase, fraseMod);
        System.out.println(fraseMod);
    }
    
    public static void modificarFrase (char[] frasep ,char[] frase2){
        for(int i=0,j=0;i<frasep.length;i++,j++){
            if(frasep[i]==' '){
                frase2[j]='X';
                j++;
            }
            frase2[j]=frasep[i];
        }
    }
}
