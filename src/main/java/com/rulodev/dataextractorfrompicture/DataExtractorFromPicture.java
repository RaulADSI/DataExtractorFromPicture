
package com.rulodev.dataextractorfrompicture;

/**
 *
 * @author Raul_Torres
 */
public class DataExtractorFromPicture {

    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        PdfImageExtractor extractor = new PdfImageExtractor();
        String pdfPath = "C:\\Users\\strategic\\OneDrive\\Documentos\\ImagePdf.pdf"; // Ruta del archivo PDF
        String outputDirectory = "C:\\Users\\strategic\\OneDrive\\Documentos\\output\\";// Directorio donde guardar las imágenes

        try {
            extractor.extractImages(pdfPath, outputDirectory);
        } catch (Exception e) {
        }
    }
}
