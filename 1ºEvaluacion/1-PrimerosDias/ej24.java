// multplicar datos x cada uno de los multiplos
package primeros.dias;
public class ej24 {
 public static void main (String args[]){
     
     int datos[]= {10,20,30,40,50,60};
     int multiplos[]={3,5,7};
     int resultado=0;
     
     for(int multiplicador=0; multiplicador < multiplos.length;multiplicador++){
        for(int g=0; g<datos.length; g++){
            resultado= datos[g]*multiplos[multiplicador];
            System.out.print(resultado +"-");
     }
     System.out.print("|| \n");
 }   
}
}