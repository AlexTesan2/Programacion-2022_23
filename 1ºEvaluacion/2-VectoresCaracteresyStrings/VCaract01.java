//funcion que devuelve el numero de palabras de una frase
package vectorescaracteresystrings;
public class VCaract01 { // char :caracter que solo ocupa una direccion de memoria
    public static void main(String[] args) {
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};//caracter que solo ocupa una direccion de memoria
        System.out.println("En esta frase hay un total de "+palabras(frase)+ " palabras");
    }
    
    public static int palabras(char[] fras){
        int cont=0;
        for (int i = 0; i < fras.length; i++) {
            if (fras[i]==' ') {
                cont++;
            }
        }
        return cont;
    }
}
