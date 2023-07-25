//94  trim estrecon mas nacimientos/mes con mas bajas(mueres y taslados)/ 
// 3-cuantos nuevos(nacim y trasladp) y bajas totales / 
package vectorescaracteresystrings;
public class WRecursividad09 {
    public static void main (String args[]){
        String[] movimientos={"nacimientos","defunciones","translados","nuevos asentamientos"};
        int trimestres[]={0,0,0,0};
        String meses[]= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        int[][]movPoblacion={{1,2,0,3},{1,3,5,7},{1,4,5,9},{1,4,9,1},{6,8,12,0},{7,3,1,2},{1,4,9,1},{7,2,6,2},{2,7,12,5},{12,5,7,9},{3,0,0,1},{1,2,3,4}};
        
        //1º
        for (int i = 0; i < movPoblacion.length; i++)
            trimestres[i/3]+=movPoblacion[i][0];
        int posmax=0;
        for (int i=0;i<trimestres.length;i++) 
            if(trimestres[i]>trimestres[posmax])
                posmax=i;
        System.out.println("El trimestre con mas nacimientos es el "+ (posmax+1) );
        
        //2º
        posmax=0;
        for (int i = 0; i < movPoblacion.length; i++)
            if((movPoblacion[i][1]+movPoblacion[i][2])>(movPoblacion[posmax][1]+movPoblacion[posmax][2]))
                posmax=i;
        System.out.println("El mes con mas baja se ha tenido es el "+ meses[posmax]);
            
        //3º
        int cont=0;
        int cont2=0;
        for (int i = 0; i <movPoblacion.length; i++) {
            cont+=(movPoblacion[i][0]+movPoblacion[i][3]);
            cont2+=(movPoblacion[i][1]+movPoblacion[i][2]);
        }
        System.out.println("nuevos: " + cont);
        System.out.println("bajas: "+cont2);
                
    }
}
