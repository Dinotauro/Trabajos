package U3Estatica;
public class ColaCir <T> {
	private T [] cola;
	private int  frente,fin;
	private T    dr;
	private int  tamaño;
	
	public ColaCir() {
		this(10);
	}
	public ColaCir(int tamaño) {
		this.tamaño=tamaño;
		frente=fin=-1;
		cola=(T[]) new Object[tamaño];
	}
	public boolean Insertar(T dato) {
		if(Llena())
			return false;
		if(fin==tamaño-1)
			fin=0;
		else 
			fin++;
		cola[fin]=dato;
		if(frente==-1)
			frente=0;
		return true;
	}
	public boolean Retirar() {
		if( Vacia())
			return false;
		dr=cola[frente];
		cola[frente]=null;
		if(frente==fin)
			frente=fin=-1;
		else
			if(frente==tamaño-1)
				frente=0;
			else
				frente++;
		
		return true;
	}
	public boolean Llena() {
		return frente==0 && fin==tamaño-1 || fin+1==frente;
	}
	public boolean Vacia() {
		return frente==-1 && fin==-1;
	}
	public T getDr() {
		return dr;
	}
}
