package ProyectoU3Estatica;

import U1.Rutinas;

public class Vagon {
private int id;
public Vagon() {
	id= Rutinas.nextInt(1, 200);
}
public Vagon(int id) {
	this.id=id;
}
public int getId() {
	return id;
}
@Override
public String toString() {
	return "Vagon [id=" + Rutinas.PonCeros(id, 3) + "]";
}

}
