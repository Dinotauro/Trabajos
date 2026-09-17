package U3Estatica;

public class Pila <T>{
	
	private int tamaño;
	private int tope;
	private T [] v;
	private T dr;
	

	public Pila() {
		this(10);
	}
	public Pila(int tamaño) {
		this.tamaño=tamaño;
		tope=-1;
		v=(T[]) new Object[tamaño];
	}
	public boolean Insertar(T dato) {
		if(Llena())
			return false;
		tope++;
		v[tope]=dato;
		return true;
	}
	public boolean Retirar() {
		if(Vacia()) {
			dr=null;
			return false;
		}
		dr=v[tope];
		v[tope]=null;
		tope--;
		return true;
	}
	public boolean Vacia() {
		return tope==-1;
	}
	public boolean Llena() {
		return tope==tamaño-1;
		
//		if(tope==tamaño-1)
//			return true;
//		return false;
		
//		return (tope==tamaño-1)?true:false;
	}
	public T getDr() {
		return dr;
	}
}
