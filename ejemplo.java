import java.util.Scanner;
public class ejemplo {
    static Scanner ss = new Scanner(System.in);
    public static void main(String[] args) {}
    byte Na;
    public byte Nb;{
        System.out.println("Ingresa un Numero del 1 al 12");
        Na = ss.nextByte();
    }
    public void prueba(byte Na){
        switch (Na) {
            case 12:System.out.println("Es Diciembre");
            break;
            case 11:System.out.println("Es Noviembre");
            break;
            case 10:System.out.println("Es Octubre");
            case 9:System.out.println("Es Septiembre");
            case 8:System.out.println("Es Agosto");
            case 7:System.out.println("Es Julio");
            case 6:System.out.println("Es Junio");
            case 5:System.out.println("Es Mayo");
            case 4:System.out.println("Es Abril");
            case 3:System.out.println("Es Marzo");
            case 2:System.out.println("Es Febrero");
            case 1:System.out.println("Es Enero");
            default:System.out.println("No Existe");
            break;

        }
    }
}

