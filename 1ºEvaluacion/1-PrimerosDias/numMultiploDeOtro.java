//21 es multiplo de 3
package primeros.dias;
public class numMultiploDeOtro {
 public static void main (String arc[]){
 
     int x =3;
     int y =21;
     int z;
     
     if(x<y){
        z= x;
        x = y;
        y = z;
     }
     if((x%y)==0){
         System.out.println(x +" es multiplo de "+ y);
     }else{
         System.out.println("NO son multiplos");
     }
     
 
 
 }
}
