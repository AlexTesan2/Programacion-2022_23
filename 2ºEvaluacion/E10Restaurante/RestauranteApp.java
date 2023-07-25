package E10Restaurante;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class RestauranteApp extends Frame {
    String comidas [] = {"Desayuno", "Almuerzo", "Cena"};
    String [][]  platos= {{"Leche", "Cafe", "Colacao","Magdalenas"},
                            {"Sopa", "Filete", "Pescao", "Ensalada", "Tarta","Flan","Horchata"}, 
                            {"Tortilla","Pollo","HuevosFritosConJamon"}};
    List presentar;
    List listaPlatos[];
    List listaComidas;
    Choice horario;
    TextField texto;
    
    
    public static void main(String[] args) {
        RestauranteApp App = new RestauranteApp();
    }
    
    public RestauranteApp(){
        super("Bar Alpine");//titulo
        setup();
        this.pack();
        this.setSize(300,300);
        this.setVisible(true);
    }
    
    public void setup(){
        this.add("North", new Label("¿Que desea tomar?", Label.CENTER));//subtitulo
        
        horario= new Choice();
        for (int i = 0; i < comidas.length; i++) 
            horario.addItem(comidas[i]);
        horario.setBackground(Color.green);
        this.add("West", horario);
        
        listaPlatos = new List[platos.length]; // listaPlatos es una lista (vector) de tres listas
        for (int i = 0; i < platos.length; i++) {
            listaPlatos[i]=new List(5, true);
            for (int j = 0; j < platos[i].length; j++)
                listaPlatos[i].addItem(platos[i][j]);
        }
        presentar=listaPlatos[0];
        presentar.setBackground(Color.cyan);
        this.add("East",presentar);
        
        texto=new TextField("",40);
        texto.setBackground(Color.YELLOW);
        this.add("South",texto);
    }
    
    public boolean handleEvent(Event ev){
        if(ev.id==Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
            
        }else if(ev.id==Event.ACTION_EVENT){
            
            if(ev.target instanceof Choice){
                this.remove(presentar);
                presentar=listaPlatos[horario.getSelectedIndex()];
                this.add("East",presentar);
                presentar.setBackground(Color.cyan);
                texto.setText(horario.getSelectedItem()+": ");
                this.show();
                return true;
            }
        }else if((ev.id==Event.LIST_SELECT) || (ev.id==Event.LIST_DESELECT)){
            String frase="";
            frase=horario.getSelectedItem()+ ": ";
            String items[]= presentar.getSelectedItems();
            for (int i = 0; i < items.length; i++) 
                frase +=  items[i]+" ";
            texto.setText(frase);
            return true;
        }
        return false;
    }
}