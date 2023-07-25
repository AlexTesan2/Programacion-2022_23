/*
        1  2  3  4              4  2  3  1
        5  6  7  8              5  7  6  8
        9  10 11 12     -->     9  11 10 12
        13 14 15 16             16 14 15 13     ejrecicio 38
*/
package vectoresdimensionales;
public class CmbiarMatriz {
    public static void main (String args[]){
        int vect[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int b=3;
        int aux=0;
        for(int i=0;i< vect.length; i++){
            aux=vect[i][i]; 
            vect[i][i]=vect[i][b];
            vect[i][b]=aux;
            b--;
        }
        for(int i=0;i<vect.length;i++){
            for(int j=0;j<vect[i].length;j++){
                System.out.print(vect[i][j]+"  ");
            } 
            System.out.println();
        }
    }   
}
