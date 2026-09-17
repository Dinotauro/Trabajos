package U3Estatica;

public class ExpresionPosfija {
	private Pila<Float> pila;
	private Pila<Character> pilaDigitos;
	private String msg;
	private float resultado;
	
	
	public ExpresionPosfija() {
		this(10);
	}
	public ExpresionPosfija(int tamaño) {
		pila=new Pila(tamaño);
		pilaDigitos=new Pila(20);
	}
	public boolean Evaluar(String expresion) {
		char car;
		float numero;
		for(int i=0 ; i<expresion.length() ; i++) {
			car=expresion.charAt(i);
			if( Character.isDigit(car)) {
				if( !pilaDigitos.Insertar(car)) {
					msg="La capacidad de la pila de digitos es insuficiente para resolver la expresión";
					return false;
				}
				continue;
			}

			if(car==' ' && !pilaDigitos.Vacia()) {
				numero=Convertir(pilaDigitos);
				if(!pila.Insertar(numero)) {
					msg="La expresión no puede evaluarse, el tamaño de la pila e sinsuficiente";
					return false;

				}
			}
			if("+-*/".indexOf(car)==-1)
				continue;
			float termino2,termino1;
			if(!pila.Retirar()) {
				msg="NO EXISTEN LOS TERMINOS PARA REALIZAR LA OPERACIÓN";
				return false;
			}
			termino2=pila.getDr();
			if(!pila.Retirar()) {
				msg="NO EXISTEN LOS TERMINOS PARA REALIZAR LA OPERACIÓN";
				return false;
			}
			termino1=pila.getDr();

			float res=0.0f;
			switch (car) {
			case '+': res=termino1+termino2;break;
			case '-': res=termino1-termino2;break;
			case '*': res=termino1*termino2;break;
			case '/': res=termino1/termino2;break;

			}
			pila.Insertar(res);
		}
		pila.Retirar();
		if(!pila.Vacia()) {
			msg="EXPRESIÓN ES INCORRECTA, NO SE PUEDE EVALUAR";
			return false;
		}
		resultado=pila.getDr();
		msg="expresión evaluada correctamente";
		return true;
	}
	
	public float Convertir(Pila<Character> pilaDigitos) {
		float resultado=0;
		long base =1;
		while(pilaDigitos.Retirar()) {
			resultado+=pilaDigitos.getDr()*base;
			base*=10;
		}
		return resultado;
	}
	/*
	public boolean Evaluar(String expresion) {
		char car;
		float numero;
		for(int i=0 ; i<expresion.length() ; i++) {
			car=expresion.charAt(i);
			if( Character.isDigit(car)) {
				numero=(float)( car-48);
				if( !pila.Insertar(numero)) {
					msg="La capacidad de la pila es insuficiente para resolver la expresión";
					return false;
				}
				continue;
			}
			
			if("/+-*".indexOf(car)==-1)
				continue;
			float termino2,termino1;
			if(!pila.Retirar()) {
				msg="NO EXISTEN LOS TERMINOS PARA REALIZAR LA OPERACIÓN";
				return false;
			}
			termino2=pila.getDr();
			if(!pila.Retirar()) {
				msg="NO EXISTEN LOS TERMINOS PARA REALIZAR LA OPERACIÓN";
				return false;
			}
			termino1=pila.getDr();
			
			float res=0.0f;
			switch (car) {
			case '+': res=termino1+termino2;break;
			case '-': res=termino1-termino2;break;
			case '*': res=termino1*termino2;break;
			case '/': res=termino1/termino2;break;
			
			}
			pila.Insertar(res);
		}
		pila.Retirar();
		if(!pila.Vacia()) {
			msg="EXPRESIÓN ES INCORRECTA, NO SE PUEDE EVALUAR";
			return false;
		}
		resultado=pila.getDr();
		msg="expresión evaluada correctamente";
		return true;
	}
*/

	public String getMsg() {
		return msg;
	}
	public float getResultado() {
		return resultado;
	}
}
