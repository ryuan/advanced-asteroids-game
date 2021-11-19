package edu.uchicago.gerber._07streams.P13_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner wordFile = new Scanner(new File("src/main/java/edu/uchicago/gerber/_07streams/P13_3/words_alpha.txt"));
        ArrayList<String> dictionary = new ArrayList<>();
        while (wordFile.hasNextLine()) {
            String word = wordFile.nextLine();
            if (word.length() <= 10) {
                dictionary.add(word);
            }
        }

        Recursive combo = new Recursive(dictionary);
        int[] input = {5, 2, 8, 2};
        System.out.println(combo.combinations(input));
    }
}
