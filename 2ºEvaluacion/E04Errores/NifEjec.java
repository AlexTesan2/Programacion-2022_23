package E04Errores;//errores a la hora de compila --> excepciones //tratamiento de excepciones try
public class NifEjec {
    public static void main(String[] args) throws Exception {
        /*try{
        int t=33/0;
        }catch(ArithmeticException  exc){
            System.out.println("Has dividifo para 0"+ exc.getLocalizedMessage());
        }
        System.out.println("Mostrar mensaje");
        */
        Nif persona1;
        persona1 = new Nif (11111,'G');
        persona1.mostrar();
        
        Nif persona2 = new Nif (07266420);
        persona2.mostrar();
        
        Nif persona3= new Nif (07266427 ,'E');
        persona3.mostrar();
    }
}
