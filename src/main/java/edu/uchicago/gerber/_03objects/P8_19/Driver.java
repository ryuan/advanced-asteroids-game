package edu.uchicago.gerber._03objects.P8_19;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cannonball ball = new Cannonball(0);

        System.out.print("What is the launch angle of your cannonball? ");
        double alpha = in.nextDouble();
        System.out.print("What is the launch velocity of the ball? ");
        double v = in.nextDouble();

        System.out.println("3. 2.. 1... BOOM!!! Off we go! Your cannonball blasts off.");
        ball.shoot(alpha, v);

        ball.move(0.1);
        System.out.println("(" + ball.getX() + ", " + ball.getY() + ")");
        while (ball.getY() > 0) {
            ball.move(0.1);
            System.out.println("(" + ball.getX() + ", " + ball.getY() + ")");
        }
        System.out.println("The cannonball drops with a *THUD* in the distance. Dust surround its landing spot.");
    }
}
