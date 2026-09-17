package U1;

public class main {
    public static void main(String[] args) {
        Logica lista = new AuxLog(8);
        
        System.out.println("Agregando personas...");
        for(int i = 0;i<lista.p.length -1;i++) {
        	lista.Agregar(new Persona(Rutinas.nextInt(10, 25),Rutinas.nextNombre(1)));
        }
        System.out.println(lista.ContenidoCadena());
        lista.Agregar(new Persona(20, "Sofia Diaz Lopez"));
        Persona[] arr = lista.Contenido();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i + "]: " + 
                (arr[i] == null ? "null " : arr[i].getNombre()+ " ") + (arr[i] == null ? "0 " : arr[i].getSiguiente()));
        }
        lista.Retirar(new Persona (20, "Sofia Diaz Lopez"));
        System.out.println(lista.ContenidoCadena());

        
        System.out.println("\nArreglo físico:");
        Persona[] arr2 = lista.Contenido();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("[" + i + "]: " + 
                (arr2[i] == null ? "null " : arr2[i].getNombre()+ " ") + (arr2[i] == null ? "0 " : arr2[i].getSiguiente()));
        }
    }
}