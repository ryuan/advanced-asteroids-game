package edu.uchicago.gerber._02arrays;
import java.util.Random;

/**
 * E6_16: Prints an array of integers as a histogram.
 */
public class E6_16 {
    public static void histogram(int[] randomNumbers) {
        int maxNum = 0;
        for (int element : randomNumbers) {
            if (element > maxNum) {
                maxNum = element;
            }
        }

        int[] propNumbers = new int[randomNumbers.length];

        for (int i = 0; i < propNumbers.length; i++) {
            double ratio = (double) randomNumbers[i]/ (double) maxNum * 20;
            propNumbers[i] = (int) ratio;
        }

        for (int i = 20; i > 0; i--) {
            for (int element : propNumbers) {
                if (element >= i) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] randomNumbers = new int[8];

        System.out.print("For the array of integers: ");
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = rand.nextInt(100);
            System.out.print(randomNumbers[i] + " ");
        }

        System.out.println();
        System.out.println("The proportional histogram looks like: ");
        histogram(randomNumbers);
    }
}
