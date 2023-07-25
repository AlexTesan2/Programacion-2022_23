
package javaapplication2;


public class JavaApplication2 {

    //if anidados
    public static void main(String[] args) {

        int x;
        int y;
        x=18;
        y=18;
        
        if( x == y){
            System.out.println("Los dos numeros tienen el mismo valor: "+y);  
        }else if(x > y ){
            System.out.println("El mayor es "+ x);
        }else if (x<y){
            System.out.println("El mayor es "+ y);
        }
    }     
}
//Si solo se da una instruccion en el if, no hace falta poner llaves