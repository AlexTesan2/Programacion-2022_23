package E03Animales;
public class Perro extends Animales {
    boolean LeGustanLosPalos;
    public Perro(int c, String nom, String o, String car, boolean palo){
        super(c,nom,o,car);
        LeGustanLosPalos=palo;
    }
    public void hablar(){
        System.out.println("codigo: "+codigo+" "+"nombre: "+nombre+" "+"onomatopeya: "+onomatopeya+" "+"caracter: "+caracter+" "+"LeGustanLosPalos: "+LeGustanLosPalos);
    }
}