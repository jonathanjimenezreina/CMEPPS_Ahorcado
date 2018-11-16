package ahorcado;

import java.io.IOException;
import java.util.Scanner;

public class Ahorcado {

    public static void main(String[] args) throws IOException {
        int numVidas = 6;
        String asteriscos = "";
        String palabra = "";
        String letra = "";
        int tamañoPalabra;
        System.out.println("Bienvenidos!!");
        System.out.println("Jugador 1, inserta una palabra para adivinar: ");
        Scanner teclado = new Scanner(System.in);
        palabra = teclado.next();
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
        tamañoPalabra = palabra.length();

        for (int i = 0; i < tamañoPalabra; i++) {
            asteriscos = asteriscos + "*";
        }

        System.out.println("COMIENZA EL JUEGO Jugador 2");

        while (true && numVidas >= 0) {

            if (!asteriscos.contains("*")) {
                System.out.println("Enhorabuena, has acertado la palabra: " + palabra);
                System.out.println("El juego ha terminado");
                break;
            }

            System.out.println("El ahorcado (Te quedan " + numVidas + " vidas): " + asteriscos);

            System.out.println("Inserte una letra jugador 2: ");
            letra = teclado.next();
            if (letra.length() > 1) {
                while (letra.length() > 1) {
                    System.out.println("Inserte UNA letra jugador 2: ");
                    letra = teclado.next();
                }
            }

            if (palabra.contains(letra)) {
                char ch = letra.charAt(0);
                for (int i = 0; i < palabra.length(); i++) {
                    char[] c = palabra.toCharArray();
                    if (c[i] == letra.charAt(0)) {
                        asteriscos = asteriscos.substring(0, i) + ch + asteriscos.substring(i + 1, asteriscos.length());
                    }
                }
            } else {
                System.out.println("Ohh! Palabra no valida");
                numVidas--;
                if (numVidas < 0) {
                    System.out.println("Juego terminado, te has quedado sin vidas");
                    break;
                }
            }
        }
    }
}
