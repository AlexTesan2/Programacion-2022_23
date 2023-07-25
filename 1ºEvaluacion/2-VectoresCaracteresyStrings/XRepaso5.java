//multiplicar una tabla ppor un vector
package vectorescaracteresystrings;
public class XRepaso5 {
    public static void main(String[] args) {
        int tabla[][]={{1,2,3,4},{2,4,6,8},{3,6,9,12},{4,8,12,16}};
        int vector[]={1,2,3,4};
        int resultado[][]=new int[4][4];
        
        for (int i = 0; i < tabla.length; i++) 
            for (int j = 0; j < tabla[i].length; j++) 
                resultado[i][j]=(tabla[i][j]*vector[j]);
            
        
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) 
                System.out.print(resultado[i][j]+ "  ");
            System.out.println("");
        }
        System.out.println("--------------------------------------\n");
        
        multiplicar(tabla,vector);
        
    }
    
    public static void multiplicar(int[][] tabla ,int []vector) {
        int resultado[][]=new int[4][4];
        for (int i = 0; i < tabla.length; i++) 
            for (int j = 0; j < tabla[i].length; j++) 
                resultado[i][j]=(tabla[i][j]*vector[j]);
        
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) 
                System.out.print(resultado[i][j]+ "  ");
            System.out.println("");
        }
        
    }
}
