//burbuja por mi
package vectoresdimensionales;
public class MetodoBurbuja {
    public static void main (String args[]){
        int vector[]={25,2,73,81,16,4,33};
        int apuntador1=0;
        int apuntador2=0;
        int auxiliar=0;
        
        for(int x=0; x<vector.length-1;x++){
            for(int i=vector.length-1;i>0;i--){
                apuntador1= i;
                apuntador2= apuntador1-1;
                if(vector[apuntador1]<vector[apuntador2]){
                    auxiliar=vector[apuntador1];
                    vector[apuntador1]=vector[apuntador2];
                    vector[apuntador2]=auxiliar;
                }
            }    
        }
        for(int x=0;x<vector.length;x++){
            System.out.print(vector[x]+" ");
        }
        System.out.println();
    }
    
}
