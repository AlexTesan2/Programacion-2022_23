//cambiar filas por columnas
package vectoresdimensionales;
public class CambiarFilasXColumnas {
public static void main (String args[]){
    
int vect[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
int tabla[][]=new int [4][4]; //reservo memoria para 16 enteros

for(int i=0; i<vect.length; i++){
    for(int j=0;j<vect[i].length;j++)
        tabla[j][i]= vect[i][j];
}
for(int i=0; i<tabla.length; i++){
    for(int j=0;j<tabla[i].length;j++){
        System.out.print(tabla[i][j]+"  ");
    }
    System.out.print("\n");
}
}        
}
//el mismo pero sin utilizar tabla auxiliar
