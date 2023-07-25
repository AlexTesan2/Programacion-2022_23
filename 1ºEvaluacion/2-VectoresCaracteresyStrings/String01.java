// frase.charAt(5)  --> recoge el caracter que se encuentra en la posicion del String
package vectorescaracteresystrings;
public class String01 {
    public static void main(String[] args) {
        String frase="En un lugar de la Mancha";//String es objeto de una clase con su propia direccion de memoria
        char[] cadena= new char[150];
        
        for (int i = 0; i < frase.length(); i++)//lenght() es la longitud del String, usa parentesis porque ya no es una propiedad denun vector 
            System.out.printf("%c-", frase.charAt(i));
        System.out.print("\n");
        
        for (int j = 0; j < frase.length(); j++) {
            cadena[j]=frase.charAt(j);
        }
        System.out.println(cadena);
    }
}
