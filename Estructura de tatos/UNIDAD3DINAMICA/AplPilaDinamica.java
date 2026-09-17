package UNIDAD3DINAMICA;

public class AplPilaDinamica {

	public static void main(String[] args) {
		ColaD<MiEntero> pila = new ColaD();
		ColaD<MiEntero> pilaAux = new ColaD();
		int cont=0;
		while(!pila.Llena()) {

			pila.Insertar(new MiEntero(cont));
			System.out.println(++cont);
		}
//		System.out.println(pila.Insertar(new MiEntero(2)));
//		System.out.println(pila.Insertar(new MiEntero(3)));
//		System.out.println(pila.Insertar(new MiEntero(4)));
//		System.out.println(pila.Insertar(new MiEntero(5)));

		
		while(pila.Retirar()  && pilaAux.Insertar(pila.getDr()) ) {
			System.out.println(pila.getDr().getNumero());
		}
		while(pilaAux.Retirar() && pila.Insertar(pilaAux.getDr()));
	}

}
