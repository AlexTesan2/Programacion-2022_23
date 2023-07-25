package E10MasterMaind2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class MasterMaind extends Applet {

    public static final int FILAS = 12;
    public static final int COLUMNAS = 4;
    public static final int NFICHAS = 5;
    public static final int NFICHASB = 10;
    public int elementos_fila = 0;
    public int fila_actual = 1;
    public int correctos = 0;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Casilla tablero[][];
    Casilla tablerosol[][];
    public int valores[] = {1, 2, 3, 4, 5};
    Image imagenes[];
    Image fichanegra;
    Image fichablanca;
    Ficha fichasinc[];
    Ficha fichas[][];
    Ficha actual;

    public void init() {
        this.setSize(1000, 900);

        imagen = this.createImage(1000, 900);
        noseve = imagen.getGraphics();

        imagenes = new Image[NFICHAS];
        for (int i = 0; i < NFICHAS; i++) {
            imagenes[i] = getImage(getCodeBase(), "E10Ims/f" + (i + 1) + ".jpg");
        }
        

        tablero = new Casilla[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = new Casilla((j * Casilla.DIMENSION) + 50, i * Casilla.DIMENSION, (i * COLUMNAS) + j + 1, Color.WHITE);
            }
        }

        tablerosol = new Casilla[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablerosol[i][j] = new Casilla((j * Casilla.DIMENSION) + 300, i * Casilla.DIMENSION, (i * COLUMNAS) + j + 1, Color.BLACK);
            }
        }

        fichas = new Ficha[NFICHAS][NFICHASB];
        for (int i = 0; i < NFICHAS; i++) {
            for (int j = 0; j < NFICHASB; j++) {
                fichas[i][j] = new Ficha(imagenes[i], (i * 60) + 600, 150, false);
            }
        }
        fichanegra = getImage(getCodeBase(), "E08Ims/re.jpg");
        fichablanca = getImage(getCodeBase(), "E08Ims/d2.jpg");

        fichasinc = new Ficha[COLUMNAS];
        for (int i = 0; i < COLUMNAS; i++) {
            int aleatorio = (int) (Math.random() * 5);
            fichasinc[i] = new Ficha(imagenes[aleatorio], (i * 60) + 55, 5, true);
        }
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 0, 1000, 900);

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j].paint(noseve);
            }
        }

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablerosol[i][j].paint(noseve);
                if(tablerosol[i][j].getFicha()!=null)
                    tablerosol[i][j].getFicha().paint(noseve, this);
            }
        }

        for (int i = 0; i < NFICHAS; i++) {
            for (int j = 0; j < NFICHASB; j++) {
                fichas[i][j].paint(noseve, this);
            }
        }

        for (int i = 0; i < COLUMNAS; i++) {
            fichasinc[i].paint(noseve, this);
        }

                
        g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public boolean action(Event ev, Object obj) {

        return false;
    }

    public boolean mouseDown(Event ev, int x, int y) {
        for (int i = 0; i < NFICHAS; i++) {
            for (int j = 0; j < NFICHASB; j++) {
                if (fichas[i][j].contains(x, y)) {
                    actual = fichas[i][j];
                    //break;
                }
            }
        }

        return true;
    }

    public boolean mouseDrag(Event ev, int x, int y) {
        if (actual != null) {
            actual.move(x - (Ficha.DIMENSION / 2), y - (Ficha.DIMENSION / 2));
            repaint();
        }
        return true;
    }

    public boolean mouseUp(Event ev, int x, int y){ 
        if(elementos_fila != 4)
            if (tablero[fila_actual][elementos_fila].contains(actual)) {
                if (tablero[fila_actual][elementos_fila].getFicha() == null) {
                    tablero[fila_actual][elementos_fila].setFicha(actual);
                    actual.move(tablero[fila_actual][elementos_fila].x + 5, tablero[fila_actual][elementos_fila].y + 5);
                    if(tablero[fila_actual][elementos_fila].getFicha().getImagen() == fichasinc[elementos_fila].getImagen()){
                        tablerosol[fila_actual][elementos_fila].setFicha(new Ficha(fichablanca,tablerosol[fila_actual][elementos_fila].x + 5, tablerosol[fila_actual][elementos_fila].y + 5, false));
                        correctos++;
                    }
                    for(int i=0; i<4; i++)
                        if(elementos_fila != i)
                            if(tablero[fila_actual][elementos_fila].getFicha().getImagen() == fichasinc[i].getImagen())
                                if(tablerosol[fila_actual][elementos_fila].getFicha()==null)
                                    tablerosol[fila_actual][elementos_fila].setFicha(new Ficha(fichanegra,tablerosol[fila_actual][elementos_fila].x + 5, tablerosol[fila_actual][elementos_fila].y + 5, false));
                        
                    elementos_fila++;
                }
            }
        actual = null;
        if(correctos == 4)
            for(int i=0; i<4; i++)
                fichasinc[i].tapada = false;
        
        if(elementos_fila > 3){
            elementos_fila = 0;
            correctos = 0;
            fila_actual++;
        }
        repaint();
        return true;
    }
}
