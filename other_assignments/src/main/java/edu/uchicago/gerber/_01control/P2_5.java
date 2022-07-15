package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * P2_5: Prompts user for a price, then prints out the number of dollars and cents in that price.
 */

public class P2_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Prompt user for a price
         */
        System.out.print("Enter a price: ");
        double price = in.nextDouble();

        /*
        Convert the price into dollars and cents components, then print the result
         */
        int dollars = (int) price;
        int cents = (int) ((price - dollars) * 100 + 0.5);  // cast the calculation result as integer
        System.out.println("The price $" + price + " consists of " + dollars + " dollars and " + cents + " cents.");
    }
}
