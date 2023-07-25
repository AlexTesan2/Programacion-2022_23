//sisrtema d hond
package vectorescaracteresystrings;
public class WRecursividad08 {
    public static void main (String args[]){
        final int ESCANOS=7;//variable constante, no se puede modificar/variar
        String partidos[]={"P.P","P.S.O.E","Podemos","Ciudadanos","VOX"};
        int votos[]={119421,157420,57398,46645,91978};
        int[] coeficientes={1,1,1,1,1};
        for (int i = 0; i < ESCANOS; i++) {
            int posmax=0;
            for (int j = 0; j < partidos.length;j++) 
                if((votos[j])/coeficientes[j]>(votos[posmax])/coeficientes[posmax]){
                    posmax=j;
                }
            coeficientes[posmax]++;
        }
        for (int i = 0; i <partidos.length; i++) {
            System.out.printf(">%s : %d escaños\n", partidos[i],coeficientes[i]-1);
        }
    }
}