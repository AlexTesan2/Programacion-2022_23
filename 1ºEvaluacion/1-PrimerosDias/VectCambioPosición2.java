//todos se mueven uno hacia la derecha excepto el ultimo q estara el primero
package primeros.dias;
public class VectCambioPosición2 {
    public static void main (String args[]){
    
        int vect[]={1,2,3,4,5,6,7,8,9,10};
        int auxiliar = vect[vect.length-1]; // //System.arraycopy(vect, 0, vect, 1, vect.length-1);
        for (int i=vect.length-1; i >0; i--){
            vect[i]=vect[i-1];
        }
        vect[0]= auxiliar;
        for(int c=0;c<vect.length;c++)
            System.out.print(vect[c]+"  ");
        System.out.print("\n");
    }
}
