
package primeros.dias;
public class DivisiónMedianteRestas {
  public static void main (String arc[]){
  
      int dividendo =12;
      int divisor=2;
      int resultado=0;
      
      for(int num= dividendo; num >= divisor; num-=divisor){
      
          resultado ++;
      }
  
  
      System.out.println(dividendo+ "/"+divisor +"="+resultado);
      
  }  
}