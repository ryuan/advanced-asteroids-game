package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * E2_4: This program takes two integer inputs from the user and prints out a variety of calculated values.
 */

public class E2_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Ask user to input two integers and store them in distinct variables
         */
        System.out.print("Please enter your first integer: ");
        int num1 = in.nextInt();

        System.out.print("Please enter your second integer: ");
        int num2 = in.nextInt();

        /*
        Calculate and print out the sum, difference, product, average, distance, max, and min.
         */
        int sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

        int diff = num1 - num2;
        System.out.println("The difference of " + num1 + " and " + num2 + " is: " + diff);

        int prod = num1 * num2;
        System.out.println("The product of " + num1 + " and " + num2 + " is: " + prod);

        double mean = (double) (num1 + num2) / 2;
        System.out.println("The average of " + num1 + " and " + num2 + " is: " + mean);

        int dist = Math.abs(diff);
        System.out.println("The distance between " + num1 + " and " + num2 + " is: " + dist);

        int max = Math.max(num1, num2);
        int min= Math.min(num1, num2);
        System.out.println("The larger of " + num1 + " and " + num2 + " is: " + max);
        System.out.println("The smaller of " + num1 + " and " + num2 + " is: " + min);
    }
}
