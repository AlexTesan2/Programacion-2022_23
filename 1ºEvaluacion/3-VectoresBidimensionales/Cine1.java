//que dia se vendieron mas entradas y cual menos
package vectoresdimensionales;
public class Cine1 {
   public static void main (String args[]){
    int salas[][] ={{12,34,71,23,15,45,21},//se guarda en cada sala las ventas por dia
        {1,2,3,4,5,6,7},
        {45,32,12,45,67,98,5},
        {23,56,43,23,223,12,54},
        {16,34,23,12,56,87,90}};
    String dias[]={"lunes","martes", "miercoles","jueves","viernes","sabado","domingo"};
    int posmax=0;
    int auxmax=0;
    int posmin=1000;
    int auxmin=0;
    for(int i=0;i<salas.length;i++){
        for(int j=0; j<salas[i].length;j++){
            if(posmax<salas[i][j]){
                posmax=salas[i][j];
                auxmax=j;
            }
            if(posmin>salas[i][j]){
                posmin=salas[i][j];
                auxmin=j;
            }
        }
    }
    System.out.println("El dia que mas se ha vendido es el "+ dias[auxmax]+" con "+ posmax +" entradas");
    System.out.println("El dia que menos se ha vendido es el "+ dias[auxmin]+" con "+ posmin +" entradas");
   } 
}
