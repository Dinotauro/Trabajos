import java.util.*;
public class Encuentra_el_numero {
 public static void main(String[]args) {
	 Random r = new Random();
	 Scanner sc = new Scanner(System.in);
	 int aleatorio = r.nextInt(100);
	 System.out.println("ingresa el Numero que adivine");
	 for(int i = 1;i > 5;i++) {
		 int hola = sc.nextInt();
		 if(aleatorio < hola ) {
			 if (aleatorio == hola){
				 System.out.println("El numero es correcto");
				 i = 5;
			 }else System.out.println("es un numero mayor");
		 }else System.out.println("Es un numero menor");
		 
	 							}
	 sc.close();
 }
}
