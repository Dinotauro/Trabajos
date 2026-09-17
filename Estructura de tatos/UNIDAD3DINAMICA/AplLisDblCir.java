package UNIDAD3DINAMICA;

public class AplLisDblCir {

	public static void main(String[] args) {
		ListaDblCir<Integer> lista = new ListaDblCir();
		
		System.out.println(lista.InsertarOrd(110));
		System.out.println(lista.InsertarOrd(100));
		System.out.println(lista.InsertarOrd(700));
		System.out.println(lista.InsertarOrd(300));
		System.out.println(lista.InsertarOrd(190));
		System.out.println(lista.InsertarOrd(900));
		System.out.println(lista.InsertarOrd(190));

		if(lista.Buscar(300)) {
			System.out.println("EL 3000 SI SE ESTÁ EN LA LISTA");
			System.out.println(lista.Retirar(new Integer(300)));
		}
		NodoDbl<Integer> aux=lista.getFrente();
		while( aux!=null) {
			System.out.println(aux.getInfo());
			if(aux==lista.getFin())
				break;
			aux=aux.getSig();
			
		}
	}

}
