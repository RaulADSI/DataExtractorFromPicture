
package com.rulodev.dataextractorfrompicture;

/**
 *
 * @author Raul_Torres
 */
public class DataExtractorFromPicture {

    public static void main(String[] args) {
        
       PdfImageExtractor extractor = new PdfImageExtractor();
        String pdfPath = "C:\\Users\\strategic\\OneDrive\\Documentos\\ImagePdf.pdf"; // Ruta del archivo PDF
        String outputDirectory = "C:\\Users\\strategic\\OneDrive\\Documentos\\output\\"; // Directorio donde guardar las imágenes
        String csvPath = "C:\\Users\\strategic\\OneDrive\\Documentos\\imagenes.csv"; // Ruta del archivo CSV

        try {
            // Llamada al método para extraer imágenes y guardarlas en un CSV
            extractor.extractImagesToCsv(pdfPath, outputDirectory, csvPath);
        } catch (Exception e) {
            // Manejo de errores
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
