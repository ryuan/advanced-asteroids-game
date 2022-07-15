package edu.uchicago.gerber._01control;
import  java.util.Scanner;

/**
 * E4_1: A variety of programs to calculate sums and powers based on loop functions.
 */

public class E4_1 {
    public static void main(String[] args) {
        /*
        Program a: sums all even numbers between 2 and 100 inclusive
         */
        int sumEven = 0;
        for (int i = 2; i <= 100; i=i+2) {
            sumEven += i;
        }
        System.out.println(sumEven);

        /*
        Program b: sums all squares between 1 and 100 inclusive
         */
        int sumSq = 0;
        for (int i = 1; i <= 100; i++) {
            sumSq += i * i;
        }
        System.out.println(sumSq);

        /*
        Program c: prints all powers of 2 from powers of 0 to 20
         */
        for (int i = 0; i <= 20; i++) {
            int powerResult = (int) Math.pow(2,i);
            System.out.println(powerResult);
        }

        /*
        Program d: sums all odd numbers between user input a and b
         */
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the starting integer a: ");
        int startInt = in.nextInt();
        startInt = startInt % 2 == 0 ? startInt + 1 : startInt;

        System.out.print("Enter the ending integer b: ");
        int endInt = in.nextInt();
        endInt = endInt % 2 == 0 ? endInt - 1 : endInt;

        int sumOdd = 0;
        for (int i = startInt; i <= endInt; i=i+2) {
            sumOdd += i;
        }
        System.out.println(sumOdd);

        /*
        Program e: sums all odd digits of an input
         */
        System.out.print("Enter any integer: ");
        int userInput = in.nextInt();

        int sumOdd2 = 0;
        while (userInput / 10 > 0) {
            if ((userInput % 10) % 2 != 0) {
                sumOdd2 += userInput % 10;
            }
            userInput /= 10;
        }
        System.out.println(sumOdd2);
    }
}
