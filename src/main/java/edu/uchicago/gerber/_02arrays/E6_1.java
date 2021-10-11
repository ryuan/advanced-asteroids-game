package edu.uchicago.gerber._02arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * P6_1: Randomly generate an array of 10 integers, then print out some facts about them.
 */
public class E6_1 {
    public static void evenIndex(int[] randomNumbers) {
        System.out.print("The elements with even index are: ");

        for (int i = 0; i < randomNumbers.length; i++) {
            if (i % 2 == 0) {
                System.out.print(randomNumbers[i] + " ");
            }
        }
    }

    public static void evenElement(int[] randomNumbers) {
        System.out.print("The even elements are: ");

        for (int element : randomNumbers) {
            if (element % 2 == 0) {
                System.out.print(element + " ");
            }
        }
    }

    public static void reverseOrder(int[] randomNumbers) {
        System.out.print("The reversed order array is: ");

        for (int i = randomNumbers.length - 1; i >= 0; i--) {
            System.out.print(randomNumbers[i] + " ");
        }
    }

    public static void firstLast(int[] randomNumbers) {
        System.out.print("The first and last elements are: ");
        System.out.print(randomNumbers[0] + " " + randomNumbers[randomNumbers.length - 1]);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] randomNumbers = new int[10];

        System.out.print("For the randomly generated array of integers: ");
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(50);
            System.out.print(randomNumbers[i] + " ");
        }
        System.out.println();

        evenIndex(randomNumbers);
        System.out.println();
        evenElement(randomNumbers);
        System.out.println();
        reverseOrder(randomNumbers);
        System.out.println();
        firstLast(randomNumbers);
    }
}
