//sustituir "en" por "XXXX"  no funciona
package vectorescaracteresystrings;
public class VCaract12 {
    public static void main(String[] args) {
        char frase[]={'e','n',' ','u','n',' ','l','u','g','a','r',' ','e','n',' ','L','a',' ','M','a','n','c','h','a',' ','e','n',' '};
        char cad[]=new char[150];
        char subcad[]={'e','n',' '};
        char subcad2[]={'X','Y','Z','P'};
        int inicio=0;
        int fin=0;
        int cont;
        for (int i = 0; i < frase.length; i++)
            cad[i]=frase[i];
        for (int i = 0; i <cad.length; i++) {
            if(cad[i]==subcad[0]){
                cont=1;
                while((cont<subcad.length)&&(subcad[cont]==cad[i+cont]))
                    cont++;
                if(cont==subcad.length){
                    for (int j = 0; j < subcad2.length; j++) {
                        cad[i]=subcad2[j];
                        for (int k = cad.length-1; k >i ; k--) {
                            cad[k]=cad[k-1];
                        }
                    }
                }
            }
        }
        System.out.println(cad);
    }
}
