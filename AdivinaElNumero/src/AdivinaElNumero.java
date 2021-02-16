import java.util.Scanner;

public class AdivinaElNumero {
    private Scanner entrada = new Scanner(System.in);
    private boolean juegoActivo = true;

    public void jugar(){
        String nombreJugador = obtenerNombreJugador();
        while(juegoActivo){
            int intentos = 0;
            int min = 0;
            int max = 100;
            int numeroJuego = obtenerNumeroAleatorio(1, 100);

            System.out.printf("%s, he escogido un número entre %d y %d, adivínalo\n", nombreJugador, min, max);
            int numeroJugador;

            do {
                numeroJugador = escogerNumero();
                mensaje(numeroJuego, numeroJugador);
                intentos++;
            } while (numeroJuego != numeroJugador);

            System.out.printf("Has ganado, intentos %d\n\n", intentos);

            juegoActivo = jugarNuevamente();
        }
    }

    private int obtenerNumeroAleatorio(int min, int max){
        return min + (int) (Math.random() * ((max - min) +1));
    }

    private String obtenerNombreJugador(){
        System.out.println("");
        System.out.println("JUEGO - ADIVINA EL NÚMERO");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Hola, ¿cuál es tú nombre?");
        String nombreJugador = entrada.nextLine();
        System.out.printf("Bueno %s, comencemos con el juego\n", nombreJugador);
        return nombreJugador;
    }

    private int escogerNumero(){
        System.out.println("Escoge un número.");
        return entrada.nextInt();
    }

    private void mensaje(int numeroJuego, int numeroJugador){
        if (numeroJuego < numeroJugador) {
            System.out.println("El número es más bajo, intentalo denuevo.");
        } else if (numeroJuego > numeroJugador) {
            System.out.println("El número es más alto, intentalo denuevo.");
        }
    }

    public boolean jugarNuevamente(){
        System.out.println("¿Quieres volver a jugar?\n1. Sí\n2. No");
        int respuesta = entrada.nextInt();
        if (respuesta == 1){
            System.out.println("¡Okay, juguemos denuevo!");
            return true;
        }else{
            System.out.println("Fin del juego, espero verte pronto.");
            return false;
        }
    }
}
