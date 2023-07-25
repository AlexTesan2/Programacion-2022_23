// vector 4x3  positivos->se duplican/negativos->positivos 
package vectoresdimensionales;
public class VectBid2 {
    public static void main (String args[]){
        int vect[][]={{1,-2,3},{-6,-7,-8},{12,-1,7},{45,6,-89}};
        for(int i=0;i<vect.length; i++){
            for(int j=0; j<vect[i].length;j++){
                if(vect[i][j]>0){
                    vect[i][j]*=2;
                }else{
                    vect[i][j]*=-1;
                }
                System.out.print(vect[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
