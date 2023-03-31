package com.pravnainfo.pravnainformatika.controller;

import com.pravnainfo.pravnainformatika.model.dtos.TipDelaDTO;
import com.pravnainfo.pravnainformatika.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


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

    @GetMapping("krivicniZakonik")
    public ResponseEntity<String> getRandomString(){



        return new ResponseEntity<>(documentService.parseCriminalLaw(), HttpStatus.OK);
    }


    @PostMapping("test")
    public ResponseEntity test(@RequestBody TipDelaDTO dto) throws IOException, IllegalAccessException, InterruptedException, ParserConfigurationException, SAXException {
        documentService.makeFactsRdf(dto);
        Path filePath = Paths.get(System.getProperty("user.dir"), "./dr-device", "export.rdf");
        File fXmlFile = new File(filePath.toUri());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        NodeList nodeList = doc.getElementsByTagName("*");
        for(int i = 0; i< nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().toString().matches("export(.*)") && node.getTextContent().toString().contains("\n")){
                System.out.println("=========================================================================================");
                String tagName = node.getNodeName();
                String value = node.getTextContent();
                System.out.println("this is nodename: ->" + tagName + "<-: ->" + value+"<-");
            }
        }


//        HttpHeaders headers = new HttpHeaders();
//        headers.add("test", "test");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
