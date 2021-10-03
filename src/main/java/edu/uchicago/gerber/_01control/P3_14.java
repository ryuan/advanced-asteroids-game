package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * Prompts user for a year to consider if it is a leap year.
 */
public class P3_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.print("Enter a year to check if it is a leap year: ");
        int yearInput = in.nextInt(); // ask user for a year to user as input

        /*
        Calculate if the input year is a leap year and print the result
         */
        if ((yearInput % 400 == 0 || yearInput % 100 != 0) && yearInput % 4 == 0) {
            System.out.println(yearInput + " is a leap year!");
        }
        else {
            System.out.println(yearInput + " is NOT a leap year!");
        }
    }
}
