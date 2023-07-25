//cuantas veces aparece un caracter?
package vectorescaracteresystrings;
public class String06 {
    public static void main(String[] args) {
        String  frase[]={"En un"," lugar de la mancha"," de cuyo nombre no "," quiero acordarme"};
        int cont=0;
        for (int i = 0; i < frase.length; i++) 
            for (int j = 0; j < frase[i].length(); j++)
                if(frase[i].charAt(j)=='a')
                    cont++;
        System.out.printf("La letra 'a' aparece %d veces\n",cont);
    }
}
