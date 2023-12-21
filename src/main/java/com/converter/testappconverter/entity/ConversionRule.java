package com.converter.testappconverter.entity;

import java.util.Objects;

public class ConversionRule {
    private String fromUnit;
    private String toUnit;
    private double conversionFactor;

    public ConversionRule(String fromUnit, String toUnit, double conversionFactor) {
        this.fromUnit = fromUnit;
        this.toUnit = toUnit;
        this.conversionFactor = conversionFactor;
    }

    public String getFromUnit() {
        return fromUnit;
    }

    public void setFromUnit(String fromUnit) {
        this.fromUnit = fromUnit;
    }

    public String getToUnit() {
        return toUnit;
    }

    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public String toString() {
        return "ConversionRule{" +
                "fromUnit='" + fromUnit + '\'' +
                ", toUnit='" + toUnit + '\'' +
                ", conversionFactor=" + conversionFactor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversionRule that)) return false;
        return Double.compare(that.getConversionFactor(), getConversionFactor()) == 0 && Objects.equals(getFromUnit(), that.getFromUnit()) && Objects.equals(getToUnit(), that.getToUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFromUnit(), getToUnit(), getConversionFactor());
    }
}
