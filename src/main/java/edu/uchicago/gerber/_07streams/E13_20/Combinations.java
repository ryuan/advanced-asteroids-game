package edu.uchicago.gerber._07streams.E13_20;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> calc(int[] billTypes, int price) {
        List<List<Integer>> result = new ArrayList<>();
        makeCombo(result, new ArrayList<>(),0,0, billTypes, price);
        return result;
    }

    private void makeCombo(List<List<Integer>> result, List<Integer> combo, int sum, int start, int[] billTypes, int price){
        if (price < sum) {
            return;
        }
        if (price == sum) {
            result.add(new ArrayList<>(combo));
            return;
        }
        for (int i = start; i < billTypes.length; i++) {
            combo.add(billTypes[i]);
            makeCombo(result, combo, sum+billTypes[i], i, billTypes, price);
            combo.remove(combo.size()-1);
        }
    }
}
