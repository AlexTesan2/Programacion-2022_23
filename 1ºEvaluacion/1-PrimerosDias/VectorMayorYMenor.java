//Mayor y menor de un vector con su posicion en el vector
package primeros.dias;
public class VectorMayorYMenor {
 public static void main (String arc[]){
   int vector[]={7,16,-12,27,-20,30,-1}; 
   int maximo= vector[0];
   int minimo=vector[0];
   int posmax=0;
   int posmin=0;
   
   for(int cont=1;cont < vector.length; cont++){
       if(maximo < vector[cont] ){
           maximo = vector[cont];
           posmax = cont;
       }
       if( minimo > vector[cont]){
           minimo = vector[cont];
           posmin = cont; 
       }
   }
     System.out.printf("El mayor valor del vector es %d y se encuentra en la posición %d \n",maximo,posmax);
     System.out.printf("El nenor valor del vector es %d y su posición es %d\n",minimo,posmin);
 }   
}
