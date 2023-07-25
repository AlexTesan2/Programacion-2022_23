//escribir y presentar un vector bidimensional
package vectoresdimensionales;
public class VecBid1 {
    public static void main (String args[]){
        int vectorBidimensional [][]={{1,2,3},{4,5,6},{7,8,9,10,111}};
        for(int i=0;i<vectorBidimensional.length;i++){
            for(int j=0; j<vectorBidimensional[i].length;j++){
                System.out.print(vectorBidimensional[i][j]+" ");
            }
            System.out.println();
        }
    }
}
