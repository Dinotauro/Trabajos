package UNIDAD3DINAMICA;

public class Jugador {
private NodoDbl<Casilla> pos;
private int id;
public Jugador(int Id) {
	id=Id;
}
public NodoDbl<Casilla> getPos() {
	return pos;
}
public void setPos(NodoDbl<Casilla> pos) {
	this.pos = pos;
}
public int getId() {
	return id;
}
@Override
public String toString() {
	return "Jugador [id=" + id + "]";
}

}
