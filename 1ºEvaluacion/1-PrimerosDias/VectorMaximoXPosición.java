
package primeros.dias;
public class VectorMaximoXPosición {

     public static void main (String args[]){
    
        int datos[] = {-17,-15,-33,-11,-88} ;
        int  mayor= datos[0];
    
        
        for(int i=1; i< datos.length; i++ ){
            if(datos[i]>mayor){                                                                       
                mayor= datos[i];
            }
        }    
         System.out.println("el numero mayor es "+ mayor );
     
         int posmax=0;
        for(int i=1; i< datos.length; i++ ){
          if (datos[i]>datos[posmax]){
            posmax=i;
            }
        } 
        System.out.println("El numero mayor es "+ datos[posmax]);
     }
}

