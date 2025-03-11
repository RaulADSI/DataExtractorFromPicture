
package com.rulodev.dataextractorfrompicture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
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
        tesseract.setDatapath("tessdata"); // Ruta donde están los archivos de datos de Tesseract
        tesseract.setLanguage("eng"); // Cambia el idioma si es necesario, por ejemplo, "spa" para español

        // Crear archivo CSV
        PrintWriter csvWriter = new PrintWriter(new File(csvPath));
        csvWriter.println("Archivo, Texto Extraído"); // Encabezado del CSV

        File dir = new File(imageDirectory);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".png"));

        if (files != null) {
            for (File file : files) {
                try {
                    BufferedImage image = ImageIO.read(file);
                    String text = tesseract.doOCR(image); // Extrae texto de la imagen
                    csvWriter.println(file.getName() + ", \"" + text.replace("\n", " ") + "\""); // Guardar texto en el CSV
                    System.out.println("Texto extraído de " + file.getName());
                } catch (TesseractException e) {
                    System.err.println("No se pudo extraer texto de " + file.getName() + ": " + e.getMessage());
                }
            }
        }

        // Cerrar el archivo CSV
        csvWriter.close();
        System.out.println("El texto ha sido extraído y guardado en: " + csvPath);
    }
}
