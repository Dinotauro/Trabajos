import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<Double> Numero = new ArrayList<Double>();
        ArrayList<Double> Numero2 = new ArrayList<Double>();
        ArrayList<Double> Multiplicacion = new ArrayList<Double>();
        double i;
        for (i = 1; i <= 10; i++) {
            int j;
            Numero.add(i);
            for (j = 1; j <= 10; j++) {
                Numero2.add((double) j);
                Multiplicacion.add(j * i);
                System.out.println(Numero.getLast() + "*" + Numero2.getLast() + "=" + Multiplicacion.getLast());
            }

        }

    }
}
