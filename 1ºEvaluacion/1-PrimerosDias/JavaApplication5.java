//UN numero es multiplo de otro
package javaapplication5;

public class JavaApplication5 {

  
    public static void main(String[] args) {
        int x;
        int y;
        int z;
        x=3;
        y=21;
        
        if (x<y){
            z=y;
            y=x;
            x=z;
            }
        if ((x % y) ==0){
            System.out.println(x +"  es multiplo de " +y);
           }else{
             System.out.println("No son multiplos");
           }
        
        
    }
    
}
