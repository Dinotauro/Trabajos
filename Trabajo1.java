import java.util.Scanner;

public class Trabajo1 {
    private Scanner scanner = new Scanner(System.in);
    private byte numeroMes;
    private String nombreMes;

    public Trabajo1() {
        solicitarNumero();
        determinarNombreMes();
        mostrarNombreMes();
    }

    private void solicitarNumero() {
        System.out.println("Ingresa un número del 1 al 12:");
        numeroMes = scanner.nextByte();
    }

    private void determinarNombreMes() {
        switch (numeroMes) {
            case 12 -> nombreMes = "Es Diciembre";
            case 11 -> nombreMes = "Es Noviembre";
            case 10 -> nombreMes = "Es Octubre";
            case 9 -> nombreMes = "Es Septiembre";
            case 8 -> nombreMes = "Es Agosto";
            case 7 -> nombreMes = "Es Julio";
            case 6 -> nombreMes = "Es Junio";
            case 5 -> nombreMes = "Es Mayo";
            case 4 -> nombreMes = "Es Abril";
            case 3 -> nombreMes = "Es Marzo";
            case 2 -> nombreMes = "Es Febrero";
            case 1 -> nombreMes = "Es Enero";
            default -> nombreMes = "No Existe";
        }
    }

    private void mostrarNombreMes() {
        System.out.println("Este mes: " + nombreMes);
    }
}



