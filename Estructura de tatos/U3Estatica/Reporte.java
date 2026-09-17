package U3Estatica;

import U1.Rutinas;

public class Reporte {
	private int noComp, noHojas, tipoExtension;
	
	public Reporte(int noComp,int noHojas, int tipoExtension) {
		this.noComp=noComp;
		this.noHojas=noHojas;
		this.tipoExtension=tipoExtension;
	}
	public String toString() {
		return Rutinas.PonCeros(noComp, 5)+Rutinas.PonCeros(noHojas, 5);
	}
	public int getNoComp() {
		return noComp;
	}

	public void setNoComp(int noComp) {
		this.noComp = noComp;
	}

	public int getNoHojas() {
		return noHojas;
	}

	public void setNoHojas(int noHojas) {
		this.noHojas = noHojas;
	}

	public int getTipoExtension() {
		return tipoExtension;
	}

	public void setTipoExtension(int tipoExtension) {
		this.tipoExtension = tipoExtension;
	}
	
}
