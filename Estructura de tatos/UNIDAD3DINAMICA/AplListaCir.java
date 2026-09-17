package UNIDAD3DINAMICA;

public class AplListaCir {

	public static void main(String[] args) {
		ListaCir<MiEntero> lista=new ListaCir();
		
		System.out.println(lista.InsertarOrd(new MiEntero(100)));
		System.out.println(lista.InsertarOrd(new MiEntero(20)));
		System.out.println(lista.InsertarOrd(new MiEntero(13)));
		System.out.println(lista.InsertarOrd(new MiEntero(45)));
		System.out.println(lista.InsertarOrd(new MiEntero(15)));
		System.out.println(lista.InsertarOrd(new MiEntero(16)));
		System.out.println(lista.InsertarOrd(new MiEntero(70)));
		System.out.println(lista.InsertarOrd(new MiEntero(18)));
		System.out.println(lista.InsertarOrd(new MiEntero(90)));
		System.out.println(lista.InsertarOrd(new MiEntero(10)));
		System.out.println(lista.InsertarOrd(new MiEntero(19)));
		System.out.println(lista.InsertarOrd(new MiEntero(120)));

		Imprimir(lista);
System.out.println("______");
lista.Retirar(1);
lista.Retirar(5);
lista.Retirar(lista.length());
lista.Retirar(new MiEntero(90));
Imprimir(lista);

	}
	public static void Imprimir(ListaCir<MiEntero> lista) {
		Nodo<MiEntero> aux = lista.getFrente();
		
		while(aux!= null) {
			System.out.println(aux.getInfo().getNumero());
			if(aux==lista.getFin())
				break;
			aux=aux.getSig();
		}

	}
}
