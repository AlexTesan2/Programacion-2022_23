package E09Objetos;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class Objetos extends Frame {
    TextArea areaTexto;
    
    public static void main(String[] args) {
        Objetos app = new Objetos();
    }
    
    public Objetos(){
        super("Objetos diversos");
        setup();
        this.pack();
        this.resize(440, 420);
        this.setVisible(true);
    }
    
    public void setup(){
        Panel principal=new Panel();
        principal.setLayout(new GridLayout (3,3));
        
        Panel paneles[][]= new Panel[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                paneles[i][j]=new Panel();
            }
        }
        
        paneles[0][0].add(new Label("Campo de texto"));//Label: texto sobre el q no se puede escribir
        paneles[0][0].add(new MiTextField("",15));
        paneles[0][0].add(new Label("(Al pulsar intro se parará a mayusculas)"));
        principal.add(paneles[0][0]);
        this.add("Center", principal);
        
        areaTexto=new TextArea(5,10);
        areaTexto.setBackground(Color.YELLOW);
        paneles[0][1].add(areaTexto);
        principal.add(paneles[0][1]);
        
        paneles[0][2].add( new MiButton("Borrar", areaTexto));
        principal.add(paneles[0][2]);
        
        //Ninguna Utilidad
        Choice eleccion = new Choice();
        eleccion.add("Español");
        eleccion.add("Ingles");
        paneles[1][0].add(eleccion);
        
        String opciones[]={"Si","No","Quizas"};
        paneles[1][0].add(new MiChoice(opciones, areaTexto));
        principal.add(paneles[1][0]);
        
        String deportes[]= {"Bloncesto","Esgrima","Balonmano","Artes Marciales" , "Patinaje"};
        paneles[1][1].add(new MiLista(deportes,areaTexto));
        principal.add(paneles[1][1]);
        
        paneles[1][2].add(new MiCanvas());
        principal.add(paneles[1][2]);
        
        String alimentos[]={"Patatas", "Legumbres", "Hortalizas","Hamburgesa"};
        paneles[2][0].add(new MiCheckboxGroup(alimentos));
        principal.add(paneles[2][0]);
        
        this.add("Center", principal);
    }
    
    
    public boolean handleEvent(Event ev){
        if (ev.id==Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;
        }
        return false;
    }
    
}

    class MiTextField extends TextField{
        public MiTextField(String valor, int tamano){
            super(valor, tamano);   //es inecesario hacer este metodo, hace exactamente lo mismo quE TextField
        }
        
        public boolean action (Event ev, Object obj){         //El evento por defecto es pulsar intro
            this.setText(this.getText().toUpperCase());    //Al pulsar intro, poner las palabras a mayus
            return false;
        }
    }
    
    class MiButton extends Button{
        TextArea texa;
        public MiButton(String titulo, TextArea tx){//construimos el boton, espera recibir un titulo, y un extArea sobre el qu actuar
            super(titulo);
            texa=tx;
        }
        public boolean action(Event ev, Object obj){
            texa.setText(" ");
            return false;
        }
    }
    
    class MiChoice extends Choice{
        TextArea tx;
        public MiChoice(String[] op, TextArea txt){
            super();
            for (int i = 0; i < op.length; i++) {
                this.add(op[i]);
            }
            tx=txt;
        }
        
        public boolean action(Event ev, Object obj){
            tx.setText(this.getSelectedItem());
            return true;
        }
    }

    class MiLista extends List{ //control para selecionar
        TextArea texto;
        public MiLista(String[] dep, TextArea tx){
            super(5,true);
            for (int i = 0; i < dep.length; i++) {
                this.add(dep[i]);
            }
            texto=tx;
        }
        
        public boolean handleEvent(Event ev){
            if((ev.id == Event.LIST_SELECT) || (ev.id == Event.LIST_DESELECT)) {    //no counfundir obj con evento sobre el objeto
                String v[] = this.getSelectedItems();//devuelve un vector de strings  /this es MiLista//this es un objeto, objeto es variable tipo puntero, una clase no,  
                String seleccionados = "";
                for (int i = 0; i < v.length; i++)
                    seleccionados += v[i] + "\n";
                texto.setText(seleccionados);
            }
            return true;
        }
    }

    //canvas es una ventana, que dentro tiene un objeto graphis
    class MiCanvas extends Canvas{
        int posX = 25;
        int posY = 25;
        public MiCanvas(){
            super();
            this.setSize(75, 75);
            this.setBackground(Color.cyan);
            this.setForeground(Color.red);
            this.setVisible(true);
        }
        public void paint(Graphics g){
            g.fillRect(posX,posY, 5, 5);
        }
        public boolean mouseDown(Event ev, int x, int y ){
            posX=x;
            posY=y;
            this.repaint();
            return true;
        }
    }


class MiCheckboxGroup extends Panel{
    public TextField resultado;
    Checkbox checkboxes[];
    public MiCheckboxGroup(String alimentos[]){
        super();
        checkboxes = new Checkbox[alimentos.length];
        this.setLayout(new GridLayout(alimentos.length+1 , 1));
        for (int i = 0; i < alimentos.length; i++) {
            checkboxes[i]= new Checkbox(alimentos[i]);
            this.add(checkboxes[i]);
        }
        resultado= new TextField("", 15);
        this.add(resultado);
    }
    public boolean handleEvent(Event ev){
        if (ev.id==Event.ACTION_EVENT) {
            if (ev.target instanceof Checkbox) {
                String seleccionados = "";
                for (int i = 0; checkboxes.length < 10; i++)
                    if(checkboxes[i].getState()) 
                        seleccionados+= checkboxes[i].getLabel();
                resultado.setText(seleccionados);
                return true;
            }
            
        }
        return false;
    }
}