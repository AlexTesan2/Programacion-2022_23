
package vectoresdimensionales;
public class MetodoOrdenacionDirecta {
    public static void main (String args[]){ 
        int vector[]={25,73,2,81,16,4,33};
        int auxiliar;
        int posmin=0;
        
        for(int x=0;x<vector.length-1;x++){
            posmin=x;
            for(int i=x+1;i<vector.length;i++){
                if(vector[i]<vector[posmin]){
                    posmin=i;
                }
            }
            auxiliar=vector[x];
            vector[x]=vector[posmin];
            vector[posmin]=auxiliar;
        }
        
        for(int r=0;r<vector.length;r++){
        System.out.print(vector[r]+ " - ");
        }
    }
}
