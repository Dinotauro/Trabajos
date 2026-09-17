package UNIDAD3DINAMICA;

public class ColaD <T>{
	private Nodo<T> frente;
	private Nodo<T> fin;
	private Nodo<T> nuevo;
	private T       dr;
	
	public ColaD() {
		frente=fin=nuevo=null;
		dr=null;
	}
	public boolean Insertar(T dato) {
		if(!CrearNodo(dato))
			return false;
		if(fin==null) {
			frente=fin=nuevo;
			return true;
		}
		fin.setSig(nuevo);
		fin=nuevo;
		return true;
	}
	public boolean Retirar() {
		if(Vacia())
			return false;
		dr=frente.getInfo();
		frente=frente.getSig();
		return true;
	}
	public  boolean Vacia() {
		return frente==null;
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
