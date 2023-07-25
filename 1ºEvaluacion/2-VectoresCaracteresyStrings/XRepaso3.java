//cambiar a mayus las aplabras cuya longitud sea mayor que tres
package vectorescaracteresystrings;
public class XRepaso3 {
    public static void main (String args[]){
        char frase[]={'e','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','l','a',' ','m','a','n','c','h','a',' '};
        
        int inicio=0;
        int fin=0;
        while(fin!=frase.length){
            fin++;
            if(frase[fin]==' '){
                if((fin-inicio)>3)
                    for (int i=inicio;i<fin; i++)
                        frase[i]=Character.toUpperCase(frase[i]);
                inicio=fin=fin+1;
            }
        }
        System.out.println(frase);
        
        char frase2[]={'e','n',' ','u','n',' ','l','u','g','a','r',' ','d','e',' ','l','a',' ','m','a','n','c','h','a',' '};
        char fraseFinal[]=new char[100];
        inicio=0;
        fin=0;
        while(fin!=frase2.length-1){
            fin++;
            if(frase[fin]==' '){
                if((fin-inicio)>3){
                    for (int i=inicio;i<=fin; i++){
                        fraseFinal[i]=Character.toUpperCase(frase2[i]);
                    }
                }else{
                    for (int i =inicio; i<=fin; i++) {
                        fraseFinal[i]=frase2[i];
                    }
                }
                inicio=fin+1;
            }
        }
        System.out.println(fraseFinal);
    }
}
//calccular el maximo comun divisor de dos num mediante el algoritmo de uclides con recursividad
//restar el num mas pequño del mas grande hasta qu los dos sean igales