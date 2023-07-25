package E01Persona;
public class PersonaCompleto {
        
    int dni;
    String nombre;
    String fNac;
    String domicilio;
    
    public static void main(String[] args) {
        PersonaCompleto persona1;
        PersonaCompleto persona2;
        persona1= new PersonaCompleto(314159265, "Pi", "300 aC", "Atenas");
        persona2= new PersonaCompleto(12345678, "DemasiadoComun");
        persona1.mostrar();
        persona2.mostrar();
    }

    public PersonaCompleto (int dni, String nombre, String f, String d){
        this.dni = dni;
        this.nombre=nombre;
        fNac=f;
        domicilio=d;
    }
    public PersonaCompleto (int d, String n ){
        dni=d;
        nombre=n;
        fNac="1/1/2000";
        domicilio="Madrid";
    }
    public void mostrar(){
        System.out.println(dni+"  "+nombre+"  "+fNac+"  "+domicilio+ "\n");
    }
}
