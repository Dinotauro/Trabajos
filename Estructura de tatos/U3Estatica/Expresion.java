package U3Estatica;


public class Expresion {
	private Pila<Character> pila;
	private String msg;
	
	public Expresion() {
		this(10);
	}
	public Expresion(int tamaño) {
		pila=new Pila(tamaño);
	}

	public boolean Parentesis(String texto) {
		if( texto.isEmpty())
			return false;
		char car;
		for(int i=0 ; i<texto.length();i++) {
			car=texto.charAt(i);
			if(   "({<[]>})".indexOf(car+"")== -1) {
				continue;
			}
			if(   "({<[".indexOf(car+"") >= 0) {

				if(!pila.Insertar(car)) {
					msg="La expresión no puede evaluarse, tamaño pila insuficiente";
					return false;
				}
				continue;
			}
			else {
				// es un parentesis que cierra

				if( !pila.Retirar()) {
					msg="Hay un "+car+" CERRADO sin que haya parentesis ABIERTO";
					return false;
				}
				// car es el parentesis que cierr, y pila.dr es el que abre
//				if( car== ')' &&  pila.getDr()!='('  ||
//					car== '>' &&  pila.getDr()!='<' ||
//					car== '}' &&   pila.getDr()!='{' ||
//					car== ']' &&  pila.getDr()!='[') {
//					msg="un "+pila.getDr()+", se intenta cerra con "+car;
//					return false;
//				}
				int pos1="([{<".indexOf(pila.getDr());
				int pos2=")]}>".indexOf(car);
				if(pos1 != pos2 ) {
					msg="un "+pila.getDr()+", se intenta cerra con "+car;
					return false;
				}
				
			}

		}
		if(!pila.Vacia()) {
			msg="Hay parentesis abiertos sin cerrar";
			return false;
		}
		msg="EXPRESIÓN CORRECTAMENTE PARETISADA!!!!!";

		return true;
	}
	public String getMsg() {
		return msg;
	}

}
