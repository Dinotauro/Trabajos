package ProyectoU3Estatica;

public class Cola <T>{
	
	protected T [] cola;
	protected T    dr;
	protected int frente, fin;
	protected int tamaño;
	
	public Cola() {
		this(10);
	}
	public Cola(int tamaño) {
		this.tamaño=tamaño;
		cola=(T[]) new Object[tamaño];
		frente=fin=-1;
	}
	
	public boolean Insertar(T dato) {
		if(Llena())
			return false;
//		fin++;
//		cola[fin]=dato;
//		if(frente==-1)
//			frente=0;
		if(fin==-1)
			frente=fin=0;
		else
			fin++;
		cola[fin]=dato;
		return true;
	}
	public boolean Retirar() {
		if(Vacia())
			return false;
		dr=cola[frente];
		cola[frente]=null;
		if( frente == fin ) {
			frente=fin=-1;
		}
		else 
			frente++;
		
		return true;
	}
	public boolean Llena() {
		return fin==tamaño-1;
	}
	public boolean Vacia() {
		return frente==-1;
	}
	public T getDr() {
		return dr;
	}

}
