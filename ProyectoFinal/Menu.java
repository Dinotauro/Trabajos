package A123b;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner var = new Scanner(System.in);
		int Numero = 0;
		
		System.out.println("Ingrece el Numero para seleccionar una opcion");
		System.out.println("1:Buscador de Productos");
		System.out.println("2:Agregar Produccto");
		System.out.println("3:Eliminar Producto");
		System.out.println("4:Importar Producto en Formato Pfd");
		Numero = var.nextInt();
			switch(Numero) {
			case(1):String Nombre = var.next(); ProductSearch.displayProducts(null);;
			case(2):
			case(3):
			case(4):
			}
	}

}
