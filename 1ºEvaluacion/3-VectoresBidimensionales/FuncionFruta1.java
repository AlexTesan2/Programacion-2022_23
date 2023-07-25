
package vectoresdimensionales;
public class FuncionFruta1 {
    public static void main (String args[]){
        int kilos[][]={{5,6,9,23,7,14,2},{16,8,33,4,15,21,0}};
        int precios[]={6,7};
        calculo(kilos,precios);
        for(int i=0;i<kilos.length; i++){
            for(int j=0;j<kilos[i].length; j++){
                System.out.print(kilos[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void calculo(int kg[][], int €[]){
        for(int i=0;i<kg.length; i++){
            for(int j=0;j<kg[i].length; j++){
                kg[i][j]*=€[i];
            }
        }
    }
}
