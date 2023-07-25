
package primeros.dias;
public class TablasMultiplicar {
    public static void main (String args[]){
        int resultado=0;
        for(int x=1;x<=10;x++){
            System.out.println(x+"ª vez");
            for(int y=1; y<=10;y++){
                resultado= x*y;
                System.out.printf("%d x %d = %d    ",x,y,resultado);
            }
            System.out.println();
        }
 
    }
}