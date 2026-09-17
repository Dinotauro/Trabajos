package U3Estatica;

import U1.Rutinas;

public class Ferrocarril {
ColaOrd<Vagon>col;
private int tam;
Vagon vag;
ColaOrd<Vagon>colAux;
	public Ferrocarril() {
		tam = Rutinas.nextInt(50,70);
	this.col = new ColaOrd(tam);
	this.colAux = new ColaOrd(150-tam);
	}
	public boolean InsertarVagones() {
		ColaOrd<Vagon>coltemp = new ColaOrd(150-tam);
		boolean band= false;
		if(colAux.Vacia()) {
			colAux.Insertar(vag= new Vagon(1));
			band = true;
		}
		if(!band) {
			while(colAux.Retirar()&&coltemp.Insertar(colAux.getDr()));
			while(coltemp.Retirar()&&colAux.Insertar(coltemp.getDr()));
		}
		while(!colAux.Llena()) {
			Vagon vag = new Vagon();
			if(BuscarRepe(vag))
				continue;
			 if (!colAux.Insertar(vag)) break; 
		}
		return true;
	}
    public void InsertarTren() {
        ColaOrd<Vagon> temp = new ColaOrd<>(150-tam);
        Vagon primero = null;
        boolean encontrado = false;
        while (!colAux.Vacia()) {
            colAux.Retirar();
            Vagon actual = colAux.getDr();
                temp.Insertar(actual);
        }
        if (encontrado) {
            colAux.Insertar(primero);
        }
        while (!temp.Vacia()) {
            temp.Retirar();
            colAux.Insertar(temp.getDr());
        }
        while (!col.Llena() && !colAux.Vacia()) {
            colAux.Retirar();
            col.Insertar(colAux.getDr());
        }
    }
    private boolean BuscarRepe(Vagon vag) {
        ColaOrd<Vagon> tempCol = new ColaOrd<>(tam);
        while (!col.Vacia()) {
            col.Retirar();
            tempCol.Insertar(col.getDr());
        }
        while (!tempCol.Vacia()) {
            tempCol.Retirar();
            col.Insertar(tempCol.getDr());
        }
        while (!tempCol.Vacia()) {
            tempCol.Retirar();
            if (tempCol.getDr().getId() == vag.getId()) return true;
        }
        ColaOrd<Vagon> tempAux = new ColaOrd<>(150 - tam);
        while (!colAux.Vacia()) {
            colAux.Retirar();
            tempAux.Insertar(colAux.getDr());
        }
        while (!tempAux.Vacia()) {
            tempAux.Retirar();
            colAux.Insertar(tempAux.getDr());
        }
        while (!tempAux.Vacia()) {
            tempAux.Retirar();
            if (tempAux.getDr().getId() == vag.getId()) return true;
        }
        
        return false;
    }
	private void imprimirCola(ColaOrd<Vagon> cola, int capacidad, String nombre) {
	    if (cola.Vacia()) {
	        System.out.println(nombre + ": vacía");
	        return;
	    }
	    Cola<Vagon> aux = new Cola<>(capacidad);
	    int contador = 0;
	    System.out.println(nombre + ":");
	    while (!cola.Vacia()) {
	        cola.Retirar();
	        aux.Insertar(cola.getDr());
	    }
	    while (!aux.Vacia()) {
	        aux.Retirar();
	        Vagon v = aux.getDr();
	        if (contador % 10 == 0) {
	            System.out.print("  ");
	        }
	        System.out.print(v.getId() + " ");
	        contador++;
	        if (contador % 10 == 0) {
	            System.out.println();
	        }
	        cola.Insertar(v);
	    }
	    if (contador % 10 != 0) {
	        System.out.println();
	    }
	}

	public boolean imprimir() {
	    imprimirCola(col, tam, "Tren");
	    imprimirCola(colAux, 150-tam, "Estacion de Vagones");
	    return true;
	}
	public int getTam() {
		return tam;
	}
}
