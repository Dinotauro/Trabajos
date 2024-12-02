import java.util.Scanner;

public class Trabajo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte numero;
        String mes;
       do {
           System.out.println("Ingresa un número del 1 al 12:");
           numero = sc.nextByte();
       }

      while (numero < 1 || numero > 12);{
            switch (numero) {
                case 12 -> mes = "Es Diciembre";
                case 11 -> mes = "Es Noviembre";
                case 10 -> mes = "Es Octubre";
                case 9 -> mes = "Es Septiembre";
                case 8 -> mes = "Es Agosto";
                case 7 -> mes = "Es Julio";
                case 6 -> mes = "Es Junio";
                case 5 -> mes = "Es Mayo";
                case 4 -> mes = "Es Abril";
                case 3 -> mes = "Es Marzo";
                case 2 -> mes = "Es Febrero";
                case 1 -> mes = "Es Enero";
                default -> mes = "No Existe";
            }
        }

        
        System.out.println("Este mes " + mes);
        sc.close();
    }
}