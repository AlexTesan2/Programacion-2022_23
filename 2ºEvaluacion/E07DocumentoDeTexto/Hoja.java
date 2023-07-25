package E07DocumentoDeTexto;

import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Hoja extends Frame{
    TextArea texto;
    MenuBar menuBar;
    FileDialog abrirFichero;
    FileDialog guardarFichero;
    
    public static void main(String[] args) {
        Hoja app = new Hoja();
    }
    
    public Hoja(){
        super("Documento de texto");
        setup();
        this.pack();  //organiza la distribución
        this.resize(texto.minimumSize());
        this.show();
    }
    
    public void setup(){
        texto = new TextArea(20,50);  //filas, columnas
        this.add("Center",texto);
        setupMenuBar();
        abrirFichero= new FileDialog(this,"Abrir fichero",FileDialog.LOAD);
        guardarFichero= new FileDialog(this,"Abrir fichero",FileDialog.SAVE);
    }
    
    public void setupMenuBar(){
        menuBar=new MenuBar();
        Menu desplegableMenu=new Menu("Archivo");
        
        desplegableMenu.add(new MenuItem("Nuevo"));
        desplegableMenu.add(new MenuItem("Abrir"));
        desplegableMenu.addSeparator();
        desplegableMenu.add(new MenuItem("Guardar"));
        desplegableMenu.addSeparator();
        desplegableMenu.add(new MenuItem("Salir"));
        
        menuBar.add(desplegableMenu);
        this.setMenuBar(menuBar);
    }
    
    
    //No entiendo nada1
    public void leerFichero(String nombre){
        DataInputStream inStream;
        try{
            inStream = new DataInputStream (new FileInputStream (nombre));//file imput stream abre archivo para lectura y lo carga en ram
            String total = "";
            String frase;
            while(( frase = inStream.readLine())!= null){//asignacion y comparacion
                total += frase + "\n";
            }
            texto.setText(total);
        
        }catch (FileNotFoundException e){}
         catch (IOException e){}; //con un try podemos usar tantos catch como necesitemos
    }
    
    //no entiendo nada2
    public void guardarFichero(String nombre){
    
        DataOutputStream outStream;
        try{
            outStream = new DataOutputStream(new FileOutputStream(nombre));
            outStream.writeBytes(texto.getText());
        } catch (FileNotFoundException e){}
            catch(IOException e){};
    }
    
    //metodo tratamiento eventos
    public boolean handleEvent(Event ev){
        if (ev.id==Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;
        }else if (ev.id==Event.ACTION_EVENT){
            if(ev.target instanceof MenuItem ){
                if(ev.arg.equals("Salir")){
                    System.exit(0);
                    return true;
                }else if(ev.arg.equals("Nuevo")){
                    texto.setText(" ");
                    return true;
                    
                    
                }else if(ev.arg.equals("Abrir")){
                    abrirFichero.setVisible(true);
                    String nomFichero = abrirFichero.getDirectory() + "/" + abrirFichero.getFile();
                    leerFichero(nomFichero);
                    return true;
                }else if(ev.arg.equals("Guardar")){
                    guardarFichero.setVisible(true);
                    String nomFichero = guardarFichero.getDirectory()+ "/" + guardarFichero.getFile();
                    return true;
                }
            }
        }
        return false;
    }
}

