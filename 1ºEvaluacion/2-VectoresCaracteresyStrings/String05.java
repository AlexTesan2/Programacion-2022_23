//index of --> le pasas un string busca una subcad dentro de una cad , si la encuentra te debuelve la posicion en la que la ha encontrado o devuelve -1 si no aparece.
//empezando a buscar a partir de la posicion del segundo parametro
package vectorescaracteresystrings;
public class String05 {
    public static void main(String[] args) {
        String frase="En un lugar de la Mancha";
        System.out.println("la subcadena 'de' aparece en la posicion "+ frase.indexOf("de"));
        
        //num de veces que aparece
        frase="En un lugar de la Mancha un   un un   un   un un   iun lugar ";
        String pal ="lugar";
        int cont=0;
        for (int i = 0; i <frase.length(); i++) {
            if(frase.indexOf(pal,i)!=-1){
                cont++;
                i=frase.indexOf(pal,i);
            }   
        }
        System.out.println("la palabra 'lugar' aparece " +cont +" veces");
        
        
        String palabra="un";
        int pos=frase.indexOf(pal);
        int contador=0;
        while(pos!= -1){
            contador++;
            pos=frase.indexOf(palabra,pos+1);
        }
        System.out.println("numero de apariciones: "+contador);   
    }
}
