package edu.uchicago.gerber._06design.P12_1;

import java.util.ArrayList;

public class VendingMachine {
    private final ArrayList<Product> products;
    private double box;
    private final CoinSet hold;

    public VendingMachine() {
        this.products = new ArrayList<>();
        this.box = 0;
        this.hold = new CoinSet();
    }

    public String buy(Product product) {
        String str = "";
        for (Product p : products) {
            if (p.equals(product)) {
                if (product.getQuantity() > 0) {
                    double payment = hold.getTotal();
                    if (payment >= product.getPrice()) {
                        str = "Dispensing " + product.getName() + "... Enjoy your purchase!";
                        product.dispense();
                        this.box += product.getPrice();
                    }
                    else {
                        str = "Purchase failed. Insufficient funds. Returning your money.";
                    }
                }
                else {
                    str = "Purchase failed. " + product.getName() + " is out of stock. Returning your money.";
                }
                hold.clear();
            }
        }
        return str;
    }

    public ArrayList<String> getCatalog() {
        ArrayList<String> catalog = new ArrayList<>();
        for(Product product : products) {
            String desc = product.getName() + ": $" + product.getPrice();
            catalog.add(desc);
        }
        return catalog;
    }

    public Product getProduct(int i) {
        return products.get(i);
    }

    public void addCoin(Coin coin) {
        this.hold.add(coin);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void restock(Product product, int quantity) {
        product.restock(quantity);
    }

    public double removeMoney() {
        double amount = box;
        this.box = 0;
        return amount;
    }
}
