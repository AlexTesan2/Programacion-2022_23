
package E98SerpienteByNacho;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import javax.swing.*;
import java.util.Random;
 
public class GamePanel extends JPanel implements ActionListener{
    
    static final int ALTURA_SCREEN =600;
    static final int ANCHURA_SCREEN =600;
    static final int UNIDAD_GAME=10;//Tamaño y proporciones, esto entiendelo como un "pixel" una unidad que creas tu para poder referenciar los tamaños y partir de una base
    //asi cualquier cosa que creas la puedes referenciar en tamaño a una unidad fija ^^
    static final int UNIDAD_JUEGO = (ALTURA_SCREEN * ANCHURA_SCREEN)/UNIDAD_GAME;
    static final int DELAY=75;
    final int x[]= new int[UNIDAD_JUEGO];
    final int y[]= new int[UNIDAD_JUEGO];
    int PartesCuerpo =6;
    int FrutaComida;
    int FrutaX;
    int FrutaY;
    char Direccion = 'R';
    boolean funcionando= false;
    Timer Tiempo;
    Random random;
    
    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(ALTURA_SCREEN, ANCHURA_SCREEN));
        this.setBackground(Color.black);
        this.setFocusable(true);//se usa  para permitir que un componente,//como un botón, un campo de texto o un cuadro de lista, pueda recibir el foco de entrada
        this.addKeyListener(new AdaptadorTeclas());
        StartGame();
    }
    //despues del constructor
    public void StartGame(){
        NuevaFruta();
        funcionando = true;
        Tiempo = new Timer(DELAY,this);
        Tiempo.start();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);     
    }
    public void draw(Graphics g) {
        
        if (funcionando) {
             //esto es para visualizar la cuadricula
            for (int i = 0; i < ANCHURA_SCREEN / UNIDAD_GAME; i++) {
                g.drawLine(i * UNIDAD_GAME, 0, i * UNIDAD_GAME, ANCHURA_SCREEN);
                g.drawLine(0, i * UNIDAD_GAME, ALTURA_SCREEN, i * UNIDAD_GAME);
            }
            
            g.setColor(Color.red);
            g.fillOval(FrutaX, FrutaY, UNIDAD_GAME, UNIDAD_GAME);

            for (int i = 0; i < PartesCuerpo; i++) {
                if(i == 0){
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIDAD_GAME, UNIDAD_GAME);
                }
                else{
                    g.setColor(new Color(45, 180, 0));
                   //para hacerla multicolor por las risas
                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIDAD_GAME, UNIDAD_GAME);
                }
            }
//pegamos la creacion del texto de game over, para usarlo en la puntuacion
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 15));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: "+FrutaComida, (ALTURA_SCREEN - metrics.stringWidth("Score: "+FrutaComida)) / 2, g.getFont().getSize());
        }
        else{
            gameOver(g);
        }
    }
    public void NuevaFruta(){//generar manzanas
        FrutaX = random.nextInt((int)(ALTURA_SCREEN/UNIDAD_GAME))*UNIDAD_GAME;
        FrutaY = random.nextInt((int)(ALTURA_SCREEN/UNIDAD_GAME))*UNIDAD_GAME;
    } 
    public void Mover(){//aqui le quitamos al tamaño del cuerpo el pixel que se mueve
        for(int i=PartesCuerpo; i>0; i--){
            x[i]= x[i-1];
            y[i]=y[i-1];
        }
        switch (Direccion) {
//aqui colocamos las unidades que queremos que sumen o resten para el movimiento, y que resta arriba en cada "pixel" que moveria
            case 'U':
                y[0] = y[0] - UNIDAD_GAME;
                break;
            case 'D':
                y[0] = y[0] + UNIDAD_GAME;
                break;
            case 'L':
                x[0] = x[0] - UNIDAD_GAME;
                break;
            case 'R':
                x[0] = x[0] + UNIDAD_GAME;
                break;
        }
    }
    public void ChequeaFruta(){//
        if((x[0]==FrutaX)&&(y[0]==FrutaY)){
            PartesCuerpo++;
            FrutaComida++;
            NuevaFruta();
         }
    }
    public void ChequeaColisiones(){
        //chequea la colision de la cabeza con el cuerpo
        for(int i= PartesCuerpo; i>0; i--){
            if((x[0]==x[i])&&(y[0]== y[i])){
                funcionando = false;
            }
        }
        //chequea la cabeza contra el borde LH
        if(x[0]<0){
            funcionando = false;
        }   
         //chequea la cabeza contra el borde RH
         if(x[0]>ALTURA_SCREEN){
            funcionando = false;
        }
           //chequea la cabeza contra el borde de arriba
         if(y[0]< 0){
            funcionando = false;
        }
         //chequea la cabeza contra el borde de abajo
         if(y[0]>ANCHURA_SCREEN){
            funcionando = false;
        }
         if(!funcionando){
            Tiempo.stop();
        }
    }
    
   public void gameOver(Graphics g){
       //Puntuacion, para que se vea en la pantalla(aprovechamos lo creado para el GAME OVER y lo modificamos
       g.setColor(Color.red);
       g.setFont(new Font("Ink Free", Font.BOLD, 75));
       FontMetrics metrica1 = getFontMetrics(g.getFont());
       g.drawString("Score: " + FrutaComida, (ALTURA_SCREEN - metrica1.stringWidth("Score: " + FrutaComida)) / 2, g.getFont().getSize());
       //GAME OVER TEXTO
       g.setColor(Color.red);
       g.setFont(new Font("Ink Free",Font.BOLD,75));
       FontMetrics metrica2 = getFontMetrics(g.getFont());
       g.drawString("Game Over",(ALTURA_SCREEN - metrica2.stringWidth("Game Over"))/2,ANCHURA_SCREEN/2);//lo dividimos entre 2 altura y anchura  
   }
    @Override
    public void actionPerformed(ActionEvent e){
            
        if(funcionando){
            Mover();
            ChequeaFruta();
            ChequeaColisiones();
        } 
        repaint();
    }

    public class AdaptadorTeclas extends KeyAdapter{
        //CONTROLES DE LA SERPIENTE
        
        @Override
        public void keyPressed( KeyEvent e){
            switch(e.getKeyCode()){
                //mueve a la izq
                case KeyEvent.VK_LEFT://VK_ es una funcion dentro de la libreria event.Keyevent
                    if(Direccion != 'R'){
                        Direccion = 'L';    
                    }
                    break;
                //mueve a la izq    
                case KeyEvent.VK_RIGHT:
                    if(Direccion != 'L'){
                        Direccion = 'R';    
                    }
                    break;
                //mueve a la izq    
                case KeyEvent.VK_UP:
                    if(Direccion != 'D'){
                        Direccion = 'U';    
                    }
                    break;
                //mueve a la izq
                case KeyEvent.VK_DOWN:
                    if(Direccion != 'U'){
                        Direccion = 'D';    
                    }
                    break;
            }
        }
    }
}