
package vectoresdimensionales;
public class FuncionesSalarios {
    public static void main (String args[]){
        int salarios[][]={{700,900,600,1200},{1100,980,810,990},{2500,3000,1340,4500}};
        int pago=suma(salarios);//pago=acum/ acum vuelve de la fnc suma/ a la fnc suma la damos el vector salarios 
        System.out.println("Este mes tengo que pagar "+ pago +" €");
    }
    public static int suma(int vect[][]){
        int acum=0;
        for(int i=0;i<vect.length;i++){
            for(int j=0; j<vect[i].length;j++){
                acum+= vect[i][j];
            }
        }
        return acum;
    }
}
