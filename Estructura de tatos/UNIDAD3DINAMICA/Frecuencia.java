package UNIDAD3DINAMICA;
class Frecuencia{
	private String nombre;
	private int    frecuencia;
	public Frecuencia(String nombre) {
		this.nombre=nombre;
		this.frecuencia=1;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	@Override
	public String toString() {
		return "Frecuencia [nombre=" + nombre + "]";
	}
	
}