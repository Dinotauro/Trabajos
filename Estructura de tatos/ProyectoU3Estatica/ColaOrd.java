package ProyectoU3Estatica;

public class ColaOrd<T> extends Cola<T>{
	private int tamaño;
	public ColaOrd() {
		this(10);
	}
	public ColaOrd(int tamaño) {
		super(tamaño);
		this.tamaño=tamaño;
	}
	
	public boolean Insertar(T dato) {
		String criterioNuevo=dato.toString();
		String criterioRet;
		boolean ban=false;
		Cola<T> colaAux=new Cola(tamaño);
		while( Retirar()) {
			criterioRet=getDr().toString();
			if( criterioNuevo.compareTo(criterioRet) < 0 ) {
				colaAux.Insertar(dato);
				colaAux.Insertar(getDr());
				ban=true;
				break;
	
			}
			colaAux.Insertar(getDr());
		}
		if( !ban)
			colaAux.Insertar(dato);
		while(Retirar() && colaAux.Insertar(getDr()));
		while(colaAux.Retirar() && super.Insertar(colaAux.getDr()));
		return true;
	}
}
