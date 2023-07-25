
package vectorescaracteresystrings;
public class WRecursividad04 {
      public static void main (String args[]){
        mostrarFrase(5);
    }
    public static void mostrarFrase(int a){
        if(a>0){
            System.out.println("mostrarfrase("+a+")");
            mostrarFrase(a-1);
            System.out.println("mostrarfrase("+a+")");
        }
    }
}
