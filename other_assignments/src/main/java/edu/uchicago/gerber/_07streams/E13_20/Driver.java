package edu.uchicago.gerber._07streams.E13_20;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        int[] billTypes = new int[]{1, 5, 20, 100};
        int price = 20;

        List<List<Integer>> list = new Combinations().calc(billTypes, price);
        System.out.println(list);
    }
}
