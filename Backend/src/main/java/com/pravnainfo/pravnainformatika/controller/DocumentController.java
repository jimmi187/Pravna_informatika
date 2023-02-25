package com.pravnainfo.pravnainformatika.controller;

import com.pravnainfo.pravnainformatika.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/api/v1/document")
@RestController
public class DocumentController {
    public final DocumentService documentService;
    @GetMapping("{brZakona}/{docName}")

    public ResponseEntity<String> getRandomString(@PathVariable("brZakona") String brZakona,
                                                  @PathVariable("docName") String docName){
        return new ResponseEntity<>(documentService.parsePDF(brZakona, docName), HttpStatus.OK);
    }
}
