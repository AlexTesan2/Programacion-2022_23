//pasar numero normal a binario
package vectorescaracteresystrings;
public class WRecursividad07 {
        public static void main (String args[]){
        int numero=245;
        enBinario(numero);
        System.out.println("");
        
    }
    public static void enBinario(int numero){//se acaba poniendo en orden contraio
        if(numero==1)
            System.out.print(""+1);
        else{
            enBinario(numero/2);
            System.out.print(numero%2);
        }
    }
}
