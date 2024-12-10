package A123b;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class ProductPDFCreator {

    public void guardaPDFDeProducto(Product product) throws DocumentException, FileNotFoundException{
        // Nombre del archivo PDF que se generará
        String pdfPath = "documento.pdf";
        
             // Creación del documento PDF
            Document document = new Document();
            
            // Crear el escritor de PDF
            PdfWriter instance = PdfWriter.getInstance(document, new java.io.FileOutputStream(pdfPath));
            // Abrir el documento para agregar contenido
            document.open();
            
            // Agregar texto al PDF
            try {
				document.add(new Phrase("Nombre del Producto: " + product.title + "\n" ));
			} catch (DocumentException e) {
				e.printStackTrace();
			}
            try {
				document.add(new Phrase("Precio del Producto: " + product.price + "\n" ));
			} catch (DocumentException e) {
				e.printStackTrace();
			}
            
            // Descargar y agregar imagen desde una URL
            String imageUrl = product.images.get(0); // URL de la imagen
            Image image = null;
			try {
				image = Image.getInstance(imageUrl);
			} catch (BadElementException | IOException e) {
				e.printStackTrace();
			}
            
            // Ajustar el tamaño de la imagen si es necesario
            image.scaleToFit(300, 300); // Ajusta el tamaño máximo (ancho, alto)
            document.add(image); // Agregar imagen al documento
            
            // Cerrar el documento
            document.close();
            
            System.out.println("PDF creado con éxito en: " + pdfPath);
 
    }
}

