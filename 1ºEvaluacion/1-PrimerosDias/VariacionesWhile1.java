
package primeros.dias;
public class VariacionesWhile1 {
   public static void main (String arc[]){  
    
     int numgr=7;
     int numpeq=3;
     int resultado=1;  
     int comodin=numgr;
     
     while(comodin>numpeq){
     resultado*=comodin;
     comodin--;
     }
       System.out.printf("Variaciones de %d elementos tomados de %d en %d es igual a %d\n", numgr,numpeq,numpeq,resultado);
             //  \n pasar a la siguiente linea, secuencia de escape
   }  
}
