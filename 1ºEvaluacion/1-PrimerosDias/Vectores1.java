
package primeros.dias;
public class Vectores1 {  //Vector plural ----- variable singular
  public static void main (String arc[]){//Todas las variables de un vector son del mismo tipo 
  int datos[]={4,17,23,35};//Vector: estructura de datos usada cuando hay q declarar mucas variables
  
    for(int lector=0; lector< datos.length ;lector ++){
        System.out.printf("Variable %d = %d \n",lector,datos[lector]);
    }
  
    System.out.println("\n");
    //Ahora escribiremo sel vector multiplicado por dos
    for(int multiplicador=0; multiplicador < datos.length; multiplicador++){
        datos[multiplicador]*=2;
     }
    for(int cuenta=0; cuenta<datos.length; cuenta++ ){
        System.out.printf("[%d] = %d.  ",cuenta+1,datos[cuenta]);
    }
      System.out.print("\n");
  } 
}
