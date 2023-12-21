package com.converter.testappconverter.controlers;

import com.converter.testappconverter.entity.ConversionRequest;
import com.converter.testappconverter.entity.ConversionResult;
import com.converter.testappconverter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    private final ConverterService converterService;

    @Autowired
    public ConversionController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @PostMapping("/convert")
    public ResponseEntity<ConversionResult> convertDistance(@RequestBody ConversionRequest request) {
        try {
            ConversionResult result = converterService.convert(request);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
