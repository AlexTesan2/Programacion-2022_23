
package metodosyfuncuiones;
public class aMetodo1Burbujaa {
        public static void main(String[] args) {
            int vector[]={25,2,73,81,16,4,33};
            int aux=0;
            for(int i=0;i<vector.length;i++){
                for(int j=vector.length-1;j>i;j--){
                    if(vector[j]<vector[j-1]){
                        aux=vector[j];
                        vector[j]=vector[j-1];
                        vector[j-1]=aux;
                    }
                }
            }
            for(int h=0;h<vector.length;h++)
                System.out.print(vector[h]+" ");
        }
}
