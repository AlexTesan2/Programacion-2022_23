package E03Animales;
public class AniEjecutable {
    public static void main(String[] args) {
        Rinoceronte rino1=new Rinoceronte(1023,"RinoPeludo","OOOHH","Peligroso:",true,9);
        Perro perro1=new Perro(10873,"Lolo","Guau","agresivo",true);
        rino1.hablar();
        perro1.hablar();
    }
}
