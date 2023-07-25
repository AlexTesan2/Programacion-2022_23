//campanadas
package vectorescaracteresystrings;
public class WRecursividad05 {
    public static void main (String args[]){
        System.out.println("Se han tocado "+campanadas(17)+" campandas");
    }
    public static int campanadas(int hora){
        if(hora==0)
            return 0;
        if(hora>12)
            return hora-12 + campanadas(hora-1);
        else
            return hora + campanadas(hora-1);
    }
}
