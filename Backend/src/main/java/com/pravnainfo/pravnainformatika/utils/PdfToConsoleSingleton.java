//package com.pravnainfo.pravnainformatika.utils;
//
//import java.io.File;
//import java.io.IOException;
//
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//@NoArgsConstructor
//public class PdfToConsole {
//    public static String getPdfAsString() throws IOException {
//        //Loading an existing document
//        File file = new File("D://Sample.pdf");
//        PDDocument document = PDDocument.load(file);
//        //Instantiate PDFTextStripper class
//        PDFTextStripper pdfStripper = new PDFTextStripper();
//        //Retrieving text from PDF document
//        String text = pdfStripper.getText(document);
//        System.out.println(text);
//        //Closing the document
//        document.close();
//
//        return text;
//    }
//}

package com.pravnainfo.pravnainformatika.utils;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfToConsoleSingleton {
    private static PdfToConsoleSingleton instance;
    private PdfToConsoleSingleton() {}

    public static PdfToConsoleSingleton getInstance() throws IOException {
        if (instance == null) {
            instance = new PdfToConsoleSingleton();
        }
        return instance;
    }

    public String getPdfAsString() throws IOException {

        //Loading an existing document
        File file = new File("C:\\Users\\cvijetinm\\Desktop\\pravna_repo\\Pravna_informatika\\doc\\Presude\\151\\test.pdf");
        PDDocument document = PDDocument.load(file);
        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();
        //Retrieving text from PDF document
        String pdfText = pdfStripper.getText(document);
        //Closing the document
        document.close();

        System.out.println(pdfText);
        return pdfText;
    }
}