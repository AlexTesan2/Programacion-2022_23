//73:  (frase.substring(3, 11)) es polimorfo, acepta varias morfologias
package vectorescaracteresystrings;
public class String03 {
    public static void main(String[] args) {
        String frase="En un lugar de la Mancha";
        System.out.println(frase.substring(3, 11));
        
        System.out.println(frase.substring(3));
        
        for (int i = 0; i < frase.length(); i++) {
            System.out.println(frase.substring(0,i+1));
        }
    }
}
