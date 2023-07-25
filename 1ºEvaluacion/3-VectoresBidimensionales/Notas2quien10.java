//decir quien ha sacado 10 en tal asignatura 
package vectoresdimensionales;
public class Notas2quien10 {
    public static void main (String args[]){
  
         int notas[][] ={{7,9,3,8},
            {10,9,9,8},
            {3,10,7,10},
            {3,10,5,6},
            {10,6,10,8}};
        String asignaturas[]={"Programacion","base de datos","lenguaje de marcas","entornos de desarrollo"};
        String alumnos[]={"LUCAS","FRAN","JOSE","JORGE","LAURA"};
        System.out.println("El listado de dieces es: ");
    
        for(int i=0;i<notas.length;i++)
            for(int j=0;j<notas[i].length;j++)
                if(notas[i][j]==10)
                    System.out.printf("%s en %s\n",alumnos[i],asignaturas[j]);  
    
    }
}
