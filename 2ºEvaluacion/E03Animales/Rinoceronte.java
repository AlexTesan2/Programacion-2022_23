package E03Animales;
public class Rinoceronte extends Animales{
    boolean peligroso=true;
    int grosorArmadura;
    public Rinoceronte(int c, String nom, String o, String car, boolean p,  int g){
        super(c,nom,o,car);
        peligroso=p;
        grosorArmadura=g;
    }
    public void hablar(){//por culpa del abtract, sin el habla, el rinoceronte daria error
        System.out.println(codigo+" "+nombre+" "+onomatopeya+" "+caracter+" "+peligroso+" "+grosorArmadura);
    }
}
