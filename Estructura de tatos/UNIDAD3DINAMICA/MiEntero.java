package UNIDAD3DINAMICA;

import U1.Rutinas;

public class MiEntero {
	private int numero;
	
	public MiEntero(int numero) {
		this.numero=numero;
	}
	public int getNumero() {
		return numero;
	}
	public String toString() {
		return Rutinas.PonCeros(numero,15);
	}
}
