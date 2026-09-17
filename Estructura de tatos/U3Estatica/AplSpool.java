package U3Estatica;

public class AplSpool {

	public static void main(String[] args) {
		
		Spool spool=new Spool(5);
		
		

		System.out.println(spool.Enviar(new Reporte(1,200,3)));
		System.out.println(spool.Enviar(new Reporte(2,200,3)));
		System.out.println(spool.Enviar(new Reporte(3,200,3)));
		System.out.println(spool.Enviar(new Reporte(4,200,3)));
		System.out.println(spool.Enviar(new Reporte(5,200,3)));
		System.out.println(spool.Enviar(new Reporte(6,200,3)));
		Reporte reporte;
//		while( spool.Imprimir()) {
//			reporte=spool.getDr();
//			System.out.println(reporte.getNoComp()+"   "+reporte.getNoHojas()+"   "+reporte.getTipoExtension());
//		}
		System.out.println(spool.EstadoActual());
		System.out.println("___________________");
		System.out.println(spool.EstadoActual());
		System.out.println("___________________");
	}

}
