//ordena el vector usando un while                       ---(inserccion directa)
// && And    || Or
package vectoresdimensionales;
public class MetodoApuntadores {
    public static void main (String args[]){ 
        int vector[]={25,2,73,81,8,16,4,33};
        int auxiliar;
        int i;
        for(int x=1; x<vector.length;x++){
            i=x;
            while((i>0)&&(vector[i]< vector[i-1])){//con el and  hay que tener en cuenta el orden
                auxiliar=vector[i];
                vector[i]= vector[i-1];
                vector[i-1]=auxiliar;
                i--;
            }
        }
        for(int x=0;x<vector.length;x++)
            System.out.print(vector[x]+"  ");
        System.out.println();
    }
}