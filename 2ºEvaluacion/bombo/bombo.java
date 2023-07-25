package bombo;
public class bombo {
    public int bombo[];//|static  para todos los objetos de la misma clase tendra el mismo valor atributo de la clase , no de un objeto
    public static final int NUMBOLAS=48; //constantes no s puede modificar su valor, poner en mayusculas
    public int bolasQuedan;
    
    public bombo(){//todo sllos objetos de la misma clase tiene el = valor   
        bombo=new int [NUMBOLAS];
        bolasQuedan = NUMBOLAS;
        for (int i=0;i<NUMBOLAS;i++)
            bombo[i]=i+1;
    }//Math.random(0-1)/////parseInt
    public int sacar(){
        
        return 5;
    }
}
