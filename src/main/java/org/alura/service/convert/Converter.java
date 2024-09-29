package org.alura.service.convert;

public class Converter {

    public double convert(double amount, double targetCurrencyValue, double sourceCurrencyValue) {
        return (targetCurrencyValue / sourceCurrencyValue) * amount;
    }
}
