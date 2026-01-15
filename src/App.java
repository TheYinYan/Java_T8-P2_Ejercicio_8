public class App {
    public static final String RESET = "\033[0m"; // Text Reset
    public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
    public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

    public static void main(String[] args) throws Exception {
        int filas = 8;
        int columna = 8;

        boolean negro = false;
        boolean blanco = false;

        String[][] tablero = new String[filas][columna];
        int[][] alfil = new int[filas][columna];
        alfil[3][3] = 1;

        String[] letras = { "a", "b", "c", "d","e", "f", "g", "h" };

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                tablero[i][j] = (j == 0 && i % 2 == 0) ? "negro" : "blanco";
                tablero[i][j] = (j == 0 && i % 2 == 0) ? "negro" : "blanco";

                if (j != 0 && tablero[i][(j == 0) ? j : j - 1] == "negro") {
                    tablero[i][j] = "blanco";
                }
                if (j != 0 && tablero[i][(j == 0) ? j : j - 1] == "blanco") {
                    tablero[i][j] = "negro";
                }
            }
        }

        for (int i = -1; i <= filas; i++) {
            for (int j = -1; j <= columna; j++) {
                // Espacios
                if (i == -1 && j == -1) {
                    System.out.printf("%s", "  ");
                }
                if (i == filas && j == -1) {
                    System.out.printf("%s", "  ");
                }
                // Numeros
                if (i == -1 && j >= 0 && i < filas && j < columna) {
                    System.out.printf(" %s ", letras[j]);
                }
                if (i >= 0 && j == -1 && i < filas && j < columna) {
                    System.out.printf("%d ", filas - i);
                }
                // Letras
                if (i >= 0 && j >= 0 && i < filas && j == columna) {
                    System.out.printf(" %d", filas - i);
                }
                if (i >= 0 && j >= 0 && i == filas && j < columna) {
                    System.out.printf(" %s ", letras[j]);
                }
                // Tablero
                if (i >= 0 && j >= 0 && i < filas && j < columna && tablero[i][j].equals("negro")) {
                    System.out.printf("%s", BLACK_BACKGROUND + ((alfil[i][j] == 1) ? " a " : "   ") + RESET);
                }
                if (i >= 0 && j >= 0 && i < filas && j < columna && tablero[i][j].equals("blanco")) {
                    System.out.printf("%s", WHITE_BACKGROUND + ((alfil[i][j] == 1) ? " a " : "   ") + RESET);
                }
            }
            System.out.println();
        }
    }
}
