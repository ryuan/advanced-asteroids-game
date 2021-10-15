package edu.uchicago.gerber._03objects.P8_5;

public class SodaCan {
    private double height;
    private double radius;

    public SodaCan(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public double getSurfaceArea() {
        return (2 * this.height * this.radius * Math.PI) + (2 * this.radius * this.radius * Math.PI);
    }

    public double getVolume() {
        return this.height * this.radius * this.radius * Math.PI;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
