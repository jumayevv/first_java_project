package projects;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import java.io.File;

public class tester {
    public static void main(String[] args) {
        String imagePath = "E:\\Dars\\src\\main\\java\\projects\\test.jpg";

        ITesseract tesseract = new Tesseract();

        try {
            // Set the path to Tesseract data folder (containing language files)
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

            tesseract.setLanguage("eng");

            String result = tesseract.doOCR(new File(imagePath));

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


