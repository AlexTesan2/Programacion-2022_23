//mostrar por pantalla el nombre de la peli que consiguio mayor numero de espectadores en un dia y que dia ocurrio y lo mismoo con el que menos
package vectoresdimensionales;
public class Cine4 {
    public static void main (String args[]){
    int salas[][] ={ {1,2,3,4,5,6,7},
        {12,34,71,23,1,45,21},
        {45,32,120,45,67,98,50},
        {23,56,43,73,223,12,54}};
    String peliculas[]={"Avatar","Titanic","El señor de los anillos","Piratas del caribe"};
    String dias[]={"lunes","martes", "miercoles","jueves","viernes","sabado","domingo"};
    int mayor=0;
    int menor =1110;
    int mayorDia=0;
    int menorDia=0;
    int mayorPeli=0;
    int menorPeli=0;
    
    for (int i=0;i<salas.length;i++){
        for(int j=0;j<salas[i].length;j++ ){
           if(mayor<salas[i][j]){
               mayor=salas[i][j];
               mayorDia=j;
               mayorPeli=i;
           }
           if(menor>salas[i][j]){
               menor=salas[i][j];
               menorDia=j;
               menorPeli=i;
           }
        }
    }
    System.out.printf("La pelicula mas exitosa es %s habiendo vendido %d entradas un %s \n",peliculas[mayorPeli],mayor,dias[mayorDia]);
    System.out.printf("La pelicula menos exitosa es %s habiendo vendido %d entradas un %s \n ",peliculas[menorPeli],menor,dias[menorDia]);
}
    
}