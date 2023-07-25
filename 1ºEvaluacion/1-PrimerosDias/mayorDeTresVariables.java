//¿Cual es el mayor de las tres variables?
package primeros.dias;
public class mayorDeTresVariables {
public static void main (String arc[]){
    int x=6;
    int y= 8;
    int z = 20;
    
    if (x>y){
        if (x>z){
            System.out.println("El mayor es "+x);
        }else{
            System.out.println("El mayor es "+ z);
        }
    }else if(y>z){
        System.out.println("El mayor es "+ y);
    }else{
        System.out.println("El mayor es "+ z);
    }
 


}
    
}
