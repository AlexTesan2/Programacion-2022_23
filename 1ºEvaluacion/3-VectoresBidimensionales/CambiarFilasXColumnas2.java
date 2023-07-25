
package vectoresdimensionales;
public class CambiarFilasXColumnas2 {
    public static void main (String args[]){
        int vect[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int aux=0;
        for(int i=0;i<vect.length;i++){
            for(int j=0;j<vect[i].length;j++){
                System.out.print(vect[j][i]+"   ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<vect.length;i++){
            for(int j=i;j<vect[i].length;j++){
                aux= vect[i][j];
                vect[i][j]=vect[j][i];
                vect[j][i]=aux;
            }
        }
        for(int i=0;i<vect.length;i++){
            for(int j=0;j<vect[i].length;j++){
                System.out.print(vect[i][j]+"  "); 
            }
            System.out.println();
        }
    }
}