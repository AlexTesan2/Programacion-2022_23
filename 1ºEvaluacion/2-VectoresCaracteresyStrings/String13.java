//84: eliminar los espacios que sobran
package vectorescaracteresystrings;
public class String13 {
    public static void main(String[] args) {
        String frase="Habia   una vez  ,   un circo     que    siempre alegraba        el corazón ";
        boolean primero=true;
        for(int i=0;i<frase.length();i++){
            if(frase.charAt(i)==' '){
                if(primero)
                    primero=false;
                else{
                    frase=frase.substring(0,i).concat(frase.substring(i+1, frase.length()));
                    i--;
                }      
            }else
                primero=true;
        }
        System.out.println(frase);
    }
}
