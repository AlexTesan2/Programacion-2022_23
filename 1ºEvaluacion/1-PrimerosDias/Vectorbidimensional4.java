
package primeros.dias;
public class Vectorbidimensional4 {
  public static void main (String args[]){
  
    int tabla[][]={{10,20,30,40},{50,60,70,80},{90,100,110,120}};
    int vect1[]={0,0,0};
    int vect2[]={0,0,0,0};
    
    for(int y=0;y<tabla.length;y++){
        for(int x=0;x<tabla[y].length;x++){
        
            vect1[y]+= tabla[y][x];
            vect2[x]+= tabla[y][x];
        }
      
    }
      System.out.println("vector1 :");
    for(int c=0;c<vect1.length;c++){
        System.out.printf("%d  ",vect1[c]);
        }
      System.out.print("\n vector2:  \n");
     
    for(int m=0;m<vect2.length;m++){
        System.out.printf("%d  ",vect2[m]);
        }
      System.out.println();
  }
  
}
