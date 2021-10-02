package edu.uchicago.gerber._01control;
import java.util.Scanner;

/**
 * E3_14: Prompts user for month and day, then prints out the season.
 */

public class E3_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Prompts user for a month (in integer form) and day
         */
        int month;
        do {
            System.out.print("Enter a month in integer form (i.e., from 1 to 12): ");
            month = in.nextInt();
        }
        while (month > 12 || month < 1);

        int day;
        do {
            System.out.print("Enter a day of month (from 1 to 31): ");
            day = in.nextInt();
        }
        while (day > 31 || day < 1);

        /*
        Calculate the season given user input
         */
        String season; // declares the season string to avoid compile error
        if (month == 1 || month == 2 || month == 3) {
            season = "Winter";
        }
        else if (month == 4 || month == 5 || month == 6) {
            season = "Spring";
        }
        else if (month == 7 || month == 8 || month == 9) {
            season = "Summer";
        }
        else {
            season = "Fall";
        }

        if (month % 3 == 0 && day >= 21) {
            switch (season) {
                case "Winter":
                    season = "Spring";
                    break;
                case "Spring":
                    season = "Summer";
                    break;
                case "Summer":
                    season = "Fall";
                    break;
                default:
                    season = "Winter";
                    break;
            }
        }

        System.out.println("The season is " + season);
    }
}
