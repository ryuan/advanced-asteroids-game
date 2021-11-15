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
            dictionary.add(wordFile.nextLine());
        }

        Recursive test = new Recursive(dictionary);
        int[] input = {5,2,8,2};
        test.matchWords(input,"",input.length-1);
        System.out.println(test.getWordList());
    }
}
