package UNIDAD3DINAMICA;

public class AplPreinscripcion {

	public static void main(String[] args) {
		
		PreInscripcion pre = new PreInscripcion();
		
		pre.Registrar(new Ficha("AURORA","CETIS",9,"ISC"));
		pre.Registrar(new Ficha("EPIFANIA","UAS",9,"ISC"));
		pre.Registrar(new Ficha("ARTURO","CONALEP",10,"ISC"));
		pre.Registrar(new Ficha("BENITO","CBETIS",8,"ISC"));
		pre.Registrar(new Ficha("BENITA","CBETIS",8,"ISC"));
		pre.Registrar(new Ficha("PEDRO","CETIS",10,"ISC"));
		pre.Registrar(new Ficha("ANGEL","UAS",9,"ISC"));
		pre.Registrar(new Ficha("MARIA","UAS",10,"ISC"));

		System.out.println(pre.dameAlumnosPreInscritos());
		
		System.out.println("ISC los N con mejor promedio \n"+pre.dameAlumnosTop("ISC", 1));
		System.out.print(pre.TotalesPorCarrera());
	}

}
