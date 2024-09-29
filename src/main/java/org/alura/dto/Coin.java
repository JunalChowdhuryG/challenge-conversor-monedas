package org.alura.dto;

public class Coin {
    private String code; 
    private double amount;

    public Coin(String code, double value) {
        this.code = code;
        this.amount = value;
    }


    public String getCode() {
        return code;
    }

    public double getValue() {
        return amount;
    }
}
