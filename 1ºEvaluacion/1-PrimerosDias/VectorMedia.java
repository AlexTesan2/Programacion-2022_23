
package primeros.dias;
public class VectorMedia {
    public static void main (String args[]){
    int resultado=0;
    int vect[]={1,2,35,4,5,66,7,89};
    for (int i=0;i<vect.length;i++){
       resultado+= vect[i];
    }  
    resultado/=vect.length;
    System.out.printf("La media es %d\n",resultado);//System.out.printf("La media es %.2f",resultado);
    }
}
