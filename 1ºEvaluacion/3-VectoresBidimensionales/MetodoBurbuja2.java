package vectoresdimensionales;
public class MetodoBurbuja2 {
   public static void main (String args[]){ 
    int vector[]={25,2,73,81,16,4,33};
    int intercambio=0;
    
    for(int x=0;x< vector.length; x++)
        for( int i= vector.length-1;i>x; i--){
            if(vector[i]< vector[i-1]){
                intercambio= vector[i];
                vector[i]=vector[i-1];
                vector[i-1]=intercambio;
            }  
        }
    for(int r=0;r<vector.length;r++){
        System.out.print(vector[r]+ " - ");
    }
    System.out.println();
   
   }
}
