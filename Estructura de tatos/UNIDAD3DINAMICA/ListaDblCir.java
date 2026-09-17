package UNIDAD3DINAMICA;

public class ListaDblCir <T>{
	
	private NodoDbl<T> frente;
	private NodoDbl<T> fin;
	private NodoDbl<T> nuevo;
	private T          dr;
	private int  length;
	public ListaDblCir() {
		frente=fin=null;
		dr=null;
		length=0;
	}
	public int length() {
		return length;
	}
	public boolean InsertarFrente(T dato) {
		if(!CrearNodo(dato))
			return false;
		length++;
		if(frente==null) {
			frente=fin=nuevo;
			nuevo.setSig(nuevo);
			nuevo.setAnt(nuevo);
			return true;
		}
		nuevo.setSig(frente);
		frente.setAnt(nuevo);
		frente=nuevo;
		frente.setAnt(fin);
		fin.setSig(nuevo);
		return true;
	}

	public boolean InsertarFin(T dato) {
		if(!CrearNodo(dato))
			return false;
		length++;
		if(frente==null) {
			frente=fin=nuevo;
			nuevo.setSig(nuevo);
			nuevo.setAnt(nuevo);
			return true;
		}

		fin.setSig(nuevo);
		nuevo.setAnt(fin);
		fin=nuevo;
		fin.setSig(frente);
		frente.setAnt(fin);
		return true;
	}
	public boolean InsertarOrd(T dato) {
//		if(!CrearNodo(dato))
//			return false;
		

		if(frente==null) {
			return InsertarFin(dato);
		}
		String criterioNuevo=dato.toString();
		String criterioFrente=frente.getInfo().toString();
		String criterioFin=fin.getInfo().toString();
		if(criterioNuevo.compareTo(criterioFrente) <=0 )
			return InsertarFrente(dato);
		if(criterioNuevo.compareTo(criterioFin)>=0)
			return InsertarFin(dato);
		// entre dos nodos
		length++;
		NodoDbl<T> aux=frente;
		String criterioAux="";
//		while( true ) {
//			criterioAux=aux.getInfo().toString();
//			if( criterioAux.compareTo(criterioNuevo)>=0)
//				break;
//			aux=aux.getSig();
//		}
		while(aux.getInfo().toString().compareTo(criterioNuevo)<0)
			aux=aux.getSig();
		if(!CrearNodo(dato)) {
			return false;
		}
		NodoDbl<T> ant=aux.getAnt()	;
		
		nuevo.setSig(aux);
		nuevo.setAnt(ant);
		ant.setSig(nuevo);
		aux.setAnt(nuevo);
		return true;
	}
	public boolean Buscar(T dato) {
		NodoDbl<T> aux=frente;
		while( aux != null) {
			if( dato.toString().equals(aux.getInfo().toString()))
				break;
			if(aux==fin)
				return false;
			aux=aux.getSig();
		}
		if(aux==null)
			return false;
		dr=aux.getInfo();
		return true;
	}
	public boolean Retirar(int posicion) {
		if(posicion<1 || posicion>length())
			return false;
		//length--;
		// unico nodo en la lista
		if(length()==1) {
			dr=frente.getInfo();
			frente=fin=null;
			length--;
			return true;
		}
		// primer nodo de la lista
		if(posicion==1) {
			dr=frente.getInfo();
			frente=frente.getSig();
			frente.setAnt(fin);
			fin.setSig(frente);
			length--;
			return true;
		}
		NodoDbl<T> ant=null;
		NodoDbl<T> aux=frente;
		
		for(int i=0 ; i<posicion-1 ;i++, ant=aux,aux=aux.getSig());
		// nodo final se elimina
		if(posicion==length()) {
			dr=fin.getInfo();
			fin=ant;
			fin.setSig(frente);
			frente.setAnt(fin);
			length--;
			return true;
		}
		// entre dos nodos
		dr=aux.getInfo();
		ant.setSig(aux.getSig());
		aux.getSig().setAnt(aux.getAnt());
		length--;
		return true;
	}
	public boolean Retirar(T dato) {
		if(dato==null || frente==null)
			return false;
		int cont=0;
		String criterioBusqueda=dato.toString();
		NodoDbl<T> aux=frente;
		String criterioAux="";
		while ( aux !=null) {
			criterioAux=aux.getInfo().toString();
			cont++;
			if(criterioBusqueda.equals(criterioAux))
				break;
			if(aux==fin)
				return false;
			aux=aux.getSig();
		}
		return Retirar(cont);
	}
	private boolean CrearNodo(T dato) {
		try {
			nuevo=new NodoDbl(dato);
		} catch (Error e) {
			return false;
		} 
		catch (Exception e){
			return false;
		}
		return true;
	}

	public NodoDbl<T> getFrente() {
		return frente;
	}

	public void setFrente(NodoDbl<T> frente) {
		this.frente = frente;
	}

	public NodoDbl<T> getFin() {
		return fin;
	}

	public void setFin(NodoDbl<T> fin) {
		this.fin = fin;
	}

	public T getDr() {
		return dr;
	}

}
