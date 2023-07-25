//que dia se vendieron mas entradas y cual menos entre todas las semanas
package vectoresdimensionales;
public class Cine2 {
   public static void main (String args[]){
    int salas[][] ={{12,34,71,23,1,45,21},{1,2,3,4,5,6,7},{45,32,12,45,67,98,5},{23,56,43,23,223,12,54},{12,34,23,12,56,87,90}};
    String dias[]={"lunes","martes", "miercoles","jueves","viernes","sabado","domingo"};
    int posmax=0;
    int auxmax=0;
    int posmin=1000;
    int auxmin=0;
    int vect[]={0,0,0,0,0,0,0};
    for(int i=0;i<dias.length;i++){
        for(int j=0; j<salas.length;j++){
            vect[i]+=salas[j][i];
        }
    }  
    for(int i=0;i<vect.length;i++){
        if(posmax<vect[i]){
        posmax=vect[i];
        auxmax=i;
        }
        if(posmin>vect[i]){
            posmin=vect[i];
            auxmin=i;
            }
        }
    
    
    System.out.println("El dia que mas se vende es el "+ dias[auxmax]+" con "+ posmax +" entradas");
    System.out.println("El dia que menos se vende es el "+ dias[auxmin]+" con "+ posmin +" entradas");
   }
} 

