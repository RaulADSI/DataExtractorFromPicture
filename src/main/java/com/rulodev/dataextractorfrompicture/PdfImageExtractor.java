package com.rulodev.dataextractorfrompicture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PdfImageExtractor {

    public void extractImagesToCsv(String pdfPath, String outputDirectory, String csvPath) throws Exception {
        File file = new File(pdfPath);
        try (PDDocument document = PDDocument.load(file)) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            
            try (PrintWriter csvWriter = new PrintWriter(new File(csvPath))) {
                csvWriter.println("Página, Tabla de multiplicar");
                
                for (int page = 0; page < document.getNumberOfPages(); page++) {
                    BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300); // 300 DPI for better quality
                    File outputFile = new File(outputDirectory + "/page-" + page + ".png");
                    ImageIO.write(image, "png", outputFile);
                    
                    csvWriter.println((page + 1) + ", " + outputFile.getAbsolutePath());
                    System.out.println("Pagina " + (page + 1) + " : Imagen guardada en " + outputFile.getAbsolutePath());
                }
            }
        }
        System.out.println("Imagenes extraidas con exito: " + outputDirectory);
    }
}
