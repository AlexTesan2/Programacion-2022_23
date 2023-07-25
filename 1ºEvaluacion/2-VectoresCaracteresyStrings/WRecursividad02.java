//87 recursividad de una multiplicacion medinte sumas
package vectorescaracteresystrings;
public class WRecursividad02 {
     public static void main (String args[]){
        System.out.println("8 * 4 = "+ multiplicar(8,4));
    }
    public static int multiplicar(int x,int y){
        if(y==1)
            return x;
        else
            return x + multiplicar(x, y-1);
    }
}
