package E04Errores;
public class e5ErrorAritmeticoTerm {
    public static void main(String[] args) {
        try{
        int t=33/0;
        }catch(ArithmeticException  exc){
            System.out.println("Has dividifo para 0"+ exc.getLocalizedMessage());
        }
    }
}
