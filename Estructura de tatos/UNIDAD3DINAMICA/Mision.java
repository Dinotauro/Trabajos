package UNIDAD3DINAMICA;

public class Mision {
ListaCir<Soldado> voluntarios = new ListaCir();
Nodo<Soldado> Inicio;
public Mision() {
}
public boolean InsertarSoldado(int dato) {	
	return voluntarios.InsertarFrente(new Soldado(dato)); 
}
public boolean RetirarSoldado(int dato) {
	return voluntarios.Retirar(new Soldado(dato));
}
public boolean Jugar(int dado) {
	int Cont = 1; 
	Nodo<Soldado>Aux=voluntarios.getFrente();
	if(Inicio!=null)
		Aux=Inicio;
	while(true) {
		if(Cont>=dado) {
			int dato =Aux.getInfo().getNumSoldado();
			Aux =Aux.getSig();
			Inicio=Aux;
			voluntarios.Retirar(new Soldado(dato));
			return true;
		}
		Cont++;
		Aux=Aux.getSig();
	}
}
public void Imprimir() {
	Nodo<Soldado>aux=voluntarios.getFrente();
	while(aux!= null) {
		System.out.println(aux.getInfo().getNumSoldado());
		if(aux==voluntarios.getFin())
			break;
		aux=aux.getSig();
	}
}
public Soldado getInicio() {
	if(Inicio!=null)
		return Inicio.getInfo();
	return null;
}
}
