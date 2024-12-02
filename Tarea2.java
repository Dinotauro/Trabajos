import java.util.Scanner;

public class Tarea2 {
    static Scanner Numeros = new Scanner(System.in);

    public static void main(String[] args) {
        double Y = 0;
        double X = 10;
        System.out.println("Ingrese un Numero Entero");
        int Numero1 = Numeros.nextInt();
        while (Numero1 >= X) {
            X = Math.pow(10,Y= Y + 1);
        }
        System.out.println("El numero de Cifras es: " + (int) Y);
    }
}