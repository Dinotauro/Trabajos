package U3Estatica;

public class AplExpresion {

	public static void main(String[] args) {
		Expresion obj = new Expresion(10);
		
		System.out.println("(2+2) "+obj.Parentesis("(((((({(2+2){}{}}"));
		System.out.println(obj.getMsg());
		

	}

}
