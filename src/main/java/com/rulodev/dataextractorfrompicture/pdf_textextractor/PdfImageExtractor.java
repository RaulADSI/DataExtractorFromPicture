package com.rulodev.dataextractorfrompicture.pdf_textextractor;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Raul_Torres
 */
public class PdfImageExtractor {

    public void extractImagesFromPDF(String pdfPath, String outputDir) throws IOException {
        File file = new File(pdfPath);
        if (!file.exists()|| !file.isFile() || !pdfPath.toLowerCase().endsWith(".pdf")) {
            System.err.println("La ruta ingresada no corresponde a un archivo PDF válido: " + pdfPath);
            return;
        }

        // Carga el documento PDF
        try (PDDocument document = PDDocument.load(file)) {

            PDPageTree pages = document.getPages();
            int imageCounter = 1;

            for (PDPage page : pages) {
                PDResources resources = page.getResources();
                // Itera sobre los nombres de XObject presentes en la página
                for (COSName xObjectName : resources.getXObjectNames()) {
                    PDXObject xObject = resources.getXObject(xObjectName);
                    if (xObject instanceof PDImageXObject) {
                        PDImageXObject image = (PDImageXObject) xObject;

                        // Define un nombre para la imagen extraída
                        String imageName = "extractedImage_" + imageCounter + ".png";
                        File outputFile = new File(outputDir, imageName);

                        // Guarda la imagen a disco en formato PNG
                        ImageIO.write(image.getImage(), "png", outputFile);
                        System.out.println("Imagen extraída: " + outputFile.getAbsolutePath());

                        imageCounter++;
                    }
                }
            }

            if (imageCounter == 1) {
                System.out.println("No se encontraron imágenes en el PDF.");
            }
        }
    }
}
