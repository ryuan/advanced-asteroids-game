package edu.uchicago.gerber._03objects.P8_19;
import java.util.Scanner;

/**
 * P8_19: Program for shooting and tracking the movement of a Cannonball objects
 */
public class Driver {
    public static void main(String[] args) {
        /*
        Initiate Scanner and Cannonball objects
         */
        Scanner in = new Scanner(System.in);
        Cannonball ball = new Cannonball(0);

        /*
        Ask user for initial launch angle for velocity to pass into Cannonball's shoot method
         */
        System.out.print("What is the launch angle of your cannonball? ");
        double alpha = in.nextDouble();
        System.out.print("What is the launch velocity of the ball? ");
        double v = in.nextDouble();

        /*
        Shoot the ball to put the ball in motion
         */
        System.out.println("3. 2.. 1... BOOM!!! Off we go! Your cannonball blasts off.");
        ball.shoot(alpha, v);

        /*
        Repeatedly loop through and print current ball position given interval time until y-position is 0
         */
        ball.move(0.1);
        System.out.println("(" + ball.getX() + ", " + ball.getY() + ")");
        while (ball.getY() > 0) {
            ball.move(0.1);
            System.out.println("(" + ball.getX() + ", " + ball.getY() + ")");
        }
        System.out.println("The cannonball drops with a *THUD* in the distance. Dust surround its landing spot.");
    }
}
