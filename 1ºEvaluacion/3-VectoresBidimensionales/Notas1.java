//nombre del alumno con mejores notas su media y el quien menos. La asignat con mejores notas, su media y la que menos
package vectoresdimensionales;
public class Notas1 {
 public static void main (String args[]){
  
    int notas[][] ={{12,34,71,23},
        {45,32,98,50},
        {23,56,43,23},//sin termiar da muchos errores necesario repetir
        {12,56,87,90},
        {56,34,64,21}};
    int alumnosNota []={0,0,0,0,0};
    double asignaturasNota []={0,0,0,0};
    int mayor=0;
    int menor=10000;
        
    String asignaturas[]={"Programación","Base de datos ","Ingles","Redes informaticas"};
    String alumnos[]={"Javi","Victor","Lorena","Ines","Nacho"};
    for(int i=0; i<notas.length;i++){
        for(int j=0;j<notas[i].length; j++){
            alumnosNota[i]+=notas[i][j];
            asignaturasNota[j]+=notas[i][j];
        }
    }
    for(int i=0; i<notas.length;i++){
        if(alumnosNota[i]>alumnosNota[mayor]){
           mayor=i;
        }
 
    
    }
    System.out.printf("El alumno con mejores calificaciones es %s con una media de %.2f \n",alumnos[mayor],alumnosNota[mayor]/notas.length);
    
    
}
}
/*
//mommre del alumno con mejores notas su mediA y el quie menos. la asignat con mejores notas y su media y la que menos
package primeros.dias;
public class notas35 {
  public static void main (String args[]){
  
  int notas[][] ={{12,34,71,23},
        {45,32,98,50},
        {23,56,43,23},
        {12,56,87,90}};
      
        double vAlumnosNota []={0,0,0,0,0};
       double vAsignaturasNota []={0,0,0,0};
        
    String asignaturas[]={"Programación","Base de datos ","Ingles","Redes informaticas"};
    String alumnos[]={"Alex","Victor","Lorena","Ines","Nacho"};
  
    for(int x=0; x<notas.length;x++){
        for (int y=0; y< notas[x].length;y++){
            vAlumnosNota[x] += notas[x][y];
            vAsignaturasNota[y] += notas[x][y];
        }
    
    }
    int posMejorAl=0;
    int posPeorAl =0;
    for(int r=1;r<vAlumnosNota.length; r++){
        if(vAlumnosNota[r]> vAlumnosNota[posMejorAl])
            posMejorAl=r;
        if(vAlumnosNota[r]> vAlumnosNota[posPeorAl])
            posPeorAl=r;
        
    }
      System.out.printf("Las mejores notas son de %s, con una media de %.2f\n", alumnos[posMejorAl],vAlumnosNota[posMejorAl]/asignaturas.length);
      System.out.printf("Las peores notas son de %s, con una media de %.2f\n", alumnos[posPeorAl],vAlumnosNota[posPeorAl]/asignaturas.length);
      
      
      
       int posMejorAs=0;
    int posPeorAs =0;
    for(int r=1;r<vAlumnosNota.length; r++){
        if(vAlumnosNota[r]> vAlumnosNota[posMejorAs])
            posMejorAs=r;
        if(vAlumnosNota[r]> vAlumnosNota[posPeorAs])
            posPeorAs=r;
         System.out.printf("Las asignatura com mejores notas son de %s, con una media de %.2f\n", asignaturas[posMejorAs],vAsignaturasNota[posMejorAs]/alumnos.length);
      System.out.printf("Las peores notas son de %s, con una media de %.2f\n", alumnos[posPeorAl],vAlumnosNota[posPeorAl]/asignaturas.length);
      
        
  }
  }}

*/