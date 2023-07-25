
package vectoresdimensionales;
public class ordenoVector {
    public static void main (String args[]){
        int vect[]={2,1,6,9,32,4,5,0};
        int[] ordeno=teLoOrdeno(vect);
        for (int x=0;x< ordeno.length;x++ )
            System.out.print(ordeno[x]+" " );
        System.out.println("\n----------------------------------------\n");       
        
        int vect2[]={24,15,6,9,532,4,35,90};
        ordenar(vect2);
        
    }
    
    public static int[] teLoOrdeno(int vector[]){
        int intercambio;
        for(int x=0;x< vector.length; x++)
        for( int i= vector.length-1;i>x; i--){
            if(vector[i]< vector[i-1]){
                intercambio= vector[i];
                vector[i]=vector[i-1];
                vector[i-1]=intercambio;
            }  
        }
        return  vector;  
    }
    
    public static void ordenar(int v[]){
        int intercambio2;
        for(int x=0;x< v.length; x++)
        for( int i= v.length-1;i>x; i--){
            if(v[i]< v[i-1]){
                intercambio2= v[i];
                v[i]=v[i-1];
                v[i-1]=intercambio2;
            }  
        }
        for (int x=0;x< v.length;x++ )
            System.out.print(v[x]+" " );
    }
}