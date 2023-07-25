//frase.replace('x','y')
package vectorescaracteresystrings;
public class String04 {
    public static void main(String[] args) {
        String frase="En un lugar de la Mancha n   s n n n ns";
        String frase2=frase.replace('n', 'Y');
        System.out.println(frase2);
        
        String frase3="En un lugar de la Mancha";
        frase3=frase3.replace('a', 'V');
        System.out.println(frase3);
        
        frase3=frase3.replaceAll("V", "PPPP");
        System.out.println(frase3);
    }
}
