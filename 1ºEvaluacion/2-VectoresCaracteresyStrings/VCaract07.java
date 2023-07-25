//cuantas veces hay un grupo de tres n
package vectorescaracteresystrings;
public class VCaract07 {
    public static void main (String args[]){
        char cadena[]={'E','n','n','n','n',' ','n','n','n','n','r',' ',' ','n','n','n','L','a'};
        char subcadena[] ={'n','n','n'};
        int iteraciones2= veces(cadena, subcadena);
        System.out.println("La subcadena aparece un total de "+iteraciones2+" veces");
    }
    public static int veces(char[] frase1, char[] subc){
        int veces=0;
        int cont;
        for (int i = 0; i < frase1.length; i++) {
            if(frase1[i]==subc[0]){
                cont=1;
                for (int j = 1; j < subc.length; j++){
                    if(frase1[i+j]==subc[j])
                        cont++;
                    if(cont==subc.length)
                        veces++;
                } 
            }
            
        }
        return veces;
    }
}
/*public static int veces2(char[] caden, char[] subcaden){
        int contadorFinal2=0;
        int j=0;
        for(int i=0; i< caden.length; i++){
            if(caden[i]==subcaden[0]){
                j=1;
                while(( j < subcaden.length) && (subcaden[j]== caden[i+j]))
                    j++;
                if(j==subcaden.length)
                    contadorFinal2 ++;
            }
        }
        return contadorFinal2;
    }*/