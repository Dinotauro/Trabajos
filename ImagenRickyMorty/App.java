package ImagenRickyMorty;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws Exception {
        try {
        	Scanner var = new Scanner(System.in);
        	int Id = var.nextInt();
            Character Character = ApiUtil.getCharacterById(Id);
            System.out.println("Nombre: " + Character.name);
            System.out.println("Estado: " + ImagenRickyMorty.Character.image);
            // Imprimir más datos según sea necesario 
            var.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
    }


}
