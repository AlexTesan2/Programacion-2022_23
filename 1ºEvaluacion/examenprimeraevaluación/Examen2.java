//Sin crear ninguna función y sobre la misma cadena de caracteres “frase2”, añadir una ‘A’ al final de cada palabra.
package examenprimeraevaluación;
public class Examen2 {
    public static void main(String[] args) {
        char frase2[] = new char[50];
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a','n', 'c', 'h', 'a', ' '};
        char sustituto='A';
        for(int i=0; i < frase.length; i++)
            frase2[i] = frase[i];
        
        for (int i = 0; i < frase2.length; i++) {
            if(frase2[i]==' '){
                for (int j = frase2.length-1; j > i; j--) {
                    frase2[j]=frase2[j-1];
                }
                frase2[i]=sustituto;
                i++;
            }
        }
        System.out.println(frase2);
    }
}
