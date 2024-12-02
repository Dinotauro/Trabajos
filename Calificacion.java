import java.util.Scanner;
public class Calificacion {

	public static void main(String[]args) {
		int calificacion;
		Scanner scan = new Scanner(System.in);
		System.out.println("Escribe la calificacion (o - 100");
		calificacion = scan.nextInt();
		if (calificacion >= 70) {
			System.out.println("Aprobado");
		}else System.out.println("Reprovado");
		scan.close();
	}
}
