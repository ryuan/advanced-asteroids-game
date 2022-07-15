package edu.uchicago.gerber._03objects.P8_5;
import java.util.Scanner;

/**
 * P8_5: Takes user input for length and radius of a soda can, then returns its volume and surface area.
 */
public class Driver {
    public static void main(String[] args) {
        /*
        Initiate Scanner object to take user input
         */
        Scanner in = new Scanner(System.in);

        /*
        Take user input for height and radius, ensuring that they are nonnegative numbers
         */
        double heightInput = -99;
        double radiusInput = -99;
        while (heightInput < 0) {
            System.out.print("What is the height of your soda can in inches?: ");
            heightInput = in.nextDouble();
        }
        while (radiusInput < 0) {
            System.out.print("What is the radius of your soda can in inches?: ");
            radiusInput = in.nextDouble();
        }

        /*
        Pass user input values and initiate SodaCan object
         */
        SodaCan canDim = new SodaCan(heightInput, radiusInput);

        /*
        Print out soda can dimension stats
         */
        System.out.println("Given height and radius of " + heightInput + " and " + radiusInput + ", respectively:");
        System.out.println("Surface Area: " + canDim.getSurfaceArea());
        System.out.println("Volume: " + canDim.getVolume());
    }
}
