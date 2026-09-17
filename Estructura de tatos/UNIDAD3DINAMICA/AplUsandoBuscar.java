package UNIDAD3DINAMICA;

public class AplUsandoBuscar {

	public static void main(String[] args) {
		Lista<MiEntero> lista=new Lista();
		
		lista.InsertarOrd(new MiEntero(100));
		lista.InsertarOrd(new MiEntero(500));
		lista.InsertarOrd(new MiEntero(1600));
		lista.InsertarOrd(new MiEntero(200));
		lista.InsertarOrd(new MiEntero(1300));
		lista.InsertarOrd(new MiEntero(400));
		Nodo<MiEntero> aux=lista.getFrente();
		
		while(aux!=null) {
			
			System.out.println(aux.getInfo().getNumero());
			aux=aux.getSig();
		}
	}

}
