//Decir que numero es mayor con if anidados
package primeros.dias;
public class Condicional1 {
    public static void main(String[] args) {
    int x, y ;
    x=18;
    y=23;
    
    if (x==y){            // == comparar soi dos elementos son iguales ,  != distinto ,   ! negación
        System.out.println("Los dos numeros tienen el mismo valor" +x); // No hace falta poner llaves si solo hay 1 instrucc en if
        
    }else if(x >y){        //else es sino, no puede aparecer sin el if
        System.out.println("El mayor es "+x);
    
    }else{
        System.out.println("El mayor es "+ y);
    }
  }
    
    
}
