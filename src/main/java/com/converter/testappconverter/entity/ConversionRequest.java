package com.converter.testappconverter.entity;

import java.util.Objects;

//class for conversion request
public class ConversionRequest {
    private Distance distance;
    private String convertTo;

    public ConversionRequest(Distance distance, String convertTo) {
        this.distance = distance;
        this.convertTo = convertTo;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    @Override
    public String toString() {
        return "ConversionRequest{" +
                "distance=" + distance.toString() +
                ", convertTo='" + convertTo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConversionRequest that)) return false;
        return Objects.equals(getDistance(), that.getDistance()) && Objects.equals(getConvertTo(), that.getConvertTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistance(), getConvertTo());
    }
}
