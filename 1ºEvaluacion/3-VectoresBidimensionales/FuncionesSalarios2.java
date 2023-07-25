//mostrar el salario semestral de cada empleado
package vectoresdimensionales;
public class FuncionesSalarios2 {
    public static void main (String args[]){
        int vectorSalario[][]={{700,900,600,1200,1500,790},{1100,980,810,990,980,450},{2500,3000,1340,4500,1230,1200},{1300,2000,345,780,980,1200}};//6 meses 4 pers
        String empleados[]={"Jose","Pepe","Miguel","Raul"};
        String meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio"};
        int[] salariofinal=salarios(vectorSalario);
        for(int x=0;x<salariofinal.length;x++){
            System.out.println("El empleado "+empleados[x]+" cobra "+ salariofinal[x]+" € por semestre");
        }
    }
    
    public static int[] salarios(int vect[][]){
        int acum[]= new int[4];            //reserva memoria RAM
        for(int i=0;i< vect.length;i++){
            for(int j=0;j<vect[i].length;j++){
                acum[i]+=vect[i][j];
            }
        }
        return acum;
    }
}

