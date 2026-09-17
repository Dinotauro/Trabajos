package UNIDAD3DINAMICA;

public class Casilla {
private int destino;
private int pos;
private char tipo;
private char[] cont = {'N','E','S','T'};
public Casilla(int Pos) {
		tipo = cont[0];
		pos = Pos;
	}
public void setTipo(int pos) {
	tipo = cont[pos];
}
public char getTipo() {
	return tipo;
}
public int getDestino() {
	return destino;
}
public void setDestino(int numero) {
	this.destino = numero;
}
@Override
public String toString() {
	return "Casilla [tipo=" + pos + "]";
}
public int getPos() {
	return pos;
}
public void setPos(int pos) {
	this.pos = pos;
}
}
