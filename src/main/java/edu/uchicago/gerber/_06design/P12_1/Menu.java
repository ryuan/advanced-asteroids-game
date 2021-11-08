package edu.uchicago.gerber._06design.P12_1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private VendingMachine vm;
    private Scanner input;
    private PrintStream output;

    public Menu() {
        vm = new VendingMachine();
        input = new Scanner(System.in);
        output = System.out;
    }

    public void run() {
        output.println("Welcome to the Java Vending Machine!");
        while (true) {
            ArrayList<Integer> options = new ArrayList<>();
            ArrayList<String> catalog = vm.getCatalog();

            for (int i = 0; i < catalog.size(); i++) {
                this.output.println("Press " + i + " to select " + catalog.get(i));
                options.add(i);
            }
            this.output.println("Press 888 if you are an operator.");
            options.add(888);
            this.output.println("Press 999 if you want to exit.");
            options.add(999);

            while (!this.input.hasNextInt()) {
                this.output.println("You must enter a valid option! Try typing again:");
                this.input.next();
            }
            int selection = this.input.nextInt();

            if (selection == 999) {
                this.output.println("Ok, exit's to your right.");
                break;
            }
            else if (selection == 888) {
                this.output.println("Press 1 to add a product, 2 to restock a product, 3 to withdraw money:");
                while (!this.input.hasNextInt()) {
                    this.output.println("You must enter a valid option! Try typing again:");
                    this.input.next();
                }
                int opSelection = this.input.nextInt();

                if (opSelection == 1) {
                    this.output.println("Type the new product's information to add it.");
                    this.output.print("Name: ");
                    String name = input.nextLine();
                    this.output.print("Price: ");
                    double price = input.nextDouble();
                    this.output.print("Quantity: ");
                    int quantity = input.nextInt();
                    input.nextLine();
                    Product p = new Product(name, price, quantity);
                    vm.addProduct(p);
                }
                else if (opSelection == 2) {
                    this.output.println("Press the number for the product you want to restock:");
                    for (int i = 0; i < catalog.size(); i++) {
                        this.output.println("Press " + i + " to select " + catalog.get(i));
                        options.add(i);
                    }
                    while (!this.input.hasNextInt()) {
                        this.output.println("You must enter a valid option! Try typing again:");
                        this.input.next();
                    }
                    int pSelection = this.input.nextInt();
                    Product p = vm.getProduct(pSelection);
                    this.output.print("Quantity: ");
                    int quantity = input.nextInt();
                    input.nextLine();
                    vm.restock(p, quantity);
                }
                else if (opSelection == 3) {
                    double amount = vm.removeMoney();
                    this.output.println("$" + amount + " has been withdrawn.");
                    this.output.println("The cash box is now empty.");
                }
            }
            else if(selection > catalog.size() || selection < 1) {
                System.err.println("ERROR: invalid option.");
            }
            else {
                this.output.println("Please insert coins worth $" + vm.getProduct(selection).getPrice());
                this.output.println("Press (A) to insert nickel $0.05");
                this.output.println("Press (B) to insert dime $0.1");
                this.output.println("Press (C) to insert quarter $0.25");
                this.output.println("Press (D) to insert dollar $1.00");
                char ch = input.nextLine().charAt(0);
                if(ch == 'A' || ch == 'a') {
                    Coin coin = new Coin("nickel", 0.05);
                    vm.addCoin(coin);
                }
                else if(ch == 'B' || ch == 'b') { // user added $0.1
                    Coin coin = new Coin("dime", 0.1);
                    vm.addCoin(coin);
                }
                else if(ch == 'C' || ch == 'c') { // user added $0.25
                    Coin coin = new Coin("quarter", 0.25);
                    vm.addCoin(coin);
                }
                else if(ch == 'D' || ch == 'd') { // user added $1.0
                    Coin coin = new Coin("dollar", 1.0);
                    vm.addCoin(coin);
                }
                else {
                    System.err.println("invalid option!");
                }
                output.println(vm.buy(vm.getProduct(selection)));
            }
        }
        input.close();
    }
}
