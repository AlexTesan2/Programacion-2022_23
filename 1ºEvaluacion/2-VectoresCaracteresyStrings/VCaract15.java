//eliminar "en" de la frase 
package vectorescaracteresystrings;
public class VCaract15 {
    public static void main (String args[]){
        char frase[]={' ','e','n',' ','u','n',' ','l','u','g','a','r',' ','e','n',' ','L','a',' ','M','a','n','c','h','a'};
        char eliminable[]={'e','n',' '};
        int j;
            for (int i=0; i<frase.length;i++){
                if(frase[i]==eliminable[0]) {
                    j=1;
                    while((j<eliminable.length)&&(eliminable[j]==frase[i+j]))
                            j++;
                    if(j==eliminable.length){
                        for(int o=0;o<eliminable.length;o++){
                            for(int x=(i+j-o);x<frase.length;x++)
                                frase[x-1]=frase[x];
                        frase[frase.length-1]=' ';    
                                
                        }
                    }
                }
            }
        System.out.println(frase);
    }   
}
