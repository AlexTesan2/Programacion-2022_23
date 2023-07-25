//ordenar veztor de forma invesa
package primeros.dias;
public class VectorIntercambiarPrimeroUltimo {
     public static void main (String args[]){
     
     int datos[]={10,20,30,40,50,60};
     
     int veces= datos.length/2;
     int resultado;
     int y;
     
     /*for(int cont=0; cont < veces; cont++){
      resultado = datos.length - cont;
      y= cont;
      datos[cont]= resultado;
      datos[resultado]= y;
      System.out.println(datos[resultado]);
     
     }//excepcion error em la compilacion
     */int inter;
     for(int i=0; i > (datos.length/2); i++){
     
        inter= datos[i];
        datos[i] = datos[datos.length -i -1];
        datos[datos.length -i -1]= inter;
     }
     for(int i=0; i< datos.length; i++)
             System.out.printf("%d -", datos[i]);
     }//posittivos x 2 y negativos pasan a positivo
}
