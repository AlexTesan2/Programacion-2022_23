
package primeros.dias;
public class VectorX2Xmesos1 {
     public static void main (String args[]){
     int datos[]={0,10,-20,30,-40,50,60};
     
     for(int i=0; i< datos.length; i++){
     
         if(datos[i]>0){
         datos[i] *=2;
         }else{      
         datos[i] *=-1;
         }
         System.out.printf(" %d ,",datos[i]);
     
     }
         System.out.println("\n");   
     }
}
//mostrar la media de loselementos del vector