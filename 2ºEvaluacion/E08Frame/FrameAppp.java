package E08Frame;

import com.sun.glass.ui.Cursor;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;

public class FrameAppp extends Frame{
    
    MenuBar porDefecto;
    MenuBar alternativo;
    String tituloInicial; 
    int cursores[]={Cursor.CURSOR_CROSSHAIR ,Cursor.CURSOR_DEFAULT, Cursor.CURSOR_RESIZE_LEFT, Cursor.CURSOR_OPEN_HAND , Cursor.CURSOR_CUSTOM,};
    int indCursor=0;
    Color colores[]={Color.BLACK, Color.CYAN, Color.GREEN, Color.ORANGE,Color.white};
    int indColores=0;
    int indTexto=3;
    Color coloresLetra[]={Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA , Color.ORANGE};
    String fuentes[]={"Helvetica","TimesRoman", "Courier", "Dialog", "Arial", Font.DIALOG};//atributo de la clase font , es un string pq esta en un  vector de strings
    int idFuente=1;
    
    
    public static void main(String[] args) {
        FrameAppp app =new FrameAppp();
    }
    
    public FrameAppp(){
        super("Propiedades del Frame");
        tituloInicial = this.getTitle();
        
        setup();
        this.pack();
        this.setSize(400,400);
        this.show(true);
    }
    
    public void paint(Graphics g){
        g.drawString("Cambia el color al pulsar Foreground", 100, 150);
    }
    
    public void setup(){
        setupMenuBar();
        setupPaneles();
    }
    
    public void setupMenuBar(){
        porDefecto=new MenuBar();
        Menu FileMenu= new Menu("File");
        FileMenu.add(new MenuItem("Exit"));
        FileMenu.addSeparator();
        FileMenu.add(new MenuItem("Save"));
        porDefecto.add(FileMenu);
        this.setMenuBar(porDefecto);
        
        alternativo=new MenuBar();
        Menu FileMenu2= new Menu("Archivo");
        FileMenu2.add(new MenuItem("Guardar"));
        FileMenu2.addSeparator();
        FileMenu2.add(new MenuItem("Salir"));
        alternativo.add(FileMenu2);
    }
    
    public void setupPaneles(){
        Panel principal=new Panel();
        principal.setLayout(new GridLayout(4,1));
        principal.add(new Label("Cambian las caracteristicas de la ventana ", Label.CENTER));//label es una etiqueta no modificable
        
        Panel panel1=new Panel();
        panel1.add(new Button("MenuBar"));
        panel1.add(new Button("Titulo"));
        panel1.add(new Button("Redimensionar"));
        panel1.setBackground(Color.cyan);
        principal.add(panel1);
        
        principal.add(new Label("Salidas en la ventana ", Label.CENTER));
        Panel panel2 = new Panel();
        panel2.add(new Button("Cursor"));
        panel2.add(new Button("Cambio de color"));
        panel2.add(new Button("Foreground"));
        panel2.add(new Button("Fuente"));
        panel2.setBackground(Color.yellow);
        principal.add(panel2);
        
        this.add("South",principal);
        
    }
    
    public boolean handleEvent(Event ev){
        if(ev.id==Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
            
        }else if(ev.id==Event.ACTION_EVENT){
            
            if(ev.target instanceof Button){
                if(ev.arg.equals("MenuBar")){
                    if(this.getMenuBar() == porDefecto)
                        this.setMenuBar(alternativo);
                    else
                        this.setMenuBar(porDefecto);
                    return true;
                    
                    
                }else if(ev.arg.equals("Titulo")){
                    if(this.getTitle().equals (tituloInicial))
                        this.setTitle("Titulo alternativo");
                    else
                        this.setTitle(tituloInicial);
                    return true;
                               
                }else if(ev.arg.equals("Redimensionar")){
                    this.setResizable(!this.isResizable());
                    return true;
                    
                }else if(ev.arg.equals("Cursor")){
                    this.setCursor(cursores[indCursor]);
                    indCursor=(indCursor+1)%cursores.length;
                    return true;
                    
                }else if(ev.arg.equals("Cambio de color")){
                    this.setBackground(colores[indColores]);
                    indColores=(indColores+1)%colores.length;
                    return true;
                    
                }else if(ev.arg.equals("Foreground")){
                    this.setForeground(coloresLetra[indTexto]);
                    indTexto = (indTexto+1)% coloresLetra.length;
                    return true;
                    
                }else if(ev.arg.equals("Fuente")){
                    this.setFont(new Font(fuentes[idFuente], Font.ITALIC, 15));
                    idFuente = (indTexto+1)% colores.length;
                    return true;
                }
            }
        }
        return false;
    }
}
