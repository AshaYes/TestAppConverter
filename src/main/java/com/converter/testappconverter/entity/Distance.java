package com.converter.testappconverter.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Distance {

    private static final Logger log = LoggerFactory.getLogger(Distance.class);
    private String unit;
    private double value;

    public Distance(String unit, double value) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        log.info("Unit: " + unit);
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
