package UNIDAD3DINAMICA;
import U1.Rutinas;
import U3Estatica.*;
public class Apl {

	public static void main(String[] args) {
		
		Lista<Integer> lista = new Lista();
		
		System.out.println(lista.InsertarFin(10));
		System.out.println(lista.InsertarFin(200));
		System.out.println(lista.InsertarFin(30));
		System.out.println(lista.InsertarFin(10));
		System.out.println(lista.InsertarFin(11));
		System.out.println(lista.InsertarFin(33));
		System.out.println(lista.InsertarFin(66));
		System.out.println(lista.InsertarFin(55));
System.out.println("Tamaño de la lista "+lista.length());
		System.out.println(lista.Retirar(2));
		System.out.println("Tamaño de la lista "+lista.length());		
		
		while( lista.length()>0) {
		    lista.Retirar(Rutinas.nextInt(1,lista.length()));	
		}
		
		System.out.println("Tamaño de la lista "+lista.length());		
	
		
		Nodo<Integer> aux=lista.getFrente();
		while(aux !=null) {
			System.out.println(aux.getInfo());
			aux=aux.getSig();
		}
		
		
	}

}
