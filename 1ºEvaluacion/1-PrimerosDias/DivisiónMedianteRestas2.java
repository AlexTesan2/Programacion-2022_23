
package primeros.dias;

public class DivisiónMedianteRestas2 {
    public static void main (String arc[]){
    
    int dividendo=24;
    int divisor=4;
    int a = dividendo;
    int cuenta=0;
    
    while(a>= divisor){
    a -= divisor;
    cuenta ++; 
    } 
        System.out.println( dividendo +"/"+divisor+"="+cuenta);
    }
}
