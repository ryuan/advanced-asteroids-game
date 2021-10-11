package edu.uchicago.gerber._02arrays;
import java.util.Scanner;

/**
 *  P5_8: Tests whether an input year is a leap year (a year with 366 days).
 */
public class P5_8 {
    public static boolean isLeapYear(int year) {
        /*
        Calculate if the input year is a leap year and return true/false
         */
        if ((year % 400 == 0 || year % 100 != 0) && year % 4 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a year to test if it is a leap year: ");
        int yearInput = in.nextInt();

        System.out.println(isLeapYear(yearInput));
    }
}
