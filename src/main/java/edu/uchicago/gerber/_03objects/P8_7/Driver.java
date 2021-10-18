package edu.uchicago.gerber._03objects.P8_7;
import java.util.Scanner;

/**
 * P8_7: Allow user to lock and unlock a combo lock
 */
public class Driver {
    public static void main(String[] args) {
        /*
        Initiate new Scanner object
         */
        Scanner in = new Scanner(System.in);

        /*
        Set the combination lock
         */
        int secret1 = 999;
        while (secret1 < 0 || secret1 > 39) {
            System.out.print("\nSet your lock's first combination number: ");
            secret1 = in.nextInt();
            if (secret1 < 0 || secret1 > 39) {
                System.out.print("Your lock combination number must be between 0 and 39 inclusive. Try again.");
            }
        }
        int secret2 = 999;
        while (secret2 < 0 || secret2 > 39) {
            System.out.print("\nSet your lock's second combination number: ");
            secret2 = in.nextInt();
            if (secret2 < 0 || secret2 > 39) {
                System.out.print("Your lock combination number must be between 0 and 39 inclusive. Try again.");
            }
        }
        int secret3 = 999;
        while (secret3 < 0 || secret3 > 39) {
            System.out.print("\nSet your lock's third combination number: ");
            secret3 = in.nextInt();
            if (secret3 < 0 || secret3 > 39) {
                System.out.print("Your lock combination number must be between 0 and 39 inclusive. Try again.");
            }
        }

        /*
        Pass the three lock numbers from user to initiate ComboLock object
         */
        ComboLock lock = new ComboLock(secret1, secret2, secret3);
        System.out.println("\nYour lock is now set! Try to unlock it...");

        /*
        Initiate default variables for combo unlocking control flow
         */
        String action = "";
        String direction = "";
        int ticks = 999;


        /*
        Loop through the different options for unlocking the ComboLock, ensuring valid inputs along the way
         */
        while (!action.equalsIgnoreCase("T") || !action.equalsIgnoreCase("R") || !action.equalsIgnoreCase("O")) {
            System.out.println("\nDo you want to turn, reset, or open the lock?");
            System.out.print("Type T to turn, R to reset, or O to open: ");
            action = in.next();

            /*
            If user chooses to turn lock, give option to turn it left or right and take number of ticks as input
             */
            if (action.equalsIgnoreCase("T")) {
                while (!direction.equalsIgnoreCase("L") && !direction.equalsIgnoreCase("R")) {
                    System.out.print("\nTurn the lock left or right? Type L for left, R for right: ");
                    direction = in.next();
                }

                while (ticks < 0 || ticks > 39) {
                    System.out.print("\nHow many ticks do you want to turn? ");
                    ticks = in.nextInt();
                    if (ticks < 0 || ticks > 39) {
                        System.out.print("You can only move between 0 and 39 ticks inclusive. Try again.");
                    }
                }

                if (direction.equalsIgnoreCase("L")) {
                    lock.turnLeft(ticks);
                } else {
                    lock.turnRight(ticks);
                }

                /*
                Resets the control flow variables to prepare for next loop
                 */
                action = "";
                direction = "";
                ticks = 999;
            }

            /*
            Give user the option to reset the lock
             */
            if (action.equalsIgnoreCase("R")) {
                lock.reset();
                System.out.println("\nThe turns have been reset. You can try to unlock it again.");
                action = "";
            }

            /*
            Give user the option to open the lock. If successful, program ends.
             */
            if (action.equalsIgnoreCase("O")) {
                if (lock.open()) {
                    System.out.println("\nYou opened the lock - hooray!!!");
                    break;
                } else {
                    System.out.println("\nThe lock remains locked...");
                }
                action = "";
            }
        }
    }
}