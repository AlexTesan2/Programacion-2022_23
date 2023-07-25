package E02HerenciaCasa;
public class Chalet extends Casa{
    int metrosJardin;
    boolean piscina=true;
    
    public Chalet(String d,int nM,int nH,String p, int m, boolean pp){
        super(d,nM,nH,p);
        metrosJardin=m;
        piscina=pp;
    }
    
    public void mostrar(){
        System.out.print("Esto es un chalet ");
        if(piscina)
            System.out.print("tiene piscina ");
        else
            System.out.print("no tiene piscina ");
        System.out.println(direccion +" "+  num_metros+" " + numHabitaciones+" " + pais+"  "+ metrosJardin);
    }
}
