package E04Errores;
public class e4ErroresNIf {
        public int dni ;
    public char letra;
    public static char TABLA[]={'T','R','W','A','G','M','Y','F','P','D','X','P','D','X',
                                'B','N','J','Z','S','Q','V','H','L','J','C','K','E'};

    
    public e4ErroresNIf(int dni, char le) throws Exception{
        this.dni = dni;
        if (le != TABLA[dni%TABLA.length]) {
            letra=TABLA[dni%TABLA.length];
            throw new Exception ("Me has mandado mal el NIF");
        }else{
            this.letra=le;
        }
    }
    
    public e4ErroresNIf(int dni){
        this.dni=dni;
        letra=TABLA[dni%TABLA.length];
    }
        
    public void mostrar(){
        System.out.println(dni+" "+letra);
    }
    

}
