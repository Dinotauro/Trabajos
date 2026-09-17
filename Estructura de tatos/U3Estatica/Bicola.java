package U3Estatica;

public class Bicola <T> extends Cola<T>{
	
	public Bicola() {
		this(10);
	}
	public Bicola(int tamaño) {
		super(tamaño);
	}
	
	public boolean RetiranFin() {
		if(Vacia())
			return false;
		
		dr=cola[fin];
		if(frente==fin)
			frente=fin=-1;
		else
		   fin--;
		return true;
	}

}
