package U3Estatica;

import U1.Rutinas;

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
	
}
public class AplPilaPersona {
	static final int TAMAÑO=15;
	public static void main(String[] args) {
		Pila<Persona> pila = new Pila(TAMAÑO);
		
		//LLenar la pila de datos aleatorios
	 	Llenar(pila);
		//LlenarSinDuplicados(pila);
		EdoActual(pila);
		Pila<Frecuencia> pilaFre=Frecuencia(pila);
		QuitarRepetidos(pila,pilaFre);
		
		
		System.out.println("_______________________________");
		while(pilaFre.Retirar())
			System.out.printf("%-15s  %4d\n",pilaFre.getDr().getNombre(),pilaFre.getDr().getFrecuencia());
	}
	public static void Llenar(Pila<Persona> pila) {
		String nombre;
		int edad;
		Persona persona;
//		while(!pila.Llena()) {
//			nombre=Rutinas.nextNombre(1);
//			edad=Rutinas.nextInt(18,23);
//			persona=new Persona(nombre,edad);
//			pila.Insertar(persona);
//		}
		while( pila.Insertar(new Persona(Rutinas.nextNombreSinApeidos(1),Rutinas.nextInt(18,23))));
	}
	public static void LlenarSinDuplicados(Pila<Persona> pila) {
		Persona persona;
		while( ! pila.Llena()) {
			persona=new Persona(Rutinas.nextNombreSinApeidos(1),Rutinas.nextInt(18,23));
			
			if(! Buscar(pila,persona))
				pila.Insertar(persona);
		}
	}
	public static boolean Buscar(Pila<Persona> pila, Persona persona) {
		Pila<Persona> pilaAux=new Pila(TAMAÑO);
		boolean encontro=false;
		while( pila.Retirar() && pilaAux.Insertar(pila.getDr())) {
			if(pila.getDr().getNombre().equals(persona.getNombre())) {
				encontro=true;
				break;
			}
			
		}
		while(pilaAux.Retirar() && pila.Insertar(pilaAux.getDr()));
		return encontro;
		
	}
	public static Pila<Frecuencia> Frecuencia(Pila<Persona> pila) {
		Pila<Persona> pilaAux=new Pila(TAMAÑO);
		Pila<Frecuencia> pilaFre=new Pila(TAMAÑO);
		Pila<Frecuencia> pilaFreAux=new Pila(TAMAÑO);
		String nombre;
		boolean encontro;
		while( pila.Retirar() && pilaAux.Insertar(pila.getDr())) {
			nombre=pila.getDr().getNombre();
			encontro=false;
			while(pilaFre.Retirar() && pilaFreAux.Insertar(pilaFre.getDr())) {
				if( nombre.equals( pilaFre.getDr().getNombre() )) {
					int veces=pilaFre.getDr().getFrecuencia();
					pilaFre.getDr().setFrecuencia(   veces +1  );
					encontro=true;
					break;
				}
			}
			if(!encontro) {
				pilaFreAux.Insertar(new Frecuencia(nombre));
			}
			while( pilaFreAux.Retirar() && pilaFre.Insertar(pilaFreAux.getDr()));
			
			
			
		}
		while( pilaAux.Retirar() && pila.Insertar(pilaAux.getDr()));
		return pilaFre;
	}
	public static void EdoActual(Pila<Persona> p) {
		Pila<Persona> pilaAux = new Pila(TAMAÑO);
		while( p.Retirar() && pilaAux.Insertar(p.getDr())) {
			System.out.printf("%-15s %4d \n",p.getDr().getNombre(),p.getDr().getEdad());
			//pilaAux.Insertar(new Persona(p.getDr().getNombre(),p.getDr().getEdad()));
		}
		while( pilaAux.Retirar() && p.Insertar(pilaAux.getDr()));
	}
	public static void QuitarRepetidos(Pila<Persona> pila,Pila<Frecuencia> pilafrec) {
		Pila<String> pilaElim=new Pila(TAMAÑO);
		Pila<Object> pilaAux=new Pila(TAMAÑO);
		while( pilafrec.Retirar() && pilaAux.Insertar(pilafrec.getDr())) {		
			if(pilafrec.getDr().getFrecuencia()>2) {
				 pilaElim.Insertar(pilafrec.getDr().getNombre());
			}	
		}
		while(pilaAux.Retirar() && pilafrec.Insertar((U3Estatica.Frecuencia) pilaAux.getDr()));
		while(pilaElim.Retirar()) {
		while( pila.Retirar() && pilaAux.Insertar(pila.getDr())) {
			if(pila.getDr().getNombre()==pilaElim.getDr()) {
				continue;
			}
			pilaAux.Retirar();
			pila.Insertar((U3Estatica.Persona) pilaAux.getDr());
		}
		}
	}

}
