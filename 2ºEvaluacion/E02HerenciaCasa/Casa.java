package E02HerenciaCasa;
public class Casa {
    String direccion;
    int num_metros;
    int numHabitaciones;
    String pais;
    
    public static void main(String[] args) {
        Casa casa1 = new Casa("Paseo la independencia",350,4,"Venezuela");
        Chalet chalet1= new Chalet("Plaza alegria",700,7,"ZgZ",200,true);
        casa1.mostrar();
        chalet1.mostrar();
    }
    
    public Casa(String d,int nM,int nH,String p){
        direccion=d;
        num_metros=nM;
        numHabitaciones=nH;
        pais=p;
    }
    
    public void mostrar(){
        System.out.println(direccion +" "+  num_metros+" " + numHabitaciones+" " + pais);
    }
}
