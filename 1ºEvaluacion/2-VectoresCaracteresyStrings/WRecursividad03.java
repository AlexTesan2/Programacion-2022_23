//division mediante restas 
package vectorescaracteresystrings;
public class WRecursividad03 {
    public static void main (String args[]){
        System.out.println("8 / 2 = "+ dividir(8,2));        
    }
    public static int dividir(int dividendo,int divisor){
        if(dividendo<divisor)
            return 0;
        else
            return 1+dividir(dividendo-divisor, divisor);
            
    }
}
