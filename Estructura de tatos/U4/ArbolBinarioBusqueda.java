package U4;

public class ArbolBinarioBusqueda <T> {
	private NodoABB<T> raiz;
	private NodoABB<T> nuevo;
	private T          dr;
	
	public ArbolBinarioBusqueda() {
		raiz=null;
	}
	
	public int size() {
		return size(raiz);
	}
	private int size(NodoABB<T> root) {
		if(root==null)
			return 0;
		return 1+size(root.getSubIzq())+size(root.getSubDer());
	}
	public boolean Insertar(T dato) {
		if(raiz==null) {
			if(!CrearNodo(dato)) 
			   return false;
			raiz=nuevo;
			return true;
		}
		return Insertar(raiz,dato);	
	}
	private boolean Insertar(NodoABB<T> root,T dato) {
		String criterioNuevo=dato.toString();
		String criterioRoot=root.getInfo().toString();
		int res=criterioNuevo.compareTo(criterioRoot);
		if(res<0) { // hijo izq
			if(root.getSubIzq()!=null)
				return Insertar(root.getSubIzq(),dato);
			if(!CrearNodo(dato))
				return false;
			root.setSubIzq(nuevo);
			return true;
		} else {
			if(res>0 ) {
				// hijo derecha
				if(root.getSubDer()!=null)
					return Insertar(root.getSubDer(),dato);
				if(!CrearNodo(dato))
					return false;
				root.setSubDer(nuevo);
				return true;
			}
		}
		//son iguales
		return false;
	}
	public boolean Retirar(T dato) {
		return Retirar(raiz,dato,null,false);// false aux llego por izq de ante y
		// true llegó por derecha de ant
	}
	private  boolean Retirar(NodoABB<T> aux,T dato,NodoABB<T> ant, boolean sentido ) {
		if(aux == null)
			return false;
		String infoDato=dato.toString();
		String infoAux=aux.getInfo().toString();
		int res=infoDato.compareTo(infoAux);
		if(res<0) {
			return Retirar(aux.getSubIzq(),dato,aux,false);
		} else {
			if(res>0) {
				return Retirar(aux.getSubDer(),dato,aux,true);
			}else {
				// nodo localizado por aux

				if(aux.getSubIzq()!=null && aux.getSubDer()!=null) {
					// dos hijos
					NodoABB<T> menor=aux.getSubDer();
					while(menor.getSubIzq()!=null)
						menor=menor.getSubIzq();
					
					aux.setInfo(menor.getInfo());
					dato=menor.getInfo();
					return Retirar(aux.getSubDer(),dato,aux,true);
				} else {
					// 0 o 1 hijo
					
					NodoABB<T> subArbol;
					if(aux.getSubDer()==null)
						subArbol=aux.getSubIzq();
					else
						subArbol=aux.getSubDer();
					if(aux == raiz  ) {
						raiz=subArbol;
						return true;
					}
					if(sentido)
						ant.setSubDer(subArbol);
					else
						ant.setSubIzq(subArbol);
					return true;
				}				
			}
		}
	}

	
	public boolean Buscar(T dato) {
		return Buscar(raiz,dato);
	}
	private boolean Buscar(NodoABB<T> root, T dato) {
		if(root == null)
			return false;
		String criterioDato = dato.toString();
		String criterioRoot= root.getInfo().toString();
		//System.out.println(criterioRoot+"...."+criterioDato);
		int res=criterioDato.compareTo(criterioRoot);
		if(res==0) {
			dr=root.getInfo();
			return true;
		}
		if( res<0)
			return Buscar(root.getSubIzq(),dato);
		return Buscar(root.getSubDer(),dato);
	}
	private boolean CrearNodo(T dato) {
		try {
			nuevo=new NodoABB(dato);
		} catch(Error e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public NodoABB<T> getRaiz() {
		return raiz;
	}

	public T getDr() {
		return dr;
	}
	
}