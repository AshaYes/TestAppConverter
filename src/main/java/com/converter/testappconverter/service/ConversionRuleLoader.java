package com.converter.testappconverter.service;

import com.converter.testappconverter.entity.ConversionRule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//class for downloading conversion rules from a file
@Service
public class ConversionRuleLoader {

    private final ConverterService converterService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Autowired
    public ConversionRuleLoader(
            ConverterService converterService,
            ObjectMapper objectMapper,
            ResourceLoader resourceLoader
    ) {
        this.converterService = converterService;
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
    }

    //adding rules to a List in ConverterService
    @PostConstruct
    public void loadRules() {
        try {
            List<ConversionRule> rules = readRulesFromFile("classpath:conversion_rules.json");
            rules.forEach(converterService::addConversionRule);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load conversion rules", e);
        }
    }

    //read from json file
    private List<ConversionRule> readRulesFromFile(String filePath) throws IOException {
        InputStream inputStream = resourceLoader.getResource(filePath).getInputStream();
        return objectMapper.readValue(inputStream, new TypeReference<>() {});
    }
}
