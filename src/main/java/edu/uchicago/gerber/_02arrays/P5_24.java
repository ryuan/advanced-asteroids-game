package edu.uchicago.gerber._02arrays;
import java.util.Scanner;

/**
 *  P5_24: Given a year in Roman numeral form, convert it into integer format.
 */
public class P5_24 {
    /*
    Maintain a letter to number dictionary
     */
    public static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Prompt user for Roman numeral input year, checking to make sure it is not empty
         */
        String rnInput;
        do {
            System.out.print("Enter a Roman numeral you want to convert to integer form: ");
            rnInput = in.nextLine();
        }
        while (rnInput.length() == 0);

        /*
        For each character, look up its value and compare against the next (if it exists),
        then update the calculated integer year tracked as a sum total.
         */
        int total = 0;
        while (rnInput.length() > 0) {
            if (rnInput.length() == 1 || value(rnInput.charAt(0)) >= value(rnInput.charAt(1))) {
                total += value(rnInput.charAt(0));
                rnInput = rnInput.substring(1);
            }
            else {
                int diff = value(rnInput.charAt(1)) - value(rnInput.charAt(0));
                total += diff;
                rnInput = rnInput.substring(2);
            }
        }

        System.out.println(total);
    }
}
