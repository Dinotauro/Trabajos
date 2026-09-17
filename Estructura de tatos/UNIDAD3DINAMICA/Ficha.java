package UNIDAD3DINAMICA;

import U1.Rutinas;

public class Ficha {
	private String nombre, prepa, carrera;
	private int    promedio;
	
	public Ficha(String nombre,String prepa, int promedio,String carrera) {
		this.nombre=nombre;
		this.prepa=prepa;
		this.promedio=promedio;
		this.carrera=carrera;
	}
	public String toString() {
		return Rutinas.PonCeros(promedio, 3);
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrepa() {
		return prepa;
	}

	public void setPrepa(String prepa) {
		this.prepa = prepa;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}
	
}
