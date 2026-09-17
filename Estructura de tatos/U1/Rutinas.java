package U1;

import java.util.*;
public class Rutinas {
	static Random r=new Random();
	static String []VN ={"Juana","Zoila","Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
			"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={false,false,true,false,true,false,true,false,false,false,true,false,false,false,true,true};	

	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;

		for(int i=0;i<Numero;i++){
			Pos=nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
				
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}	

			Nom+=NomTra;

		}
		for(byte i=0;i<2;i++){
			Nom+=VA[nextInt(VA.length)]+" ";
		}
		return Nom.trim();
	} 
	
	public static int nextInt(int li, int ls) {
		return  r.nextInt(ls-li+1)+li;
		
	}
	public static int nextInt(int numero) {
		return r.nextInt(numero);
	}

/*
	public static String PonComas(long cantidad) {
		String texto=cantidad+"";
		int cont=0;
		char car;
		String res="";
		for(int i=texto.length()-1; i>=0 ; i--) {
			car=texto.charAt(i);
			cont++;
			if(cont ==4 ) {
				res=","+res;
				cont=1;
			}	
			res=car+res;
		}
		return res;
	}
*/
	public static String PonComas(long cantidad) {
		String texto=cantidad+"";

		String res="";
		int l;
		while(texto.length()>3) {
			l=texto.length();
			res=","+texto.substring(l-3)+res;
			texto=texto.substring(0,l-3);
			
			
		}
		if(texto.length()>0)
			res=texto+res;
		return res;
	}
	public static String Color() {
		String [] color= {"Azul","Amarillo","Negro","Blanco","Rojo","Verde","Purpura"};
		return color[Rutinas.nextInt(0,color.length-1)];
	}
	public static String PonBlancos(String texto, int largo){
		while(texto.length()< largo)
			texto=texto+" ";
		return texto;

	}
	public static String PonCeros(long valor, int largo){
		String texto=valor+"";
		while(texto.length()< largo)
			texto="0"+texto;
		return texto;
		
	}
	public static String nextNombreSinApeidos(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;

		for(int i=0;i<Numero;i++){
			Pos=nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
				
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}	

			Nom+=NomTra;

		}
		return Nom.trim();
	} 
	
}
