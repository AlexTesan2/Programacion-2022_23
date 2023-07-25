//¿Cuantos Kg de cada fruta he vendido esta semana?
package vectoresdimensionales;
public class VectBid4KilosFruta {
    public static void main (String args[]){
        int tabla[][]={{10,20,30,40,50},{50,60,70,80,90},{90,100,110,120,130}};
        String productos[]={"Naranjas","Peras","Manzanas"}; 
        int acumulador;
        for(int i=0;i<tabla.length;i++){
            acumulador=0;
            for(int j=0; j<tabla[i].length;j++){
               acumulador+=tabla[i][j]; 
            }
            System.out.printf("Esta semana he vendido %d Kg de %s\n",acumulador,productos[i]);
        }
    }
}
