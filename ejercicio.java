import java.lang.reflect.Array;
import java.util.*;

@SuppressWarnings("all")
public class ejercicio {
    static int[] Numeros = null;

    public static void main(String[] args) {
     Random Numero = new Random();
    
     int xD;
     
     try {
	} catch (Exception e) {
		e.printStackTrace();
	}
     int i;
     for ( i = 0; i < 101; i++) {
         xD = (int) Numero.nextInt(500) + 500;
         Numeros = new int[xD];
         System.out.println( "Malos numeros "+ Numeros.length);
        burbuja(Numeros);
     }
     	
     	for(int Hola:Numeros);{
     		System.out.println(Numeros.length);
     	}
   		
    }
    public static void burbuja(int[] Numeros) {
    	     
      int h;
        int g;
        int b;
        for(h = 1;h < 100 - 1; h++) {
        	for(g = 1; g < 100 + 1; g++) {
        		if( Numeros[h]> Numeros[g]) {
        			b = Array.getInt(Numeros, h);
        			Numeros[h] = Numeros[g];
        		    Array.setInt(Numeros,g , b); 
        		}
        	 }
          }
    }
}
 
