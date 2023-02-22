package com.pravnainfo.pravnainformatika.services;

import com.pravnainfo.pravnainformatika.utils.PdfToConsoleSingleton;
import com.pravnainfo.pravnainformatika.utils.PdfToConsoleSingleton;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TestServiceImpl implements TestService {
    public static PdfToConsoleSingleton pdfObj;

    static {
        try {
            pdfObj = PdfToConsoleSingleton.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public String readPdf() {
        return pdfObj.getPdfAsString();
    }
}
