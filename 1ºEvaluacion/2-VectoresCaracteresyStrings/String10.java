//80: frase formada por pal separadas por espacios, cada pal se debe guardar en un elemento de un vector, despues ordenar el vector 
package vectorescaracteresystrings;
public class String10 {
    public static void main(String[] args) {
        String frase="5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres ";
        int inicio=0, fin=frase.indexOf(' '), cont=0;
        
        while(fin!=-1){
            cont++;
            fin=frase.indexOf(' ',fin+1);
        }
        String vector[]=new String[cont];
        
        inicio=0;
        fin=frase.indexOf(' ');
        
        
        for (int z=0;z<vector.length; z++) {  //while(fin !=-1)
            fin=frase.indexOf(" ", inicio);//busco espacio desde "paro"
            vector[z]=frase.substring(inicio, fin+1);//guardo frase desde paro ht posicion
            inicio=fin=fin+1;
        }
        
        
        String intercambio;
        for (int x = 0; x < vector.length; x++)
            for (int i = vector.length - 1; i > x; i--) 
                if (vector[i].compareTo(vector[i-1])<0) {
                    intercambio = vector[i];
                    vector[i] = vector[i - 1];
                    vector[i - 1] = intercambio;
                }                
            
        frase="";
        for (int i = 0; i <vector.length; i++) 
            frase=frase.concat(vector[i]);
        System.out.println(frase);   
    }
}
/*int repartidor=0;
        while(fin!=-1){
            vector[repartidor]=frase.substring(inicio,fin+1);
            repartidor++;
            inicio=fin=fin+1;
        }*/