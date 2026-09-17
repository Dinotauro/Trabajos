package UNIDAD3DINAMICA;

public class ListaCir <T> {
	private Nodo<T> frente;
	private Nodo<T> fin;
	private Nodo<T> nuevo;
	private T       dr;
	
	public ListaCir() {
		frente=fin=null;
	}
	
	public boolean InsertarFin(T dato) {
		if( ! CrearNodo(dato))
			return false;
		if( frente==null) {
			nuevo.setSig(nuevo);
			frente=fin=nuevo;
		}
		else {
			fin.setSig(nuevo);
			fin=nuevo;
			fin.setSig(frente);
		}
		
		return true;
	}
	public boolean InsertarFrente(T dato) {
		if( ! CrearNodo(dato))
			return false;
		if( frente==null) {
			frente=fin=nuevo;
			nuevo.setSig(nuevo);
		}
		else {
			nuevo.setSig(frente);
			frente=nuevo;
			fin.setSig(frente);
		}
		return true;
	}
	public boolean InsertarOrd(T dato) {
		if( !CrearNodo(dato))
			return false;
		if( frente==null) {
			return InsertarFrente(dato);
		}
		String criterioNuevo=dato.toString();
		String criterioFrente=frente.getInfo().toString();
		int res=criterioNuevo.compareTo(criterioFrente);
		if(res<=0) {
			nuevo.setSig(frente);
			frente=nuevo;
			return true;
			
		}
		String criterioFinal=fin.getInfo().toString();
		res=criterioNuevo.compareTo(criterioFinal);
		if(res>=0) {
//			fin.setSig(nuevo);
//			fin=nuevo;
			return InsertarFin(dato);
		}
		Nodo<T> ant=null;
		Nodo<T> aux=frente;
		String criterioAux;
		while(true) {
			criterioAux=aux.getInfo().toString();
			res=criterioAux.compareTo(criterioNuevo);
			if( res>=0 )
				break;
			ant=aux;
			aux=aux.getSig();
		}
		ant.setSig(nuevo);
		nuevo.setSig(aux);
		return true;
	}
	public boolean Buscar(T dato) {
		Nodo<T> aux=frente;
		while( aux != null) {
			if( dato.toString().equals(aux.getInfo().toString()))
				break;
			if(aux==fin) {
				return false;
				
			}
			aux=aux.getSig();
		}
		dr=aux.getInfo();
		return true;
	}
	public boolean Retirar(T dato) {
		Nodo<T> aux=frente;
		int cont=0;
		while( aux != null ) {
			cont++;
			
			if(dato.toString().equals(aux.getInfo().toString()))
				return Retirar(cont);
			if(aux==fin)
				break;
			aux=aux.getSig();
		}
		
		return false;
	}
	public boolean Retirar(int posicion) {
		if(posicion<1 || posicion>length())
			return false;
		// unico nodo en la lista
		if(length()==1) {
			dr=frente.getInfo();
			frente=fin=null;
			return true;
		}
		// primer nodo de la lista
		if(posicion==1) {
			dr=frente.getInfo();
			frente=frente.getSig();
			fin.setSig(frente);
			return true;
		}
		Nodo<T> ant=null;
		Nodo<T> aux=frente;
		
		for(int i=0 ; i<posicion-1 ;i++, ant=aux,aux=aux.getSig());
		// nodo final se elimina
		if(posicion==length()) {
			dr=fin.getInfo();
			fin=ant;
			fin.setSig(frente);
			return true;
		}
		// entre dos nodos
		dr=aux.getInfo();
		ant.setSig(aux.getSig());
		return true;
	}
	public int length() {
		int cont=0;
		Nodo<T> aux=frente;
		while(aux!=null) {
			cont++;
			if(aux==fin)
				break;
			aux=aux.getSig();
		}
		return cont;
	}
	private boolean CrearNodo(T dato) {
		try {
			nuevo=new Nodo(dato);
		} catch (Error e) {
			return false;
		} 
		catch (Exception e){
			return false;
		}
		return true;
	}

	public Nodo<T> getFrente() {
		return frente;
	}

	public Nodo<T> getFin() {
		return fin;
	}
	public T getDr() {
		return dr;
	}

}