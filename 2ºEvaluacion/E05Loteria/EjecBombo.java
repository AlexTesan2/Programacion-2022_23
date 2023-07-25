package E05Loteria;
public class EjecBombo {
        public static void main(String[] args) {
        Bombo bombo = new Bombo();
        int tabla[][]=new int [6][8];
        cargarTabla(tabla, bombo);
        mostrarTabla(tabla);
        
    }

    private static void cargarTabla(int[][] tabla, Bombo bombo) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j]=bombo.sacar();
            }
        }
    }

    private static void mostrarTabla(int[][] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j]+"  ");
            }
            System.out.println("");
        }
    }
}
