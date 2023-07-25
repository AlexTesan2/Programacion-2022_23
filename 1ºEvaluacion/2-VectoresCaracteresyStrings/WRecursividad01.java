//ejercicios de recursividad no caen en primer examen
//recursividad: funciones que se llaman a si mismas 
//procesos backtacking
//factorial de un numero con recursividad
package vectorescaracteresystrings;
public class WRecursividad01 {
    public static void main (String args[]){
        System.out.println("Factorial de 5 : " + factorial(5));
    }
    public static int factorial(int n){
        if(n==1)
            return 1;
        else
            return n*factorial(n-1);
    }
}
