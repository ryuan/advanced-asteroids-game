package edu.uchicago.gerber._04interfaces.E9_13;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        Loop through inputs ensuring proper integer inputs are assigned
         */
        int width = 0;
        int height = 0;
        while (width <1 && height <=0 ) {
            System.out.println("What is the width of the rectangle? ");
            width = in.nextInt();
            System.out.println("What is the height of the rectangle? ");
            height = in.nextInt();
        }

        /*
        Create BetterRectangle object and print out calculated results of perimeter and area
         */
        BetterRectangle betterRec = new BetterRectangle(width, height);

        System.out.println("Perimeter is " + betterRec.getPerimeter());
        System.out.println("Area is " + betterRec.getArea());
    }
}
