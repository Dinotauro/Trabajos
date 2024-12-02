package ImagenRickyMorty;
import java.util.List;

public class Character {
	public int id;
    public String name;
    public String status;
    public String species;
    public String type;
    public String gender;
    public Origin origin;
    public Location location;
    public static String image;
    public List<String> episode;
    public String url;
    public String created;

    // Clase anidada para Origin
    public static class Origin {
        public String name;
        public String url;
    }
    

    // Clase anidada para Location
    public static class Location {
        public String name;
        public String url;
    }

	public static String getImage() {
		return image;
	}

	public static void setImage(String image) {
	    Character.image = image.replace("\"", "");
	}

}