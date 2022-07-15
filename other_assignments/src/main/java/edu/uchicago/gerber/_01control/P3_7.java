package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * P3_7: Given an income number, calculates and prints the total taxes owed in 1913.
 */
public class P3_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Prompts user for his/her income
         */
        System.out.print("What is your annual income in dollars?: ");
        double income = in.nextDouble();

        /*
        Calculates the possible max taxes owed at each income bracket
         */
        double maxTax50 = 50000 * 0.01;
        double maxTax75 = 25000 * 0.02 + maxTax50;
        double maxTax100 = 25000 * 0.03 + maxTax75;
        double maxTax250 = 150000 * 0.04 + maxTax100;
        double maxTax500 = 250000 * 0.05 + maxTax250;

        /*
        Calculates the user's taxes owed based on different income bracket rates
         */
        double taxes;
        if (income <= 50000) {
            taxes = income * 0.01;
        }
        else if (income <= 75000) {
            taxes = (income - 50000) * 0.02 + maxTax50;
        }
        else if (income <= 100000) {
            taxes = (income - 75000) * 0.03 + maxTax75;
        }
        else if (income <= 250000) {
            taxes = (income - 100000) * 0.04 + maxTax100;
        }
        else if (income <= 500000) {
            taxes = (income - 250000) * 0.05 + maxTax250;
        }
        else {
            taxes = (income - 500000) * 0.06 + maxTax500;
        }

        System.out.printf("You would only owe $%.2f in 1913, but wouldn't have YouTube and TikTok. :(", taxes);
    }
}
