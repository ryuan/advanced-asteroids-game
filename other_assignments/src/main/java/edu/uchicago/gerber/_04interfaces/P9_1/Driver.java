package edu.uchicago.gerber._04interfaces.P9_1;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WorldClock timeNow = new WorldClock(0);

        System.out.print(timeNow.getTime() + "\n");

        System.out.print("Let's see what time it is in another time zone! Type a number for the offset: ");
        timeNow.setOffset(in.nextInt());
        System.out.println(timeNow.getTime());
    }
}
