//nombres[i].compareTo(nombres[i-1])
package vectorescaracteresystrings;
public class String02 {
    public static void main (String args[]){
        String nombres[]={"Pepe","Juan","Maria","Antonia","Luisa","Alfredo","Fredo","Monse","Praga","Jaime"};
        String intercambio;
    
        for (int x = 0; x < nombres.length; x++) 
            for (int i = nombres.length-1; i>x; i--)
                if (nombres[i].compareTo(nombres[i-1])<0) {
                    intercambio = nombres[i];
                    nombres[i] = nombres[i - 1];
                    nombres[i - 1] = intercambio;
                }                
        for(int r=0;r<nombres.length;r++){
        System.out.print(nombres[r]+ " - ");
    }
    }
}
