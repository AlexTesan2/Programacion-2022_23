//calcula el factorial de 8 = 8x7x6x5x4x3x2x1
package primeros.dias;
public class bucle2 {
    public static void main (String arc[]){
        int num=8;
        int factorial=1;
        for(int multiplicador=1; multiplicador<= num; multiplicador++){
            factorial *= multiplicador;          //factorial= factorial * multiplicador;   += / -= / /=
        }
        System.out.println("El factorial de "+num +"es "+ factorial);
    }    
}
