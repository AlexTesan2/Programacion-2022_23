//7!/3!
package primeros.dias;
public class ProbabVariaciones {
    public static void main (String arc[]){
        int numgrande=7 ;
        int numpeque= 3;
        int resultado=1;

        for(int z=numgrande; z > numpeque; z--)
            resultado *= z;
        System.out.println(numgrande+"! "+"/ "+numpeque+"! "+ "= "+resultado );
    }// variaciones de 7 elementos, tomados de 4 en 4 es = a resultado
}
    
    

