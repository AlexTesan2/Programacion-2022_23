
package vectoresdimensionales;
public class FuncionMultiplicoVector {
    public static void main (String args[]){
        int v[][]={{1,2,3,4},{5,6,7,8},{9,0,10,11}};
        int multiplicador=4;
        multiplico(multiplicador,v);
        for(int i=0;i< v.length;i++){
           for(int j=0;j<v[i].length;j++){
               System.out.print(v[i][j]+"  ");
           }
            System.out.println();
        }
    }
    
    public static void multiplico(int por,int [][] vect){
        for(int i=0;i< vect.length;i++){
           for(int j=0;j<vect[i].length;j++){
               vect[i][j]*=por;
           }
        }
    
    }
}
