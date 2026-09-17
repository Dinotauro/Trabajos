package U3Estatica;

import U1.Rutinas;

public class Amortiguador {
	private Pila<Disco> Aux;
	private Pila<Disco> amortiguador;
	public Amortiguador() {
		int Tam = Rutinas.nextInt(15,50);
		amortiguador = new Pila(Tam);
		Aux = new Pila(Tam);
	}
	public boolean Bache() {
		return false;
	}
	public void VidaUtilAm() {
		int Cant = 0;
		while(amortiguador.Retirar()&&Aux.Insertar(amortiguador.getDr())) {
			Cant++;
		}
		while(Aux.Retirar()&&amortiguador.Insertar(Aux.getDr()));
		if(Cant<=4) {
			while(amortiguador.Retirar());
		}
	}
	public void VidaUtilDisc() {
		while(amortiguador.Retirar()&&Aux.Insertar(amortiguador.getDr())) {
			if(amortiguador.getDr().getVidaUtil()<=30)
				Aux.Retirar();
			
		}
		while(Aux.Retirar()&&amortiguador.Insertar(Aux.getDr()));
	}
}
class Disco{
	private int VidaUtil;
	private int Modelo;
	public Disco() {
		setVidaUtil(Rutinas.nextInt(95,100));
		setModelo(Rutinas.nextInt(100));
	}
	public int getVidaUtil() {
		return VidaUtil;
	}
	public void setVidaUtil(int vidaUtil) {
		VidaUtil = vidaUtil;
	}
	public int getModelo() {
		return Modelo;
	}
	private void setModelo(int modelo) {
		Modelo = modelo;
	}
}