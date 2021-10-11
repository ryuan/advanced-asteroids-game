package edu.uchicago.gerber._02arrays;
import java.util.Random;
import java.util.Arrays;

/**
 * E6_12: Generates an array of 20 random integers (bounded between 0 and 99), then sorts it.
 */
public class E6_12 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] randomNumbers = new int[20];

        System.out.print("For the randomly generated array of 20 integers: ");
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(100);
            System.out.print(randomNumbers[i] + " ");
        }
        System.out.println();

        Arrays.sort(randomNumbers);
        System.out.print("The sorted array is: ");
        for (int element : randomNumbers) {
            System.out.print(element + " ");
        }
    }
}
