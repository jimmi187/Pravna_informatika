package com.pravnainfo.pravnainformatika.services;

import com.pravnainfo.pravnainformatika.model.dtos.TipDelaDTO;

import java.io.IOException;

public interface DocumentService {
    String parsePDF(String brZakona, String docName);
    String parseCriminalLaw();
    String makeFactsRdf(TipDelaDTO dto) throws IOException, IllegalAccessException, InterruptedException;

}
