package com.rulodev.dataextractorfrompicture;

import java.io.File;
import java.io.FileWriter;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 *
 * @author Raul_Torres
 */
public class TextExtractor {

    public void extractTextToCsv(String imageDirectory, String csvPath) throws Exception {
        // Inicializar Tesseract OCR
       
        Tesseract tesseract = new Tesseract();

        // Configura el path a los datos del Tesseract 
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        File folder = new File(imageDirectory);
        File[] files = folder.listFiles();

        if (files == null) {
            System.err.println("No se encontraron archivos en la carpeta: " + imageDirectory);
            return;
        }

        // Abre el CSV para escribir los resultados
        try (FileWriter writer = new FileWriter(csvPath)) {
            // Escribe el encabezado del CSV
            writer.write("NombreImagen,TextoExtraido\n");

            // Recorre cada archivo de la carpeta
            for (File file : files) {
                if (file.isFile() && isImageFile(file)) {
                    try {
                        // Extrae el texto de la imagen
                        String result = tesseract.doOCR(file);
                        // Reemplazar saltos de línea para que el CSV quede correcto
                        result = result.replace("\n", " ").replace("\r", " ");
                        // Escribe en el CSV (se coloca el texto entre comillas para evitar problemas con las comas)
                        writer.write(file.getName() + ",\"" + result + "\"\n");
                        
                        
                        System.out.println("Imagen: " + file.getName());
                        System.out.println("--------------------------------------------------");
                        System.out.println(result);
                        System.out.println("--------------------------------------------------\n");
                    
                    } catch (TesseractException e) {
                        System.err.println("Error procesando " + file.getName() + ": " + e.getMessage());
                        writer.write(file.getName() + ",\"Error: " + e.getMessage() + "\"\n");
                    }
                }
            }
        }
    }
     // Método auxiliar para verificar si el archivo es una imagen
    private boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")
            || name.endsWith(".bmp") || name.endsWith(".tiff")
            || name.endsWith(".tiff");
    }
}
