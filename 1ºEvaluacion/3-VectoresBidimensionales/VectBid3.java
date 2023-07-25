//multiplicar tablaa por vector, tabla[0]*vect[0], tabla[1]*vect[1]...
package vectoresdimensionales;
public class VectBid3 {
 public static void main (String args[]){
    int tabla[][]={{10,20,30,40},{40,50,60,70},{70,80,90}};
    int vector[]={2,4,6};
    for(int i=0; i<tabla.length; i++){
        for(int j=0;j<tabla[i].length;j++){
            tabla[i][j]*=vector[i];
            System.out.print(tabla[i][j]+"  ");
        }
        System.out.println();
    }
    
    
 }
}
