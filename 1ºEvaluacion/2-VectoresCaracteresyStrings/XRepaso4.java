//calccular el maximo comun divisor de dos num mediante el algoritmo de euclides con recursividad
//restar el num mas pequño del mas grande hasta qu los dos sean igales
package vectorescaracteresystrings;
public class XRepaso4 {
    public static void main(String[] args) {
        System.out.println("El m.c.d. de 8 y 42 es "+ euclides(8,42));
        
        System.out.println("El m.c.d. de 8 y 42 es "+ euclides2(8,42));//con recursividad
    }
    //los metodos se ponen en minuscua en java
    public static int euclides(int x, int y) {
        while(x!=y)
            if(x>y)
                x-=y;
            else
                y-=x;
        return x;
    }
    
    
    public static int euclides2 (int x,int y) {
        if(x==y)
            return x;
        else if( x>y)
            return euclides2(x-y,y);
        else
            return euclides2(x,y-x);
    }
}
