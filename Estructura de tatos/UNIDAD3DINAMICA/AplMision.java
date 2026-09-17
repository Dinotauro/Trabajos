package UNIDAD3DINAMICA;

public class AplMision {

	public static void main(String[] args) {
		Mision miss = new Mision();
		miss.InsertarSoldado(100);
		miss.InsertarSoldado(110);
		miss.InsertarSoldado(120);
		miss.InsertarSoldado(130);
		miss.InsertarSoldado(140);
		miss.Imprimir();
		miss.Jugar(4);
		System.out.print(miss.getInicio());
		System.out.println("---------------------");
		miss.Imprimir();
		miss.Jugar(3);
		System.out.print(miss.getInicio());
		System.out.println("---------------------");
		miss.Imprimir();
		miss.Jugar(5);
		System.out.print(miss.getInicio());
		System.out.println("---------------------");
		miss.Imprimir();
		miss.Jugar(8);
		System.out.print(miss.getInicio());
		System.out.println("---------------------");
		miss.Imprimir();
	}

}
