package edu.uchicago.gerber._03objects.P8_1;
import  java.util.Scanner;

/**
 * P8_1: Simulates a microwave by taking in inputs and "runs" the microwave based on selected options.
 */
public class Driver {
    public static void main(String[] args) {
        Microwave microwave = new Microwave();
        Scanner in = new Scanner(System.in);

        int input = 0;
        while (input != 4 || microwave.getTimer() == 0) {
            System.out.println("You see four different buttons on your microwave.");
            System.out.println("Button 1 - Add 30 seconds to the timer");
            System.out.println("Button 2 - Change the power level between 1 and 2");
            System.out.println("Button 3 - Reset the timer");
            System.out.println("Button 4 - Start the microwave!");
            System.out.print("Type the number for the button you want to press: ");

            input = in.nextInt();
            if (input == 1) {
                microwave.add30Button();
            } else if (input == 2) {
                microwave.changeLevelButton();
            } else if (input == 3) {
                microwave.resetButton();
            } else if (input == 4) {
                if (microwave.getTimer() == 0) {
                    System.out.println("There's 0 seconds on the timer! Microwave just makes a beeping noise.");
                } else {
                    microwave.startButton();
                    System.out.println("Thanks for using the microwave!");
                }
            } else {
                System.out.println("The option you selected does not exist! Try again...");
            }
            System.out.println();
        }
    }
}
