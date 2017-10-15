package com.milan.celsiustofahrenheitconverter;

public class Temperature {

    private double celsiusValue;
    private double fahrenheitValue;
    public static final double CONVERSION_CONSTANT1 = 1.8;
    public static final int CONVERSION_CONSTANT2 = 32;
    public static final double CONVERSION_CONSTANT3 = 0.5556;

    public double getCelsiusValue() {
        return celsiusValue;
    }

    public void setCelsiusValue(double celsiusValue) {
        this.celsiusValue = celsiusValue;
    }

    public double getFahrenheitValue() {
        return fahrenheitValue;
    }

    public void setFahrenheitValue(double fahrenheitValue) {
        this.fahrenheitValue = fahrenheitValue;
    }


    public void convertCelsiusToFahrenHeit() {
        setFahrenheitValue((getCelsiusValue() * CONVERSION_CONSTANT1 + CONVERSION_CONSTANT2));
    }

    public void convertFahrenheitToCelsius() {
        setCelsiusValue((getFahrenheitValue() - CONVERSION_CONSTANT2) * CONVERSION_CONSTANT3);
    }
}
