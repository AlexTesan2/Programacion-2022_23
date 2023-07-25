package E03Animales;
public abstract class Animales {

    int codigo;
    String nombre;
    String onomatopeya;
    String caracter;
    
    public Animales(int c, String nom, String o, String car){
        codigo=c;
        nombre=nom;
        onomatopeya=o;
        caracter=car;
    }
    public abstract void hablar();    //abstract; no puedes implementar objetos de esa clase    
}
