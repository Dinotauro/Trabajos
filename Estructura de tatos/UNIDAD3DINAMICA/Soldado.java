package UNIDAD3DINAMICA;

import U1.Rutinas;

public class Soldado {
private int numSoldado,edad;
public Soldado(int soldado) {
	this.numSoldado= soldado;
	edad = Rutinas.nextInt(35);
}
public int getNumSoldado() {
	return numSoldado;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
@Override
public String toString() {
	return "Soldado: " + numSoldado;
}

}
