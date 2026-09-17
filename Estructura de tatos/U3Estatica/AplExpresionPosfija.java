package U3Estatica;

public class AplExpresionPosfija {

	public static void main(String[] args) {
		ExpresionPosfija obj = new ExpresionPosfija(20);
		
		if( obj.Evaluar("1111 2 * 800 +")) {
			System.out.println("el  resultado es "+obj.getResultado());
		} else {
			System.out.println("No se pudo evaluar "+obj.getMsg());
		}

	}

}
