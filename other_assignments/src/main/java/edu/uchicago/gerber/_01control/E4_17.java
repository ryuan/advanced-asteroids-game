package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * E4_17: Converts an integer provided by the user into binary.
 */
public class E4_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Prompts user for an integer input
         */
        System.out.print("Enter an integer to convert into binary: ");
        int numInput = in.nextInt();

        /*
        Iterates through the input until it is 0, printing the binary digits along the way
         */
        while (numInput > 0) {
            System.out.println(numInput % 2);
            numInput /= 2;
        }
    }
}
