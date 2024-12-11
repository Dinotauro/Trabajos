package A123b;

import com.google.gson.*;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"id\": 2,\n" +
                "  \"title\": \"Classic Red Pullover Hoodie\",\n" +
                "  \"price\": 10,\n" +
                "  \"description\": \"Elevate your casual wardrobe with our Classic Red Pullover Hoodie. Crafted with a soft cotton blend for ultimate comfort, this vibrant red hoodie features a kangaroo pocket, adjustable drawstring hood, and ribbed cuffs for a snug fit. The timeless design ensures easy pairing with jeans or joggers for a relaxed yet stylish look, making it a versatile addition to your everyday attire.\",\n" +
                "  \"images\": [\n" +
                "    \"https://i.imgur.com/1twoaDy.jpeg\",\n" +
                "    \"https://i.imgur.com/FDwQgLy.jpeg\",\n" +
                "    \"https://i.imgur.com/kg1ZhhH.jpeg\"\n" +
                "  ],\n" +
                "  \"creationAt\": \"2024-11-21T00:36:25.000Z\",\n" +
                "  \"updatedAt\": \"2024-11-21T00:36:25.000Z\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Clothes\",\n" +
                "    \"image\": \"https://i.imgur.com/QkIa5tT.jpeg\",\n" +
                "    \"creationAt\": \"2024-11-21T00:36:25.000Z\",\n" +
                "    \"updatedAt\": \"2024-11-21T00:36:25.000Z\"\n" +
                "  }\n" +
                "}";

        // Crear el objeto Gson con el adaptador para LocalDateTime
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())  // Registrar el adaptador
                .create();

        // Deserializar el JSON en un objeto Product
        Product product = gson.fromJson(json, Product.class);

        // Imprimir el resultado
        System.out.println("Product Title: " + product.title);
        System.out.println("Category Name: " + product.category.name);
        System.out.println("Creation Date: " + product.creationAt);
    }
}