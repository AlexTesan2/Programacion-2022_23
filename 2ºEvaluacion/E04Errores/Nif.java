package E04Errores;
public class Nif {
    public int dni ;
    public char letra;// static => no se puede modificar 
    public static char TABLA[]={'T','R','W','A','G','M','Y','F','P','D','X','P','D','X',
                                'B','N','J','Z','S','Q','V','H','L','J','C','K','E'};
    
    public Nif (int dni ,char l) throws Exception{
        this.dni = dni;
        if(l != TABLA[dni% TABLA.length]){
            letra= TABLA[dni% TABLA.length];
            throw new Exception ("Me has mandado mal el NIF");
        }else
        letra = l;
    }
    
    public Nif (int dni){
        this.dni=dni;
        letra=TABLA[dni% TABLA.length];
    }
    
    public void mostrar(){
        System.out.println(dni + letra);
    }
}
