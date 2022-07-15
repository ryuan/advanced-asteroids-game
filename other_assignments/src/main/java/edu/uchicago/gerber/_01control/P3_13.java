package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * P3_13: Given a year in integer form, convert it into Roman numeral format.
 */
public class P3_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Prompt user for input year, checking to make sure it is valid for Roman numeral conversion
         */
        int yearInput;
        do {
            System.out.print("Enter a year you want to Roman numeral: ");
            yearInput = in.nextInt();
        }
        while (yearInput > 3999 || yearInput < 1);

        /*
        Print out the millennium in Roman numeral format
        Ignore if input year is less than 1000
         */
        int milInt = yearInput / 1000;
        if (milInt > 0) {
            for (int i = 0; i < milInt; i++) {
                System.out.print("M");
            }
        }

        /*
        Convert and print out the remaining digits into Roman numeral form
         */
        int startInt = yearInput - milInt * 1000; // initialize the starting integer year after deducting millennium
        int divisor = 100; // initialize the starting divisor to extract the century within the loop

        for (int i = 0; i < 3; i++) { // loop through each digit (representing century, decade, then year)
            int tmpInt = startInt / divisor; // extract the digit representing century, decade, or year
            if (tmpInt > 0) { // convert the digit into Roman numeral only if it is not 0
                /*
                Adjust the specific Roman numerals that need to be appended based on digit index
                 */
                String oneRM = i==0 ? "C" : i==1 ? "X" : "I";
                String fiveRM = i==0 ? "D" : i==1 ? "L" : "V";
                String tenRM = i==0 ? "M" : i==1 ? "C" : "X";

                if (tmpInt == 9) {
                    System.out.print(oneRM + tenRM);
                }
                else if (tmpInt == 4) {
                    System.out.print(oneRM + fiveRM);
                }
                else if (tmpInt >= 5) {
                    System.out.print(fiveRM);
                    if (tmpInt > 5) {
                        for (int j = 0; j < (tmpInt - 5); j++) {
                            System.out.print(oneRM);
                        }
                    }
                }
                else {
                    for (int j = 0; j < tmpInt; j++) {
                        System.out.print(oneRM);
                    }
                }
            }
            startInt = startInt - tmpInt * divisor; // subtract away the current digit to prepare for next iteration
            divisor /= 10; // reduce the divisor to prepare for next iteration's digit extraction
        }
    }
}
