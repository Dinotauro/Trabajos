package UNIDAD3DINAMICA;
public class PreInscripcion {
	
	private Lista<Ficha> lista;
	
	public PreInscripcion() {
		lista=new Lista();
	}
	public boolean Registrar(Ficha ficha) {
		return lista.InsertarFin(ficha);
	}
	
	public String dameAlumnosPreInscritos() {
		String preAlumnos="";
		Nodo<Ficha> aux=lista.getFrente();
		Ficha alumno;
		while(aux != null) {
			alumno=aux.getInfo();
			preAlumnos+=String.format("%-30s %-25s %4d %15s\n", alumno.getNombre(),
					alumno.getPrepa(),alumno.getPromedio(),alumno.getCarrera());
			aux=aux.getSig();
		}
		return preAlumnos;
		
	}
	public String dameAlumnosTop(String carrera, int cantidad) {
		Nodo<Ficha> aux=lista.getFrente();
		Lista<Ficha> listaOrd=new Lista();
		
		while(aux != null) {
			if(!aux.getInfo().getCarrera().equals(carrera)) {
				aux=aux.getSig();
				continue;
			}
			listaOrd.InsertarOrd(aux.getInfo());
			
			aux=aux.getSig();
		}
		
		Lista<Ficha> listaMayorMenor=new Lista();
		aux=listaOrd.getFrente();
		while( aux != null) {
			listaMayorMenor.InsertarFrente(aux.getInfo());
			aux=aux.getSig();
		}
		String res="";
		aux=listaMayorMenor.getFrente();
		Ficha alumno;
		int prom=0;
		for(int i=0 ; aux!=null && i<cantidad ; i++) {
			alumno=aux.getInfo();
			res+=String.format("%-30s %-25s %4d %15s\n", alumno.getNombre(),
					alumno.getPrepa(),alumno.getPromedio(),alumno.getCarrera());
			prom=alumno.getPromedio();
			aux=aux.getSig();
		}
//		if( aux!=null && prom==aux.getInfo().getPromedio()) {
			while(aux!=null && prom==aux.getInfo().getPromedio() ) {
				alumno=aux.getInfo();
				res+=String.format("%-30s %-25s %4d %15s\n", alumno.getNombre(),
						alumno.getPrepa(),alumno.getPromedio(),alumno.getCarrera());
				aux=aux.getSig();
			}
			
			
//		}
		return res;
	}
	public String TotalesPorCarrera() {
		Nodo<Ficha> aux = lista.getFrente();
		Lista<Frecuencia> frec = new Lista();
		while(aux != null) {
			Frecuencia Carrera = new Frecuencia(aux.getInfo().getCarrera());
			if(frec.Buscar(Carrera)) {
				frec.Retirar(Carrera);
				Frecuencia frecAux =frec.getDr();
				frecAux.setFrecuencia(frecAux.getFrecuencia()+1);
				frec.InsertarOrd(frecAux);
			}else {
				frec.InsertarOrd(Carrera);
				}
			aux=aux.getSig();
			}
		String preAlumnos="";
		Nodo<Ficha> aux3=lista.getFrente();
		while(aux3 != null) {
		    Nodo<Frecuencia> auxF = frec.getFrente();
			preAlumnos+=String.format("%-25s %5d\n", auxF.getInfo().getNombre(), auxF.getInfo().getFrecuencia());
	        aux3 = aux3.getSig();
		}
		return preAlumnos;
		
		// debe de regresar un string que contenga la carrera y total de alumnos que solicitaron preinscripción
	}
	
}
