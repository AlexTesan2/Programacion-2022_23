//meter en cada frase una palabra alternando
package vectorescaracteresystrings;
public class String14 {
    public static void main(String[] args) {
        String frase="Habia una vez un circo ";
        String fraseA="";
        String fraseB="";
        boolean f= true;
        int inicio=0;
        int posicion= frase.indexOf(" ");
        while(posicion != -1){
            if(f){
                f=false;
                fraseA=fraseA.concat(frase.substring(inicio,posicion+1));
            }else{
                f=true;
                fraseB=fraseB.concat(frase.substring(inicio,posicion+1));
            }
            inicio=posicion+1;
            posicion=frase.indexOf(' ',inicio);
        }
        System.out.println("fraseA:  " + fraseA);
        System.out.println("fraseB:  " + fraseB);
    }
}
