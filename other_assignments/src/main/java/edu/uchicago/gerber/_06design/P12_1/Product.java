package edu.uchicago.gerber._06design.P12_1;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean equals(Product product) {
        return this.name.equals(product.name);
    }

    public void restock(int quantity) {
        this.quantity += quantity;
    }

    public void dispense() {
        this.quantity -= 1;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
