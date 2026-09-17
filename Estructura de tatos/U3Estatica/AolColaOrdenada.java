package U3Estatica;

public class AolColaOrdenada {

	public static void main(String[] args) {
		ColaOrd<Reporte> cola =  new ColaOrd(10);
		
		System.out.println(cola.Insertar(new Reporte(7,10,3)));
		System.out.println(cola.Insertar(new Reporte(7,2,3)));
		System.out.println(cola.Insertar(new Reporte(10,50,3)));
		System.out.println(cola.Insertar(new Reporte(7,1,3)));
		System.out.println(cola.Insertar(new Reporte(10,6,3)));
		System.out.println(cola.Insertar(new Reporte(10,3,3)));
		System.out.println(cola.Insertar(new Reporte(7,8,3)));
		
		
		
		while(cola.Retirar()) {
			System.out.printf("%4d %4d %4d\n",cola.getDr().getNoComp(),
					cola.getDr().getNoHojas(),
					cola.getDr().getTipoExtension());
		}
	}

}
