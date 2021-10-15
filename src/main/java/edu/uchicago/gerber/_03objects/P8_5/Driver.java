package edu.uchicago.gerber._03objects.P8_5;
import java.util.Scanner;

/**
 * P8_5: Takes user input for length and radius of a soda can, then returns its volume and surface area.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double heightInput = 0;
        double radiusInput = 0;
        while (heightInput <= 0) {
            System.out.print("What is the height of your soda can in inches?: ");
            heightInput = in.nextDouble();
        }
        while (radiusInput <= 0) {
            System.out.print("What is the radius of your soda can in inches?: ");
            radiusInput = in.nextDouble();
        }

        SodaCan canDim = new SodaCan(heightInput, radiusInput);

        System.out.println("Given height and radius of " + heightInput + " and " + radiusInput + ", respectively:");
        System.out.println("Surface Area: " + canDim.getSurfaceArea());
        System.out.println("Volume: " + canDim.getVolume());
    }
}
