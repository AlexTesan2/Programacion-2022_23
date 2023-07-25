//mostrar por pantalla de cada producto las ganancas obtenidas y el dinero total
package vectoresdimensionales;
public class VectBid5KilosPrecios {
  public static void main (String args[]){
    int tabla[][]={{10,20,30,40,50},{50,60,70,80,90},{90,101,110,120,130}};
    String productos[]={"Naranjas","Peras","Manzanas"};
    double precios[]={1.5,2,0.8};
    int vect[]={0,0,0};
    int total= 0;
    double totaldi=0;
    for(int i=0;i<tabla.length;i++){
        for(int j=0; j<tabla[i].length;j++){
            vect[i]+=tabla[i][j]; 
        }
        total+=vect[i];
        totaldi+= vect[i]*precios[i];
        System.out.printf("Esta semana he vendido %d Kg de %s ganando %.2f €\n",vect[i],productos[i], (vect[i]*precios[i]));
    }
      System.out.println("Esta semana hemos vendido un total de "+  total +" Kg ganando "+totaldi+" €");
  }
}
