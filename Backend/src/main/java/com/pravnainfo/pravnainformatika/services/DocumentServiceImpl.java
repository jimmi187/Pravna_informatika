package com.pravnainfo.pravnainformatika.services;

import com.pravnainfo.pravnainformatika.utils.PDFParser;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService {
    public static PDFParser parser;

    static {
        try {
            parser = PDFParser.getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public String parsePDF(String brZakona, String docName) {
        return parser.convertPDFToString(brZakona, docName);
    }
}
