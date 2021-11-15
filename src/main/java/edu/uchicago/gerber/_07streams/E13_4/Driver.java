package edu.uchicago.gerber._07streams.E13_4;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Random rand = new Random();

        int n = rand.nextInt(100);

        String binString = toBinary(n);

        System.out.println("Original integer: " + n);
        System.out.println("Converted binary form: " + binString);
    }

    public static String toBinary(int num) {
        int a;
        if (num > 0) {
            a = num % 2;
            return (toBinary(num / 2) + "" + a);
        }
        return "";
    }
}
