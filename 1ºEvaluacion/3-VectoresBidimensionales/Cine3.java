//Que pelicula ha vendido mas?
package vectoresdimensionales;
public class Cine3 {
    public static void main (String args[]){
        int salas[][] ={ {1,2,3,4,5,6,7},
            {12,34,71,23,1,45,21},
            {45,32,120,45,67,98,50},
            {23,56,43,73,223,12,54}};
        String peliculas[]={"Avatar","Titanic","El señor de los anillos","Piratas del caribe"};
        int acum[]={0,0,0,0};
        int mayor=0;
        int mejorPeli=0;

        for (int i=0;i<salas.length;i++)
            for(int j=0;j<salas[i].length;j++ )
                acum[i]+=salas[i][j];
        for (int i=0;i<acum.length;i++){
            if(mayor<acum[i]){
                mayor=acum[i];
                mejorPeli= i;
            }  
        }
        System.out.printf("La pelicula que mas ha vendido esta semana es %s con %d compras\n ", peliculas[mejorPeli],mayor);

   }
}
