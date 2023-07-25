
package vectoresdimensionales;
public class FuncionesSalarios4 {
    public static void main (String args[]){
        int v[][]={{700,900,600,1200,1500,790},{1100,980,810,990,980,450},{2500,3000,1340,4500,1230,1200},{1300,2000,345,780,980,1200}};//6 meses 4 pers
        String empleados[]={"Jose","Pepe","Miguel","Raul"};
    
        for(int i=0;i<v.length;i++){
            //int pago= fpagare(v[i]);
            System.out.printf("%s cobra un total de %d\n",empleados[i],fpagare(v[i]));//pago
        }    
    }
    
    public static int fpagare(int[]v2){
        int acum=0;
        for(int u=0;u<v2.length;u++){
            acum+=v2[u]; 
        }
        return acum;
    }
    
}
