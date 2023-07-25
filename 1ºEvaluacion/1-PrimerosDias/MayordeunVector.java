
package primeros.dias;
public class MayordeunVector {
    public static void main (String args[]){
        int datos[] = {-17,-15,-33,-11,-88} ;
        int  mayor= datos[0];
        int posmax=0;
        for(int i=1; i< datos.length; i++ )
            if(datos[i]>mayor){
                mayor= datos[i];
                posmax= i;
            }   
        System.out.println("el numero mayor es "+ mayor + "  y su posición es  "+ posmax); 
    }
}
