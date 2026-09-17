package U2;

import java.lang.reflect.Array;

import U1.Rutinas;

public class PractRecursiva {

	public static void main(String[] args) {
		String[][] b = {
				{"1","2","3"},
				{"4","5","6"},
				{"7","8","9"}
		};
		Imprimir(b);
		System.out.println("");
		String c ="   Juan      Juega                                                                                                                                                  "
				+ " Juegos                                                                                                  "
				+ "     Pedro     Tambien  ";
		System.out.println(c);
		System.out.print("Largo del texto ");
		System.out.println(c.length());
		String d = Mytrim(c);
		System.out.println (d);
		System.out.print("Largo del texto ");
		System.out.println(d.length());
	}
	public static void Imprimir (String[][] a) {
		int pos = 0;
		ImprimirReng(a,pos);
	}
	private static void ImprimirColum(String[] b,int pos ) {
		if(b.length==pos)
			return;
		System.out.print(b[pos]);
		ImprimirColum(b,pos+1);
	}
	private static void ImprimirReng(String[][] a,int pos) {
		if(a.length==pos)
			return;
		String b[] = a[pos];
		System.out.println("");
		ImprimirColum(b,0);
		ImprimirReng(a,pos+1);
	}
	public static String Mytrim(String texto) {
		texto = MytrimIzq(texto);
		texto = MytrimDer(texto);
		texto = MytrimCentro(texto, 0);
		return texto;
		
	}
	private static String MytrimIzq(String texto) {
		if(texto.length()==0||texto.charAt(0) != ' ')
			return texto;
		return MytrimIzq(texto.substring(1));
	}
    private static String MytrimDer(String texto) {
    	if(texto.length()==0||texto.charAt(texto.length()-1)!= ' ')
    		return texto;
		return MytrimDer(texto.substring(0,texto.length()-1));
	}
    private static String MytrimCentro(String texto, int pos) {
    	if(texto.length()-1==pos)
    		return texto;
    	if(texto.charAt(pos)!= ' '&&texto.charAt(pos+1)== ' ')
    		return MytrimCentro(texto,pos + 1);
    	if(texto.charAt(pos)!= ' ')
    		return MytrimCentro(texto,pos + 1);
    	return texto.substring(0,pos+1)+MytrimCentro(MytrimIzq(texto.substring(pos+1)),0);
    }
}
