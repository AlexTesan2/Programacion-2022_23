package E01Persona;
public class EjecPersona {
        public static void main(String[] args) {
        Persona persona1;
        Persona persona2;
        persona1= new Persona(07266420, "Alex", "25/11/2004", "Zaragoza");
        persona2= new Persona(12345678, "Mariano");
        persona1.mostrar();
        persona2.mostrar();
    }
}
