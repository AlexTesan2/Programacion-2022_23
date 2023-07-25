package primeros.dias;
public class BucleAnidadoDesplazamD {
     public static void main (String args[]){
     
     int vect[]= {1,2,3,4,5,6,7,8};
     int aux;
         
     for(int i = 0; i< vect.length; i++){
        
        System.out.println(i+1+" vez");
        aux = vect[vect.length-1];
        
        for(int u= vect.length-1; u> 0;u--) {
            
            vect[u]= vect[u-1];
        }
        vect[0]= aux;
        for(int z=0; z< vect.length; z++){
        
            System.out.print( vect[z]+ ".");
        }
          System.out.println();//System.out.print("\n");
     }  
     }
}
