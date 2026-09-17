package UNIDAD3DINAMICA;

public class NodoDbl <T>{

	private NodoDbl<T> ant;
	private T          info;
	private NodoDbl<T> sig;
	
	public NodoDbl(T dato) {
		info=dato;
		ant=sig=null;
	}

	public NodoDbl<T> getAnt() {
		return ant;
	}

	public void setAnt(NodoDbl<T> ant) {
		this.ant = ant;
	}

	public NodoDbl<T> getSig() {
		return sig;
	}

	public void setSig(NodoDbl<T> sig) {
		this.sig = sig;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
}
