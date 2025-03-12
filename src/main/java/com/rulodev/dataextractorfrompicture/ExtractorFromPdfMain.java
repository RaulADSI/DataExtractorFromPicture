
package com.rulodev.dataextractorfrompicture;

import com.rulodev.dataextractorfrompicture.pdf_textextractor.PdfImageExtractor;
import java.io.IOException;

/**
 *
 * @author Raul_Torres
 */
public class ExtractorFromPdfMain {
    public static void main(String[] args) {
        System.out.println("Extraccion de imagenes desde el PDF...");

        // Ruta al PDF y directorio de salida
        String pdfPath = "C:\\Users\\strategic\\OneDrive\\Documentos\\Pdf_Picture\\Doc1.pdf";
        String outputDir = "C:\\Users\\strategic\\OneDrive\\Documentos\\Pdf_Picture";

        PdfImageExtractor pdfImageExtractor = new PdfImageExtractor();

        try {
            pdfImageExtractor.extractImagesFromPDF(pdfPath, outputDir);
            System.out.println("Proceso de extraccion completado.");
        } catch (IOException e) {
            System.err.println("Ocurrió un error durante la extracción: " + e.getMessage());
        }
    }
}
