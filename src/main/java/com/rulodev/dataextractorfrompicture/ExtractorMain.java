package com.rulodev.dataextractorfrompicture;

/**
 *
 * @author Raul_Torres
 */
public class ExtractorMain {

    public static void main(String[] args) {

        System.out.println("Extracción de texto de imágenes...");
        TextExtractor textExtractor = new TextExtractor();
        String imageDirectory = "C:\\Users\\strategic\\OneDrive\\Documentos\\output\\"; // Carpeta con las imágenes
        String csvPath = "C:\\Users\\strategic\\OneDrive\\Documentos\\textoExtraido.csv"; // Ruta del archivo CSV

        try {
            textExtractor.extractTextToCsv(imageDirectory, csvPath);
        } catch (Exception e) {
            System.err.println("Ocurrió un error durante la extracción: " + e.getMessage());
        }
    }
}

