package edu.uchicago.gerber._06design.P12_1;

import java.util.ArrayList;

public class CoinSet {
    private ArrayList<Coin> holder;

    public CoinSet() {
        this.holder = new ArrayList<>();
    }

    public void add(Coin coin) {
        holder.add(coin);
    }

    public double getTotal() {
        double total = 0;
        for (Coin coin : holder) {
            total += coin.getValue();
        }
        return total;
    }

    public void clear() {
        holder.clear();
    }
}
