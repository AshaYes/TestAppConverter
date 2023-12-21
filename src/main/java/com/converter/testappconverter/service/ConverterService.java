package com.converter.testappconverter.service;

import com.converter.testappconverter.entity.ConversionRequest;
import com.converter.testappconverter.entity.ConversionResult;
import com.converter.testappconverter.entity.ConversionRule;
import com.converter.testappconverter.entity.Distance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConverterService {

    private List<ConversionRule> conversionRules;

    @Autowired
    public ConverterService(List<ConversionRule> conversionRules) {
        this.conversionRules = conversionRules;
    }

    public ConversionResult convert(ConversionRequest request) {
        Distance sourceDistance = request.getDistance();
        String targetUnit = request.getConvertTo();

        ConversionRule rule = findConversionRule(sourceDistance.getUnit(), targetUnit);
        if (rule == null) {
            throw new IllegalArgumentException("Conversion rule not found.");
        }

        double convertedValue = sourceDistance.getValue() * rule.getConversionFactor();
        return new ConversionResult(roundToTwoDecimalPlaces(convertedValue), targetUnit);
    }

    private ConversionRule findConversionRule(String sourceUnit, String targetUnit) {
        return conversionRules.stream()
                .filter(rule -> rule.getFromUnit().equalsIgnoreCase(sourceUnit)
                        && rule.getToUnit().equalsIgnoreCase(targetUnit))
                .findFirst()
                .orElse(null);
    }

    //method to limit double value to hundredths
    private double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public void addConversionRule(ConversionRule conversionRule) {
        conversionRules.add(conversionRule);
    }
}
