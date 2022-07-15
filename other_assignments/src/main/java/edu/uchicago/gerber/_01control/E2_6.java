package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * E2_6: Prompts the user for measurement input in meters, then converts it to miles, feet, and inches.
 */

public class E2_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Prompt user for measurement input in meters (accepts both integer and float-point entries)
         */
        System.out.print("Please enter a measurement in meters: ");
        double mInput = in.nextDouble();

        /*
        Calculate and print out the input measurement converted into miles, feet, and inches
        Conversions are rounded to 5 decimal places
         */
        System.out.println(mInput + " is approximately equal to:");

        double miOutput = mInput / 1609.3439999931;
        System.out.printf("%.5f miles%n", miOutput);

        double ftOutput = mInput * 3.280839895;
        System.out.printf("%.5f feet%n", ftOutput);

        double inOutput = mInput * 39.3700787403;
        System.out.printf("%.5f inches%n", inOutput);
    }
}
