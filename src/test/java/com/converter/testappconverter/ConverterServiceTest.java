package com.converter.testappconverter;

import com.converter.testappconverter.entity.ConversionRequest;
import com.converter.testappconverter.entity.ConversionResult;
import com.converter.testappconverter.entity.ConversionRule;
import com.converter.testappconverter.entity.Distance;
import com.converter.testappconverter.service.ConverterService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConverterServiceTest {

    @InjectMocks
    ConverterService converterService;

    @BeforeEach
    void setUp(){
        List<ConversionRule> realRules = new ArrayList<>();
        realRules.add(new ConversionRule("m", "ft", 3.281));
        converterService = new ConverterService(realRules);
    }

    @Test
    void convertTest(){
        ConversionRequest conversionRequest = new ConversionRequest(
                new Distance("m", 20), "ft"
        );

        ConversionResult result = converterService.convert(conversionRequest);

        Assertions.assertEquals(65.62, result.getValue());
        Assertions.assertEquals("ft", result.getUnit());
    }
}