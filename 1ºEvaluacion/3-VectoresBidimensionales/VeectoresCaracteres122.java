//sustituir "en" por "XXXX"   conseguido
package vectoresdimensionales;
public class VeectoresCaracteres122 {
  public static void main (String args[]){
        char frase[]={'e','n',' ','u','n',' ','l','u','g','a','r',' ','e','n',' ','L','a',' ','M','a','n','c','h','a',' ','e','n',' '};
        char cadena[]=new char[150];
        char subcad[]={'e','n',' '};
        char subcad2[]={'X','Y','Z','P'};
        int z;
        int u=0;
        for(int e=0;e<frase.length;e++)
            cadena[e]=frase[e];
        
        for(int i=0;i<cadena.length;i++)
            if(cadena[i]==subcad[0]){
                z=1;
                while((z<subcad.length)&&(subcad[z]==cadena[i+z]))
                    z++;
                if(z==subcad.length){
                    for(int x=0;x<subcad2.length-1;x++,i++){
                        cadena[i]=subcad2[x];
                        u=x;
                    }
                    for(int y=cadena.length-1;y>u;y--){
                            cadena[y]=cadena[y-1];
                    }
                    cadena[i]=subcad2[u+1];
                }      
            }    
                
        System.out.println(cadena);
    }
}
        