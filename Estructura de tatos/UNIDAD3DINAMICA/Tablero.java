package UNIDAD3DINAMICA;

import U1.Rutinas;

public class Tablero {
private ListaDbl<Casilla> tablero = new ListaDbl();
private ListaCir<Jugador> jugadores = new ListaCir();
private int cantserp,cantescal;
	public Tablero(int casillas) {
	for(int i = 1;i<=casillas;i++) {
		tablero.InsertarFin(new Casilla(i));
		}
	cantserp = Rutinas.nextInt(10);
	cantescal = Rutinas.nextInt(10);
	}
	  public String jugar(int idJugador, int dado) {
	        Jugador buscado = new Jugador(idJugador);
	        if (!jugadores.Buscar(buscado)) {
	            return "Jugador no encontrado";
	        }
	        Jugador jug = jugadores.getDr();

	        NodoDbl<Casilla> nodoActual = jug.getPos();
	        if (nodoActual == null) {
	            nodoActual = tablero.getFrente();
	            jug.setPos(nodoActual);
	        }

	        int posActual = nodoActual.getInfo().getPos();
	        int nuevaPos = posActual + dado;

	        if (nuevaPos > tablero.length()) {
	            return "Jugador " + idJugador + " tiró " + dado + " pero se pasa. Permanece en " + posActual;
	        }

	        NodoDbl<Casilla> nodoNuevo = buscarNodoPorNumero(nuevaPos);
	        if (nodoNuevo == null) {
	            return "Error: no existe casilla " + nuevaPos;
	        }
	        jug.setPos(nodoNuevo);
	        String mensaje = "Jugador " + idJugador + " avanza de " + posActual + " a " + nuevaPos;

	        while (jug.getPos().getInfo().getTipo() == 'E' || jug.getPos().getInfo().getTipo() == 'S') {
	            int destino = jug.getPos().getInfo().getDestino();
	            String tipo = jug.getPos().getInfo().getTipo()+ "";
	            mensaje += " tipo " + tipo + " a " + destino;
	            NodoDbl<Casilla> nodoDestino = buscarNodoPorNumero(destino);
	            if (nodoDestino != null) {
	                jug.setPos(nodoDestino);
	            } else {
	                break;
	            }
	        }
	        haGanado(idJugador);
	        mensaje += ". Nueva posición: " + jug.getPos().getInfo().getPos();
	        return mensaje;
	    }
	    public boolean haGanado(int idJugador) {
	        Jugador buscado = new Jugador(idJugador);
	        if (!jugadores.Buscar(buscado))
	        	return false;
	        Jugador jug = jugadores.getDr();
	        NodoDbl<Casilla> nodo = jug.getPos();
	        return  nodo.getInfo().getDestino() == tablero.length();
	    }
	public boolean InsertarJugadores(int Id) {
		return jugadores.InsertarFin(new Jugador(Id));
	}
	public boolean RetirarJugadorId(int Id) {
		return jugadores.Retirar(new Jugador(Id));
	}
	public void GenerarEscaleras() {
		for(int i = 0;i<cantescal;i++) {
			int pos = Rutinas.nextInt(10,tablero.length()-20);
			if(tablero.Buscar(new Casilla(pos))) {
				if(tablero.getDr().getTipo()=='N') {
					GeneraEscalera(pos);
				}else {
					i--;
					continue;
				}
			}
		}
	}
	public void GeneraEscalera(int pos) {
			int posT = pos + Rutinas.nextInt(5, 10);
			if(tablero.Buscar(new Casilla(posT))) {
				if(tablero.getDr().getTipo()=='N') {
					tablero.getDr().setTipo(3);
					tablero.Buscar(new Casilla(pos));
					tablero.getDr().setTipo(1);
					tablero.getDr().setDestino(posT);
				}
			}
		}
	public void GenerarSerpientes() {
		for(int i = 0;i<cantserp;i++) {
			int pos = Rutinas.nextInt(20,tablero.length()-5);
			if(tablero.Buscar(new Casilla(pos))) {
				if(tablero.getDr().getTipo()=='N') {
					GeneraSerpiente(pos);
				}else {
					i--;
					continue;
				}
			}
		}
			
	}
	private void GeneraSerpiente(int pos) {
		int posT = pos - Rutinas.nextInt(5, 10);
		if(tablero.Buscar(new Casilla(posT))) {
			if(tablero.getDr().getTipo()=='N') {
				tablero.getDr().setTipo(3);
				tablero.Buscar(new Casilla(pos));
				tablero.getDr().setTipo(2);
				tablero.getDr().setDestino(posT);
			}
		}
	}
	private NodoDbl<Casilla> buscarNodoPorNumero(int numero) {
        NodoDbl<Casilla> actual = tablero.getFrente();
        while (actual != null) {
            if (actual.getInfo().getPos() == numero)
                return actual;
            actual = actual.getSig();
        }
        return null;
    }

}
