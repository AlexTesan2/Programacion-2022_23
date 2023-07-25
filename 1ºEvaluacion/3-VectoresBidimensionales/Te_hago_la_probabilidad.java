
package vectoresdimensionales;
public class Te_hago_la_probabilidad {
    public static void main (String args[]){
        int x=5;
        int y=3;
        int resultado= 0;
        resultado=operador(x)/operador(x-y);
        System.out.print(x+"!/"+y+"!="+resultado+"\n");
    }
    public static int operador(int a){
        int acum=1;
        for(int i=1;i<=a;i++){
            acum*=i;
        }
    return acum;
    }
}