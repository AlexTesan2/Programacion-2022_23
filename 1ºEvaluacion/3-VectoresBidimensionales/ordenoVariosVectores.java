//ordeana cada uno de los vectores
package vectoresdimensionales;
public class ordenoVariosVectores {
    public static void main (String args[]){
        int vectorSalario[][]={{700,900,600,1200,1500,790},
            {1100,980,810,990,980,450},
            {2500,3000,1340,4500,1230,1200},
            {1300,2000,345,780,980,1200}};
        
        for(int i=0;i<vectorSalario.length;i++)
            ordenar(vectorSalario[i]);  //Vector salario y ordenar tinen la misma direccion; son lo mismo
        for(int x=0;x<vectorSalario.length; x++){
            for( int y=0;y<vectorSalario[x].length;y++){
                System.out.print(vectorSalario[x][y]+" ");//se ordea en la otra funcion, y se inprime este vector ya ordenado
            }
            System.out.println();
        }
        
    }
    
    public static void ordenar(int v[]){
      int intercambio;
        for(int x=0;x< v.length; x++)
        for( int i= v.length-1;i>x; i--){
            if(v[i]< v[i-1]){
                intercambio= v[i];
                v[i]=v[i-1];
                v[i-1]=intercambio;
            }
        }
        /*for (int x=0;x< v.length;x++ )
            System.out.print(v[x]+" " );
        System.out.print("\n");
        */
    }
}
