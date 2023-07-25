//multiplicación por sumas de 7x5= 7+7+7+7+7
package primeros.dias;
public class MultiplicaciónPorSumas { 
    public static void main (String arc[]){
        int num=7;
        int resultado=0;
        for(int multiplicador=5; multiplicador >0; multiplicador--)
            resultado += num;
            System.out.println("El resultado es "+ resultado);
    }   
}

