package edu.uchicago.gerber._04interfaces.E9_17;


public class SodaCan implements Measurable {
    /*
    Declare instance variables height and radius
     */
    private final double height;
    private final double radius;

    /**
     * Constructor for passing user input into instance variables
     * @param height    height of soda can
     * @param radius    radius of soda can
     */
    public SodaCan(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    /**
     * Calculates surface area of cylinder based on stored height and radius values
     * @return double of calculated surface area
     */
    public double getSurfaceArea() {
        return (2 * this.height * this.radius * Math.PI) + (2 * this.radius * this.radius * Math.PI);
    }

    /**
     * Calculates volume of a cylinder based on stored height and radius values
     * @return double of calculated volume
     */
    public double getVolume() {
        return this.height * this.radius * this.radius * Math.PI;
    }

    public double getMeasure() {
        return this.getSurfaceArea();
    }
}
