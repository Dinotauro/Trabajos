package U3Estatica;

import U1.Rutinas;

public class Apl {

	public static void main(String[] args) {

		
		Pila<String> pila1=new Pila(5);
		Pila<String> pilaAux=new Pila(5);
		
		

		while ( !pila1.Llena() ) {
			
			System.out.println(pila1.Insertar(Rutinas.nextNombre(1)));
		}
		Imprimir(pila1);
		
		// DESEO ELIMINAR A FERNANDA
		
		while( pila1.Retirar()) {
			if(pila1.getDr().equals("FERNANDA"))
				break;
			pilaAux.Insertar(pila1.getDr());
		}
		while(pilaAux.Retirar() && pila1.Insertar(pilaAux.getDr()));
		Imprimir(pila1);
		
		
		
	}
	private static void Imprimir(Pila<String> pila) {
		Pila<String> pilaAux=new Pila(5);
		System.out.println("__________________________________");
        while ( pila.Retirar()) {
        	System.out.println(pila.getDr());
        	pilaAux.Insertar(pila.getDr()    );
        	
        }
     //   while(pilaAux.Retirar() && pila.Insertar(pilaAux.getDr()));
       
//        while ( ! pilaAux.Vacia()) {
//        	pilaAux.Retirar();
//        	pila.Insertar(pilaAux.getDr());
//        }
        while (  pilaAux.Retirar()) {
        	pila.Insertar(pilaAux.getDr());
        }
        
        
        
        System.out.println("La pila está vacía "+pila.Vacia());
        System.out.println("La pila aux está vacía "+pilaAux.Vacia());

	}
}
