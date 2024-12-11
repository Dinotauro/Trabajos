package ImagenRickyMorty;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ApiUtil {

    /*
     * CLASE de UTILERIA para consumir una API y transformar de formato JSON a Character
     * NOTA> No ocupan entender todo el proceso, solo ocupan saber que al ejecutar la
     * funcion getCharacterById y enviarle un numero identificador como parametro
     * regresara un Objeto de tipo Character con todas los atributos (Variables) de dicho
     * personaje.
     * ***Codigo creado con ChatGPT, puede tronar =)
     */
    private static final String API_URL = "https://rickandmortyapi.com/api/character/";

    public static Character getCharacterById(int id) throws Exception {
        String urlString = API_URL + id;
        @SuppressWarnings("deprecation")
		URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Comprobar el código de respuesta
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            output.append(line);
        }
        conn.disconnect();

        // Parsear el JSON manualmente
        return parseCharacter(output.toString());
    }

    private static Character parseCharacter(String json) {
        // System.out.println("JSON recibido: " + json.toString());
        Character character = new Character();
        
        character.id = Integer.parseInt(getValue(json, "id"));
        character.name = getValue(json, "name");
        character.status = getValue(json, "status");
        character.species = getValue(json, "species");
        character.type = getValue(json, "type");
        character.gender = getValue(json, "gender");
        
        // Origin
        
        String originJson = getValue(json, "origin");
        character.origin = new Character.Origin();
        character.origin.name = getValue(originJson, "name");
        character.origin.url = getValue(originJson, "url");
        
        // Location
        String locationJson = getValue(json, "location");
        character.location = new Character.Location();
        character.location.name = getValue(locationJson, "name");
        character.location.url = getValue(locationJson, "url");
        
        Character.setImage(getValue(json, "image"));

        // Extraer episodios
        parseEpisodes(character, json);
 
        character.url = getValue(json, "url");
        character.created = getValue(json, "created");

        return character;
    }

    private static void parseEpisodes(Character character, String json) {
        String episodeString = getValue(json, "episode");
    if (episodeString.startsWith("[") && episodeString.endsWith("]")) {
        // Eliminar los corchetes y separar por comas
        episodeString = episodeString.substring(1, episodeString.length() - 1);
        String[] episodes = episodeString.split(",");
        character.episode = new ArrayList<>();
        for (String episode : episodes) {
            character.episode.add(episode.trim());
        }
    }
    }

    private static String getValue(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int startIndex = json.indexOf(searchKey);
    
        // Si no se encuentra la clave, lanzar una excepción
        if (startIndex == -1) {
            throw new IllegalArgumentException("Key \"" + key + "\" not found in JSON.");
        }
    
        startIndex += searchKey.length();
        int endIndex = startIndex;
    
        // Ignorar espacios en blanco
        while (startIndex < json.length() && json.charAt(startIndex) == ' ') {
            startIndex++;
        }
    
        // Manejo de diferentes tipos de valores
        char firstChar = json.charAt(startIndex);
        if (firstChar == '\"') {
            // Valor es una cadena
            endIndex = json.indexOf("\"", startIndex + 1);
            while (endIndex != -1 && json.charAt(endIndex - 1) == '\\') {
                endIndex = json.indexOf("\"", endIndex + 1); // Manejar comillas escapadas
            }
            // Si es una cadena vacía, ajustar endIndex
            if (endIndex == -1 || (endIndex == startIndex + 1 && json.charAt(startIndex + 1) == '\"')) {
                return ""; // Retornar cadena vacía
            }
        } else if (firstChar == '{' || firstChar == '[') {
            // Valor es un objeto o una lista
            endIndex = findClosingBracket(json, startIndex);
        } else {
            // Valor es un número o booleano
            endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = json.indexOf("}", startIndex);
            }
            if (endIndex == -1) {
                throw new IllegalArgumentException("Could not find end of value for key \"" + key + "\".");
            }
        }
    
        String value = json.substring(startIndex, endIndex).trim();
    
        // Eliminar comillas solo si el valor es una cadena y no está vacío
        if (value.length() > 0 && value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }
    
        return value;
    }
    
    private static int findClosingBracket(String json, int startIndex) {
        int bracketCount = 0;
        for (int i = startIndex; i < json.length(); i++) {
            if (json.charAt(i) == '{' || json.charAt(i) == '[') {
                bracketCount++;
            } else if (json.charAt(i) == '}' || json.charAt(i) == ']') {
                bracketCount--;
                if (bracketCount == 0) {
                    return i + 1; // Retornar el índice después del cierre
                }
            }
        }
        throw new IllegalArgumentException("Could not find closing bracket for JSON object or array.");
    }
}