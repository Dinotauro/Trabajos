package UNIDAD3DINAMICA;

import java.util.Scanner;

import U1.Rutinas;

public class AplListaDbl {

	public static void main(String[] args) {
		
		ListaDbl<MiEntero> lista = new ListaDbl();
		
		System.out.println(lista.InsertarOrd(new MiEntero(10)));
		System.out.println(lista.InsertarOrd(new MiEntero(1)));
		System.out.println(lista.InsertarOrd(new MiEntero(4)));
		System.out.println(lista.InsertarOrd(new MiEntero(100)));
		System.out.println(lista.InsertarOrd(new MiEntero(60)));
		int pos;
		while(lista.length()>0) {
			System.out.println("LARGO DE LA LISTA "+lista.length());
			Imprimir(lista,1);
			//pos=Rutinas.nextInt(1,lista.length());
			System.out.print("proporcioe posición ");			
			
			pos=new Scanner(System.in).nextInt();
			//System.out.println("Posicionn retirada "+pos);
			lista.Retirar(pos);
			
			//Imprimir(lista,1);
			
		}
		
		
		 // 1 indica de fre-fin, 2 de fin-frente
		
		
		
		
		ListaDbl<String > listaNom=new ListaDbl();
		
		for(int i=0 ; i<20 ; i++)
			listaNom.InsertarOrd(Rutinas.nextNombre(1));
		
		NodoDbl auxNom=listaNom.getFrente();
		while(auxNom != null) {
			System.out.println(auxNom.getInfo());
			auxNom=auxNom.getSig();
		}
	}
	public static void Imprimir(ListaDbl<MiEntero> lista, int sentido) {
		NodoDbl<MiEntero> aux = sentido==1?lista.getFrente():lista.getFin();
		while( aux!=null) {
			System.out.println(aux.getInfo().getNumero());
			
			if(sentido==1)
				aux=aux.getSig();
			else
				aux=aux.getAnt();
		}
	}

}
