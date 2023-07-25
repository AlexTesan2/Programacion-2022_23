
package vectoresdimensionales;
public class MediaGoles {
    public static void main (String args[]){
        int goles[][]={{18,19,22,33,8},{22,24,19,18,10},{19,20,31,42,50},{13,14,15,16,17}};
        String futbolistas[]={"Mesi","Ronaldo","Halland","Mdappe","Vinicius"};
        int acum;
        for(int i=0; i<goles.length;i++){
            acum=0;
            for(int j=0;j<goles[i].length; j++){
                acum+=goles[i][j];
            }
            System.out.printf("%s ha metido %d y su media ",futbolistas[i],acum );
            System.out.printf(" es de %.1f\n",acum/goles[0].length);
        }
    }
}/*
String temporadas[]={"21/22", 20/21, 19/20, 18/19}
sacar cuantos goles se han metido por temporada

*/
