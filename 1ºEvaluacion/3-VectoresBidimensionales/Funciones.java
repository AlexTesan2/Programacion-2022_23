
package vectoresdimensionales;
public class Funciones { //Las clases: primera letra mayus
    public static void main (String args[]){   
    /*funciones:(main) en minus. los modificadores(public static void) en minus
      los metodos pueden devolver algo o no, si no devuelven nada, se usa void
      los tipos de datos(int) en ninus. String no es un tipo de dato--> mayus
    */
    escribir();
    hablar("¿Que tal?");
    animalHabla("El perro hace ", "guau guau");
    String frase=concatenar("primera ","y segunda parte");
    System.out.println(frase);
    System.out.println(concatenar("esta es ", "la otra manera"));
    }
    public static void escribir(){
        System.out.println("Hola");  
    }
    public static void hablar(String frase){//se le tiene que dar un valor a frase
        System.out.println(frase);
    }
    public static void animalHabla(String frase,String onomatopella){
        System.out.println(frase + onomatopella);
    }
    public static String concatenar(String frase1,String frase2){//se declaran variables globales de tipo String
        return frase1+frase2; //despues del return el programa no lee mas lineas dentro del metodo
    }
}
