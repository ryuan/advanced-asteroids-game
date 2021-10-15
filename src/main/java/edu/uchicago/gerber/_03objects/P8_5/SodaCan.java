package edu.uchicago.gerber._03objects.P8_5;

public class SodaCan {
    private double height;
    private double radius;
    private double surfaceArea;
    private double volume;

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public SodaCan(double height, double radius) {
        this.height = height;
        this.radius = radius;
        this.surfaceArea = (2 * this.height * this.radius * Math.PI) + (2 * this.radius * this.radius * Math.PI);
        this.volume = this.height * this.radius * this.radius * Math.PI;
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
