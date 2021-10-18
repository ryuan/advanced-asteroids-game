package edu.uchicago.gerber._03objects.P8_19;

public class Cannonball {
    /*
    Declare class instance variables
     */
    private double x;
    private double y;
    private double xVelo;
    private double yVelo;

    /**
     * Constructor for initiating instance variables after passing in initial x-position
     * @param x starting x-position of the Cannonball
     */
    public Cannonball(double x) {
        this.x = x;
        this.y = 0;
        this.xVelo = 0;
        this.yVelo = 0;
    }

    /**
     * Moves the Cannonball location based on time spanned argument
     * @param sec   the time the cannonball traveled
     */
    public void move(double sec) {
        double xDist = xVelo * sec;
        double yDist = yVelo * sec + (0.5 * -9.81 * sec * sec);

        x += xDist;
        if (y + yDist >= 0) {y += yDist;} else {y = 0;}

        this.yVelo += -9.81 * sec;
    }

    /**
     * Shoots the Cannonball to place the object in motion, calculated x- and y-velocities
     * @param angle     initial launch angle
     * @param velocity  initial velocity or launch
     */
    public void shoot(double angle, double velocity) {
        this.xVelo = velocity * Math.cos(angle);
        this.yVelo = velocity * Math.sin(angle);
    }

    /**
     * Getter for x-position
     * @return  current x-position
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for y-position
     * @return  current y-position
     */
    public double getY() {
        return y;
    }
}
