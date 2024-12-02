import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Ingrese su nombre");
        Scanner primer = new Scanner(System.in);
        String Nombre = primer.nextLine();
        System.out.println("Bienvenido " + Nombre);
        primer.close();
    }


    }



