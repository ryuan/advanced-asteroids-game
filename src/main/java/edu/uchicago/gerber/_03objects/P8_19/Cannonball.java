package edu.uchicago.gerber._03objects.P8_19;

public class Cannonball {
    private double x;
    private double y;
    private double xVelo;
    private double yVelo;

    public Cannonball(double x) {
        this.x = x;
        this.y = 0;
        this.xVelo = 0;
        this.yVelo = 0;
    }

    public void move(double sec) {
        double xDist = xVelo * sec;
        double yDist = yVelo * sec + (0.5 * -9.81 * sec * sec);

        x += xDist;
        if (y + yDist >= 0) {y += yDist;} else {y = 0;}

        this.yVelo += -9.81 * sec;
    }

    public void shoot(double angle, double velocity) {
        this.xVelo = velocity * Math.cos(angle);
        this.yVelo = velocity * Math.sin(angle);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
