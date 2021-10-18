package edu.uchicago.gerber._03objects.P8_6;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        /*
        Initiate new Scanner object
         */
        Scanner in = new Scanner(System.in);

        /*
        Take user input for fuel efficiency and pass it to initiate new Car object
         */
        System.out.print("What is the fuel efficiency of your car in mi/gal? ");
        double fuelEfficiency = in.nextDouble();
        Car myHybrid = new Car(fuelEfficiency);
        System.out.println("Uh oh! Your car currently has " + myHybrid.getGasLevel() + " gallons in the tank.");

        /*
        Give user the option to add gas to the car
         */
        System.out.print("How many gallons of fuel do you want to add? ");
        double addFuel = in.nextDouble();
        myHybrid.addGas(addFuel);
        System.out.println("Your car now has " + myHybrid.getGasLevel() + " gallons in the tank.");

        /*
        Drive the car and return the remaining fuel level
         */
        System.out.print("How many miles do you want to drive? ");
        double driveMiles = in.nextDouble();
        myHybrid.drive(driveMiles);
        System.out.println("Your car now has " + myHybrid.getGasLevel() + " gallons in the tank.");
    }
}
