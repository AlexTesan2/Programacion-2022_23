//factorial de 5!
package primeros.dias;
public class factorialBucle3 {
    public static void main (String arc[]){
        int num=5;
        int resultado=1;
        for(int fact=num; fact>0; fact--)
            resultado *= fact;
        System.out.println("El factorial de "+ num + " es "+ resultado); 
    }
}
