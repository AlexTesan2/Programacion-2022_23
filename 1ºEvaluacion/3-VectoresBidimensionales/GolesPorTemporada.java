
package vectoresdimensionales;
public class GolesPorTemporada {
    public static void main (String args[]){
        int goles[][]={{18,19,22,33,8},{22,24,19,18,10},{19,20,31,42,50},{13,14,15,16,17}};
        String temporadas[]={"21/22","20/21", "19/20", "18/19"};
        int acum=0;
        for(int i=0;i< goles.length;i++){
            acum=0;
            for(int j=0; j<goles[i].length;j++){
                acum+=goles[i][j];
            }
            System.out.println("En la temporada "+temporadas[i]+" se han metido "+ acum+ " goles");
        }
    }
}
