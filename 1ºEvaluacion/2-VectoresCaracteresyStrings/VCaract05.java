// en una func cambiar la 'n' por XYZ , crear cadena en la funcion 
package vectorescaracteresystrings;
public class VCaract05 {
    public static void main (String args[]){
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        char sustituir = 'n';
        char sustituto[]={'X','Y','Z'};
        char frasefinal[]=sustituyendo(frase, sustituir, sustituto);
        System.out.println(frasefinal);
    }
    public static char[] sustituyendo(char[]frase,char sustituir,char[]sustituto){
        char fraseFinal[]= new char[100];
        for(int i=0,j=0; i<frase.length;i++,j++){
            if(frase[i]==sustituir){
                for(int u=0;u<sustituto.length;u++){
                    fraseFinal[j]=sustituto[u];
                    j++;
                }
            }else
                fraseFinal[j]=frase[i];                      
        }
        return fraseFinal;
    }
}