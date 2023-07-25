//dinero pagado por mes y pagado a cada empleado por semestre
package vectoresdimensionales;
public class FuncionesSalarios3s {//lenguaje Java es polimorfo, acepta 2funciones con el mismo nombre, y las diferenca por el encabezado
    public static void main (String args[]){
        int vectorSalario[][]={{700,900,600,1200,1500,790},{1100,980,810,990,980,450},{2500,3000,1340,4500,1230,1200},{1300,2000,345,780,980,1200}};//6 meses 4 pers
        String empleados[]={"Jose","Pepe","Miguel","Raul"};
        String meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio"};
        
        
        int dineroEmpl[]=dem(vectorSalario);
        for(int i=0;i<dineroEmpl.length;i++){
            System.out.printf("%s ha cobrado %d € este semestre\n ", empleados[i],dineroEmpl[i] );
        }
        System.out.println("-------------------------------------------------0");   
        
        
        int acumulador[]= new int[4];
        int dineroEmpl2[]=dem2(vectorSalario,acumulador);
        for(int i=0;i<dineroEmpl2.length;i++){
            System.out.printf("-%s ha cobrado %d € este semestre\n ", empleados[i],dineroEmpl2[i] );
        }
        System.out.println("-------------------------------------------------1");
        
        
       int dineroCadaMes[]=dimes(vectorSalario);
       for(int i=0;i<dineroCadaMes.length;i++){
            System.out.printf("En %s los gastos han sido de %d €\n", meses[i],dineroCadaMes[i] );
        }
        System.out.println("-------------------------------------------------2");
        
        
        int acumulador2[]= new int [6];
        int dineroCadaMes2[]=dimes2(vectorSalario,acumulador2);
        for(int i=0;i<dineroCadaMes2.length;i++){
            System.out.printf("-En %s los gastos han sido de %d €\n", meses[i],dineroCadaMes2[i] );
        }
        System.out.println("-------------------------------------------------3");
        
        
        
    }
    
    
    public static int [] dem(int vect[][]){
        int acum[]=new int[4];
        for(int i=0;i<vect.length;i++){
            for(int j=0;j<vect[i].length;j++){
               acum[i]+=vect[i][j]; 
            }
        }
        return acum;    
    }
    
    public static int[] dem2(int vect2[][],int acum2[]){
        for(int i=0;i<vect2.length;i++){
            for(int j=0;j<vect2[i].length;j++){
               acum2[i]+=vect2[i][j]; 
            }   
        }
        return acum2;
    }
    
    
   public static int[] dimes(int vt[][]){
       int acumul[]=new int [6];
       for(int i=0;i<6;i++){
            for(int j=0;j<vt.length;j++){
               acumul[i]+=vt[j][i]; 
            }   
        }
        return acumul;
       
   }
   
   public static int[] dimes2(int vt2[][], int ac[]){
        for(int i=0;i<6;i++){
            for(int j=0;j<vt2.length;j++){
               ac[i]+=vt2[j][i]; 
            }   
        }
        return ac;
   
   }
}
