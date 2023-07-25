//lo mismo q el anterior pero los datos de venta se guardaran en una tabla nueva
package vectoresdimensionales;
public class FuncionFruta2 {
    public static void main (String args[]){
        int kilos[][]={{5,6,9,23,7,14,2},{16,8,33,4,15,21,0}};
        int precios[]={6,7};
       
        
        int vendoMucho[][]= new int[2][7];
        ventas(kilos, precios, vendoMucho);
        for(int i=0;i<vendoMucho.length; i++){
            for(int j=0;j<vendoMucho[i].length; j++){
                System.out.print(vendoMucho[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------");
        
        
        int vendomucho2[][]=ventas2(kilos, precios);
        for(int i=0;i<vendomucho2.length; i++){
            for(int j=0;j<vendomucho2[i].length; j++)
                System.out.print(vendomucho2[i][j]+"-");           
            System.out.println();
        }
    }
    
    
    public static void ventas(int kg[][],int €[], int vf[][]){
        for(int i=0;i<kg.length; i++){
            for(int j=0;j<kg[i].length; j++){
                vf[i][j]=kg[i][j]*€[i];
            }
        }
    }

    public static int[][]ventas2(int kg2[][], int €2 []){
        int retornable[][]=new int [kg2.length][kg2[0].length];
        for(int i=0;i<kg2.length; i++){
            for(int j=0;j<kg2[i].length; j++){
                retornable[i][j]=kg2[i][j]*€2[i];
            }
        }
        return retornable;
    }
}
