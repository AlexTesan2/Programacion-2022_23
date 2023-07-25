// en una func cambiar la 'n' por XYZ sobre el vecor original, no usar vect auxiliar
package vectorescaracteresystrings;
public class VCaract06 {
    public static void main (String args[]){
        char frase[]={'E','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','L','a',' ','M','a','n','c','h','a',' '};
        char sustituir = 'n';
        char sustituto[]={'X','Y','Z'};
        char frase2[]= new char [100];
        for(int i=0;i<frase.length;i++)
            frase2[i]=frase[i];
        cambio(frase2,sustituir, sustituto);
        System.out.println(frase2);
    }
    public static void cambio(char frase[], char sustituir, char sustituto[]){
        for(int i=0;i<frase.length;i++){
            if(frase[i]==sustituir){
                frase[i]=sustituto[0];
                for(int z=1;z<sustituto.length;z++){
                    for(int p=frase.length-1;p>i+1;p--)
                        frase[p]=frase[p-1];
                    i++;
                    frase[i]=sustituto[z];
                }
            }
        }
    }
}
