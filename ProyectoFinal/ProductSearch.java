package A123b;

import java.util.List;
import java.util.stream.Collectors;

import com.itextpdf.io.exceptions.IOException;

public class ProductSearch {
    public static void main(String[] args) {
        try {
            List<Product> products = ProductAPI.fetchProducts();
            String searchQuery = "Pullover"; // Cambia esto para buscar otro producto
            List<Product> filteredProducts = searchProductsByName(products, searchQuery);
            displayProducts(filteredProducts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> searchProductsByName(List<Product> products, String name) {
        return products.stream()
                .filter(product -> product.title.toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static void displayProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println("ID: " + product.id);
            System.out.println("Nombre: " + product.title);
            System.out.println("Precio: " + product.price);
            System.out.println("Descripción: " + product.description);
            System.out.println("Imágenes: " + String.join(", ", product.images));
            System.out.println("Categoría: " + product.category.name);
            System.out.println("-------------------------------------");
        }
    }
}
