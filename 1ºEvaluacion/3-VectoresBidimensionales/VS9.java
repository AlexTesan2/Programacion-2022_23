//80: frase formada por pal separadas por espacios cada pal se debe guardar en unelem de un vector, despues ordenar el vector 
package vectoresdimensionales;
public class VS9 {
    public static void main (String args[]){
        String frase="5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres ";
        String vector[];//String vector[]=new String [6];
        int paro=0;
        int posicion;
        String intercambio;
        int cont=0;
        int pos=frase.indexOf(" ");
        
        while(pos != -1){
            cont++;
            pos=frase.indexOf(" ",pos+1);
        }
        vector=new String[cont];
        
        for (int z=0;z<vector.length; z++) {  //while(fin !=-1)
            posicion=frase.indexOf(" ", paro);//busco espacio desde "paro"
            vector[z]=frase.substring(paro, posicion+1);//guardo frase desde paro ht posicion
            paro=posicion=posicion+1;
        }
        
        for(int i=0;i< vector.length; i++)
        for( int j= vector.length-1;j>i; j--)
            if(vector[j].compareTo(vector[j-1])<0){//comparo mayores y menores por burbuja
                intercambio= vector[j];
                vector[j]=vector[j-1];
                vector[j-1]=intercambio;
            }
        
        frase="";
        for(int u=0;u<vector.length;u++)
            frase=frase.concat(vector[u]);
        System.out.println(frase);
        
    }
}
