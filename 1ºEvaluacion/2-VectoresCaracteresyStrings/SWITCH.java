//swich/case si hay varias opciones a diferencia del if que solo son respuestas binarias :si / no
// convertir las vocales de minus a mayus y al reves
package vectorescaracteresystrings;
public class SWITCH {
        public static void main (String args[]){
        char frase[]={'e','n',' ','u','n',' ','l','u','g','a','r',' ','E','n',' ','l','A',' ','m','A','n','c','h','a',' '};
            for (int i=0;i<frase.length; i++) 
                switch (frase[i]){
                    case 'a': case 'e':case 'i':case 'o':case 'u': 
                        frase[i]=Character.toUpperCase(frase[i]);
                        break;      //rompe un bucle
                    case 'A':case 'E':case 'I':case 'O':case 'U':
                        frase[i]=Character.toLowerCase(frase[i]);
                        break;
                    case ' ':
                        break;
                        
                    default:
                        frase[i]='$';
                }
            System.out.println(frase);
        }

}
