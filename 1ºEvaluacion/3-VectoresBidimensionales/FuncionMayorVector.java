package vectoresdimensionales;
public class FuncionMayorVector {
    public static void main (String args[]){
        int vector[]={24,45,12,7,12,61,34};
        //vector[3]=1000;//
        int vector2[]={24,475,12,7,162,1,34};//ventajas a la hora de repetirno hay que escribir mucho mas codigo
        
        int maximaposicion= mayor(vector);
        int maximaposicion2= mayor(vector2);
                            //los dos vectores tienen la misma direccion de memoria--> son el mismo 
        System.out.printf("el maximo es %d y esta en la posicion %d\n",vector[maximaposicion],maximaposicion);
        System.out.printf("el maximo es %d y esta en la posicion %d\n",vector2[maximaposicion2],maximaposicion2);
    } 
    public static int mayor( int v[]){
        //v[2]=200; se puede
        int posmax=0;
        for(int i=0;i<v.length;i++)
            if(v[i]>v[posmax])
                posmax= i;
        return posmax;
}
}
//los vectores se guardan en un direccion de memoria 