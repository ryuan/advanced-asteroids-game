package edu.uchicago.gerber._03objects.P8_6;

public class Car {
    private double fuelEfficiency;
    private double fuelRemaining;

    public void addGas(double gallons) {
        this.fuelRemaining += gallons;
    }

    public void drive(double miles) {
        this.fuelRemaining -= miles/fuelEfficiency;
    }

    public double getGasLevel() {
        return fuelRemaining;
    }

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
        this.fuelRemaining = 0;
    }
}
