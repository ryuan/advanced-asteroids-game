package edu.uchicago.gerber._06design.P12_1;

public class Coin {
    private String type;
    private double value;

    public Coin(String type, double value) {
        this.type = type;
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
