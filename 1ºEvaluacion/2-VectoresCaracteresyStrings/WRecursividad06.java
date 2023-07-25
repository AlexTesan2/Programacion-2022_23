//21: dado un numero entero que se encuentra en una variable, diseccionarlo analizandolao hasta las centenas de millar
package vectorescaracteresystrings;
public class WRecursividad06 {
    public static String medidas[]={"Unidades","Decenas","centenas","Unidades de millar","decenas de millar", "centenas de millar"};
    public static void main (String args[]){
        int numero=25680;
        analizar(numero,0);
        
    }
    public static void analizar(int numero, int indice){
        if((numero/10)==0)
            System.out.printf("%d %s\n",(numero%10), medidas[indice]);
        else{
            analizar(numero/10,indice+1);
            System.out.printf("%d %s\n",(numero%10), medidas[indice]);
        }
    }
}
