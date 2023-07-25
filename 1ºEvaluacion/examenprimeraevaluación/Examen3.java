//cada palabra que ocupe la primera posición en la frase, pasará a la última posición en la siguiente iteración
package examenprimeraevaluación;
public class Examen3 {
    public static void main(String[] args) {
        String frase = "En un lugar de La Mancha de cuyo nombre no quiero acordarme ";
        int cont=0;
        int inicio = 0, fin = frase.indexOf(' ');
        
        while (fin != -1) {
            cont++;
            inicio = fin + 1;
            fin = frase.indexOf(' ', inicio + 1);
        }
        
        for (int x = 0; x < cont; x++){
            fin = frase.indexOf(' ');
            frase=frase.substring(fin+1,frase.length()).concat(frase.substring(0,fin+1));
            System.out.println(frase);
        }
        
    }
}
