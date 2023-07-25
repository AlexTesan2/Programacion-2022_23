//num de veces que aparece un String en la frase
package vectorescaracteresystrings;
public class String07 {
    public static void main(String[] args) {
        String  frase[]={"En un"," lugar de la mancha"," de cuyo nombre no "," quiero acordarme"};
        int cont=0;
        String pal="a";
        for (int i=0;i<frase.length;i++){
            int posicion= frase[i].indexOf(pal);
            while(posicion != -1){
                cont++;
                posicion=frase[i].indexOf(pal,posicion+1);
            }
        }
        System.out.printf("La letra 'a' aparece %d veces\n",cont);
        
    }
    
}
