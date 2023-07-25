package E06DibujandoOvalo;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class OvaloApp extends Frame{
    
    Ovalo ovalo;
    
    public static void main(String[] args) {
        OvaloApp app=new OvaloApp();
    }
    
    public OvaloApp(){
        super("Dibujando Ovalos");
        ovalo = new Ovalo();
        Button boton1 = new Button("Salir");
        Button boton2 = new Button("Siguiente");
        Panel panel1 = new Panel();     //Panel es un contenedor donde poner varias cosas, el layout por defecto solo acepta un elemento por zona
        panel1.add(boton1);
        panel1.add(boton2);
        this.add("South",panel1);
        this.resize(300,300);
        this.show(true);
    }
    
    public void paint (Graphics g){
        ovalo.pintar(g);        //acude a la clase ovalo y ejecuta la funcion pintar
    }
    
    public boolean handleEvent ( Event ev){     //metodo traamiento eventos
        if (ev.id==Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;
            
        }else if(ev.id==Event.ACTION_EVENT){
            if(ev.target instanceof Button){
                if(ev.arg.equals("Salir")){
                    System.exit(0);
                    return true;
                }
                if(ev.arg.equals("Siguiente")){
                    ovalo.inicializar();
                    repaint();     //borra y reescribe
                    return true;
                }
            }
        }
        return false;
    }
}
// set --> modificar   
// get --> devolver