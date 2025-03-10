
package com.rulodev.dataextractorfrompicture;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;


public class PdfImageExtractor {
    
     public void extractImages(String pdfPath, String outputDirectory) throws Exception {
        File file = new File(pdfPath);
        PDDocument document = PDDocument.load(file);
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        for (int page = 0; page < document.getNumberOfPages(); page++) {
            BufferedImage image = pdfRenderer.renderImageWithDPI(page, 300); // 300 DPI for better quality
            File outputFile = new File(outputDirectory + "/page-" + page + ".png");
            ImageIO.write(image, "png", outputFile);
        }

        document.close();
        System.out.println("Images extracted successfully to: " + outputDirectory);
    }
}
