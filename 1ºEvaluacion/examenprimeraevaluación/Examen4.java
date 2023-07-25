
package examenprimeraevaluación;
public class Examen4 {
    public static void main(String[] args) {
        int tabla1[][]={{2,0,1},{3,0,0},{5,1,1}};
        int tabla2[][]={{1,0,1},{1,2,1},{1,1,0}};
        int resultado[][]=new int[3][3];
        int tabla3[][]=new int[3][3];
        
        for (int i = 0; i < tabla2.length; i++) {
            for (int j = 0; j < tabla2[i].length; j++) {
                tabla3[i][j]=tabla2[j][i];
            }
        }
        
        for (int i = 0; i < resultado.length; i++) {
            resultado[i]=multiplicar(tabla1[i],tabla3[i]);
            
        }
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.println(resultado[i][j]);
            }
        }
    }
    
    public static int [] multiplicar(int [] t1, int t3[]) {
        int resultado[]=new int[3];
        int i=0;
        while(i<t1.length){
            //resultado[i] = (t1[i]*t3[i])+ multiplicar(i+1);
            i++;
        }
        return resultado;
    }
    
}
    
    
    









/*public static void muliplico(int[][] t1,int[][] t2, int[][] t3 ) {
        for (int i = 0; i < t1.length; i++) {
            for (int j = 0; j < t1[i].length; j++) {
                t3[i][j]=t1[i][j]*t2[j][i]+ multiplico(i+1);
            }
        }
    }
}*/
