package UNIDAD3DINAMICA;

public class PilaD <T>{
	
	
	private Nodo<T> tope;
	private Nodo<T> nuevo;
	private T       dr;
	
	public PilaD() {
		tope=null;
	}
	
	public boolean Insertar(T dato) {
		if(!CrearNodo(dato))
			return false;
		if(tope==null) {
			tope=nuevo;
			return true;
		}
		nuevo.setSig(tope);
		tope=nuevo;
		return true;
	}
	public boolean Retirar() {
		if(Vacia())
			return false;
		dr=tope.getInfo();
		tope=tope.getSig();
		return true;
	}
	public  boolean Vacia() {
		return tope==null;
	}
	public boolean Llena() {
		return !CrearNodo(null);
	}
	private boolean CrearNodo(T dato) {
		try {
			nuevo=new Nodo(dato);
		} catch(Error e) {
			return false;
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	public T getDr() {
		return dr;
	}
}
