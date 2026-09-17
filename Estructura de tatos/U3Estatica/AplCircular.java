package U3Estatica;

public class AplCircular {

	public static void main(String[] args) {
		ColaCir<Integer> cola =  new ColaCir(8);
		ColaCir<Integer> colaAux =  new ColaCir(8);
		
		System.out.println(cola.Insertar(1));
		System.out.println(cola.Insertar(2));
		System.out.println(cola.Insertar(3));
		System.out.println(cola.Insertar(4));
		System.out.println(cola.Insertar(5));
//		cola.Retirar();
//		cola.Retirar();
		System.out.println(cola.Insertar(6));
		System.out.println(cola.Insertar(7));
		System.out.println(cola.Insertar(4));
		
		int numeroRetirar=4;
		while(cola.Retirar()) {
			if(cola.getDr()==numeroRetirar)
				break;
			colaAux.Insertar(cola.getDr());
		}
		while(cola.Retirar() && colaAux.Insertar(cola.getDr()));
		while(colaAux.Retirar() && cola.Insertar(colaAux.getDr()));

		EstadoActual(cola);
	}
	
	public static void EstadoActual(ColaCir<Integer> cola) {
		ColaCir<Integer> colaAux =  new ColaCir(8);
		while(cola.Retirar() && colaAux.Insertar(cola.getDr())) {
			System.out.println(cola.getDr());
		}
		while(colaAux.Retirar() && cola.Insertar(colaAux.getDr()));
	}

}
