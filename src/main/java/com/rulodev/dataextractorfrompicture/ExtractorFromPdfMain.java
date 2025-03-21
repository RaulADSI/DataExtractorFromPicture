
package com.rulodev.dataextractorfrompicture;

import com.rulodev.dataextractorfrompicture.pdf_textextractor.PdfImageExtractor;
import java.io.File;
import java.io.IOException;

public class ExtractorFromPdfMain {
    public static void main(String[] args) {
        System.out.println("Extracción de imágenes desde todos los PDFs en la carpeta...");
        

        // Directorio que contiene los archivos PDF
        String inputDir = "C:\\Users\\strategic\\OneDrive\\Documentos\\Pdf_Picture";
        String outputDir = "C:\\Users\\strategic\\OneDrive\\Documentos\\Pdf_Picture";

        PdfImageExtractor pdfImageExtractor = new PdfImageExtractor();

        // Obtenemos todos los archivos del directorio
        File folder = new File(inputDir);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                // Procesamos solo archivos que terminen en .pdf
                if (file.isFile() && file.getName().toLowerCase().endsWith(".pdf")) {
                    System.out.println("Procesando: " + file.getName());

                    try {
                        // Extraer imágenes del archivo PDF actual
                        pdfImageExtractor.extractImagesFromPDF(file.getAbsolutePath(), outputDir);
                        System.out.println("Extracción completada para: " + file.getName());
                    } catch (IOException e) {
                        System.err.println("Ocurrió un error con " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
        } else {
            System.err.println("No se pudo leer el directorio especificado.");
        }
    }
}
