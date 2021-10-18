package edu.uchicago.gerber._03objects.P8_6;

public class Car {
    /*
    Declare the instance variables
     */
    private final double fuelEfficiency;
    private double fuelRemaining;

    /**
     * Pass gallon amount from user input to current fuelRemaining instance variable
     * @param gallons sum total of fuel with input gallons added
     */
    public void addGas(double gallons) {
        this.fuelRemaining += gallons;
    }

    /**
     * Uses the miles input to calculate fuelRemaining given car fuelEfficiency
     * @param miles miles driven
     */
    public void drive(double miles) {
        this.fuelRemaining -= miles/fuelEfficiency;
    }

    /**
     * Getter for fuel remaining in car
     * @return  fuelRemaining
     */
    public double getGasLevel() {
        return fuelRemaining;
    }

    /**
     * Constructor for new Car object
     * @param fuelEfficiency define fuel efficiency of the car
     */
    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
        this.fuelRemaining = 0;
    }
}
