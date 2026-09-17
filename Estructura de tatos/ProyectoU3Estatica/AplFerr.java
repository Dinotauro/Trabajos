package ProyectoU3Estatica;

public class AplFerr {

	public static void main(String[] args) {
		Ferrocarril fer = new Ferrocarril();
			fer.InsertarVagones();
			System.out.println("////////Vagones Asignados///////////");
			fer.imprimir();
			System.out.println("///////Vagones Insertados////////////");
			fer.InsertarTren();
			fer.InsertarVagones();
			fer.imprimir();
			System.out.println(fer.getTam());
	}

}
