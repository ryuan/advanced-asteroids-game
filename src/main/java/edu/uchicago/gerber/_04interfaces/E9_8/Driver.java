package edu.uchicago.gerber._04interfaces.E9_8;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BasicAccount newBA = new BasicAccount();

        System.out.println("You just created a new Basic Account at the world's greatest bank, Java Bank!");
        System.out.println("How much money do you want to deposit into your new Basic Account?");
        newBA.deposit(in.nextDouble());

        System.out.println("Ok, now try to withdraw some money. Don't get greedy...");
        newBA.withdraw(in.nextDouble());

        System.out.printf("\nThere's currently $%.2f in your account.", newBA.getBalance());
    }
}
