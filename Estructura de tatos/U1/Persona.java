package U1;

public class Persona {

private String nombre;
private int edad,siguiente;
public Persona(int edad, String nombre) {
	this.edad = edad;
	this.nombre = nombre;
	}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public int getSiguiente() {
	return siguiente;
}
public void setSiguiente(int siguiente) {
	this.siguiente = siguiente;
}
@Override
public String toString() {
	return "Persona [nombre=" + nombre + ", edad=" + edad + ", siguiente=" + siguiente + "]";
}
}
