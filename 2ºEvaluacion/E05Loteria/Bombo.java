package E05Loteria;
public class Bombo {
    public int bombo[]          ;//|static  para todos los objetos de la misma clase tendra el mismo valor atributo de la clase , no de un objeto
    public static final int NUMBOLAS=48; //constantes no s puede modificar su valor, poner en mayusculas
    public int bolasQuedan;
    
    public Bombo(){//todo sllos objetos de la misma clase tiene el = valor   
        bombo=new int [NUMBOLAS];
        bolasQuedan = NUMBOLAS;
        for (int i=0;i<NUMBOLAS;i++)
            bombo[i]=i+1;
    }//Math.random(0-1) metodo estatico/////parseInt///Random.nextInt (numero aleatorio entre 0 y y el valor que quieras)
    
    public int sacar(){
        int aleatorio= (int)(Math.random()*bolasQuedan);
        int guardado=bombo[aleatorio];
        bombo[aleatorio]=bombo[bolasQuedan -1];
        bolasQuedan--; 
        return guardado;
    }
}
