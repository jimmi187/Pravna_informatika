package com.pravnainfo.pravnainformatika.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PdfToConsoleSingletonTest {
    public static PdfToConsoleSingleton pdfObj;

    static {
        try {
            pdfObj = PdfToConsoleSingleton.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getPdfAsString() throws IOException {
        System.out.println(pdfObj.getPdfAsString());;
    }
}