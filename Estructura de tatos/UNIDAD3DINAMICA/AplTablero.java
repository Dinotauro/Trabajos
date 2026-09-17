package UNIDAD3DINAMICA;

import U1.Rutinas;

public class AplTablero {

	public static void main(String[] args) {
        // Parámetros del juego
        int totalCasillas = 100;   // tablero de 100 casillas
        int numJugadores = 3;      // entre 2 y 5

        // Crear tablero
        Tablero tablero = new Tablero(totalCasillas);
        
        // Generar escaleras y serpientes (aleatorias según reglas)
        tablero.GenerarEscaleras();
        tablero.GenerarSerpientes();
        
        // Insertar jugadores
        for (int i = 1; i <= numJugadores; i++) {
            tablero.InsertarJugadores(i);
        }
        
        System.out.println("\n¡COMIENZA EL JUEGO DE SERPIENTES Y ESCALERAS!");
        System.out.println("Tablero de " + totalCasillas + " casillas. Meta: casilla " + totalCasillas);
        System.out.println("--------------------------------------------------------\n");
        
        int turno = 1;
        boolean juegoTerminado = false;
        
        while (!juegoTerminado) {
            int idJugador = turno;  // los IDs son 1,2,3,...
            int dado = Rutinas.nextInt(2, 13); // tirada entre 2 y 12
            
            System.out.println("--- Turno del Jugador " + idJugador + " ---");
            System.out.println("  Dado: " + dado);
            
            String resultado = tablero.jugar(idJugador, dado);
            System.out.println("  " + resultado);
            
            // Verificar si el jugador ganó
            if (tablero.haGanado(idJugador)) {
                System.out.println("\n¡¡¡ JUGADOR " + idJugador + " HA GANADO !!!");
                juegoTerminado = true;
            } else {
                // Avanzar al siguiente jugador (turno cíclico)
                turno = (turno % numJugadores) + 1;
                System.out.println(); // línea en blanco para separar turnos
            }
        }
        
        System.out.println("\nFin del juego.");
    }
}


