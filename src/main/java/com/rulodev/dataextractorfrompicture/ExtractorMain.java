package com.rulodev.dataextractorfrompicture;

/**
 *
 * @author Raul_Torres
 */
public class ExtractorMain {

    public static void main(String[] args) {
         System.out.println("Extracción de texto de imágenes...");

        // Instancia de la clase que realizará la extracción
        TextExtractor textExtractor = new TextExtractor();

        // Ruta a la carpeta que contiene las imágenes y al archivo CSV de salida
        String imageDirectory = "C:\\Users\\strategic\\OneDrive\\Documentos\\Pdf_Picture";
        String csvPath = "C:\\Users\\strategic\\OneDrive\\Documentos\\textoExtraido.csv";

        try {
            textExtractor.extractTextToCsv(imageDirectory, csvPath);
            System.out.println("Extracción completada. Revisa el archivo CSV en: " + csvPath);
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la extracción: " + e.getMessage());
        }
        
 }
}

