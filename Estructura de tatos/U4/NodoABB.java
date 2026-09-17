package U4;
public class NodoABB <T>{
	private NodoABB<T> subIzq;
	private T          info;
	private NodoABB<T> subDer;
	
	public NodoABB(T dato) {
		info=dato;
		subIzq=subDer=null;
	}

	public NodoABB<T> getSubIzq() {
		return subIzq;
	}

	public void setSubIzq(NodoABB<T> subIzq) {
		this.subIzq = subIzq;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NodoABB<T> getSubDer() {
		return subDer;
	}

	public void setSubDer(NodoABB<T> subDer) {
		this.subDer = subDer;
	}

}
