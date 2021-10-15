package edu.uchicago.gerber._03objects.P8_6;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("What is the fuel efficiency of your car in mi/gal? ");
        double fuelEfficiency = in.nextDouble();
        Car myHybrid = new Car(fuelEfficiency);
        System.out.println("Uh oh! Your car currently has " + myHybrid.getGasLevel() + " gallons in the tank.");

        System.out.print("How many gallons of fuel do you want to add? ");
        double addFuel = in.nextDouble();
        myHybrid.addGas(addFuel);
        System.out.println("Your car now has " + myHybrid.getGasLevel() + " gallons in the tank.");

        System.out.print("How many miles do you want to drive? ");
        double driveMiles = in.nextDouble();
        myHybrid.drive(driveMiles);
        System.out.println("Your car now has " + myHybrid.getGasLevel() + " gallons in the tank.");
    }
}
