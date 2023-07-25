package E01Persona;
public class Persona {
    int dni;
    String nombre;
    String fNac;
    String domicilio;
    
    //entre () estan las variables que el metodo espera recibir del psvm  
    public Persona (int dni, String nombre, String f, String d){//metodo constructor
        this.dni = dni;
        this.nombre=nombre;
        fNac=f;
        domicilio=d;
    }
    
    public Persona(int d, String n ){//MetodoConstuctor dar valores iniciales a los atributos
        dni=d;
        nombre=n;
        fNac="1/1/2000";
        domicilio="Madrid";
    }
    
    public void mostrar(){
        System.out.println(dni+"  "+nombre+"  "+fNac+"  "+domicilio+ "\n");
    }
}
