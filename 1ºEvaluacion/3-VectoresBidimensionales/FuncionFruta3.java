
package vectoresdimensionales;
public class FuncionFruta3 {
    public static void main (String args[]){
        int kilos[][]={{5,6,9,23,7,14,2},{16,8,33,4,15,21,0}};
        int precios[]={6,7};
        String frutas[]={"Jabuticaba","Hala aka puhala"};
        int ganancias[]=sumarFruta(kilos,precios);
        for(int i=0;i<ganancias.length; i++){
            System.out.printf("Esta semana hemos ganado %d € en %s\n",ganancias[i],frutas[i]);
        }
        System.out.print(" ---  ---  ---  ---  ---  ---\n");
        
        
        int kilos2[][]={{10,20,30,15,25,7,13},{1,8,2,9,15,5,160}};
        String frutas2[]={"Zapote negro","blighia sapida"};
        int precios2[]={9,14};
        int ganancias2[]=new int[2];
        sumarFruta2(kilos2,precios2,ganancias2);
        for(int i=0;i<ganancias2.length; i++)
            System.out.printf("Esta semana hemos ganado %d € en %s\n",ganancias2[i],frutas2[i]);
        System.out.println();
    }
    
    public static int[] sumarFruta(int kg[][], int €[]){
        int gananciaspf[]= new int[2];
        for(int i=0;i<kg.length; i++){
            for(int j=0;j<kg[i].length; j++){
               gananciaspf[i]+=kg[i][j]*€[i];
            }
        }
        return gananciaspf;
    }
    
    public static void sumarFruta2(int kg[][],int €[], int dineroFruta[]){
        for(int i=0;i<kg.length; i++){
            for(int j=0;j<kg[i].length; j++){
               dineroFruta[i]+=kg[i][j]*€[i];
            }
        }
    }
}
