package E11Dibujos;
//todos los objetos de la clase dos puntos tendran pt inicio y de  fin, el objeto podra ser de tipo linea, rectangulo, ovalo/  definir tres constantes
import E06DibujandoOvalo.Ovalo;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
//import java.util.List

public class DibujarApp extends Frame{
    public int tipo;
    DosPuntos actual;
    java.util.List<DosPuntos> lista;//List <DosPuntos> lista;//
    
    public static void main(String[] args) {
        DibujarApp app = new DibujarApp();
    }
    
    public DibujarApp(){
        super("Dibujando Objetos");
        
        setupMenuBar();
        tipo= DosPuntos.LINEA;
        lista = new java.util.ArrayList<DosPuntos>();
        
        this.pack();
        this.resize(400,400);
        this.show(true);
        
    }
     
    public void setupMenuBar(){
        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu ("Fichero");
        menu1.add(new MenuItem("Nuevo"));
        menu1.addSeparator();
        menu1.add(new MenuItem("Salir"));
        menuBar.add(menu1);
        
        Menu menu2 = new Menu ("dibujar");
        menu2.add(new MenuItem("Linea"));
        menu2.add(new MenuItem("Ovalo"));
        menu2.add(new MenuItem("Rectangulo"));
        menuBar.add(menu2);
        this.setMenuBar(menuBar);
        
    }
    
    
    public void paint(Graphics g){
        //for (int i = 0; i < lista.size(); i++) 
          //  lista.get(i).paint(g);//coger un elem de la lista dosPuntos
        //bucle para listas y elementos enumerados: foreach / o for coje un elem de la sita y los mete en otro objrto
        for(DosPuntos item : lista){
            item.paint(g);
        }
        
        if(actual != null)
            actual.paint(g);
    }
    
    public boolean mouseDown (Event ev, int x, int y){
        actual= new DosPuntos(x,y,tipo);
        repaint();
        return true;
    }
    
    public boolean mouseDrag (Event ev, int x, int y){//conforse se arrastra, se va formando una linea, el punto final va vaiando
        actual.setPosFinX(x);
        actual.setPosFinY(y);
        repaint();
        return true;
    }
 
    
    public boolean mouseUp (Event ev, int x, int y){   
        lista.add(actual);
        actual= null;
        return true;
    }
    
    public boolean action (Event ev, Object obj){
            if (ev.target instanceof MenuItem) {
                if(ev.arg.equals("Salir")){
                    System.exit(0);
                    return true;
                }else if(ev.arg.equals("Linea")){
                    tipo=DosPuntos.LINEA;
                    return true;
                }else if(ev.arg.equals("Ovalo")){
                    tipo=DosPuntos.OVALO;
                    return true;
                }else if(ev.arg.equals("Rectangulo")){
                    tipo=DosPuntos.RECTANGULO;
                    return true;
                }
            }
        return false;
    }
}//clase cuyos objetos tienen vectores ilimitados: list  != list del awt// esta list sale de el paquete