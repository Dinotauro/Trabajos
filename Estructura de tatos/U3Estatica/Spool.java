package U3Estatica;

public class Spool {
	private int tamaño;
	private Cola<Reporte> cola;
	
	public Spool() {
		this(10);
	}
	public Spool(int tamaño) {
		cola=new Cola(tamaño);
		this.tamaño=tamaño;
	}
	
	public boolean Enviar(Reporte reporte) {
		
		return cola.Insertar(reporte);
	}
	public boolean Imprimir() {
		return cola.Retirar();
	}
	public String EstadoActual() {
		Cola<Reporte> colaAux=new Cola(tamaño) ;
		String res="";
		while ( cola.Retirar() && colaAux.Insertar(cola.getDr())) {
			
			res+=String.format("%4d %4d  %4d \n", cola.getDr().getNoComp(),cola.getDr().getNoHojas(),cola.getDr().getTipoExtension());
		}
		while(colaAux.Retirar() && cola.Insertar(colaAux.getDr()));
		return res;
		
	}
	public Reporte getDr() {
		return cola.getDr();
	}
}
