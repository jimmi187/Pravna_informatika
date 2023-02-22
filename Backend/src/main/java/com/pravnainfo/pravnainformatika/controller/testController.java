package com.pravnainfo.pravnainformatika.controller;

import com.pravnainfo.pravnainformatika.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
@RestController
public class testController {
    public final TestService testService;
    @GetMapping

    public ResponseEntity getRandomString(){
        return new ResponseEntity(testService.readPdf(), HttpStatus.ACCEPTED);
    }
}
