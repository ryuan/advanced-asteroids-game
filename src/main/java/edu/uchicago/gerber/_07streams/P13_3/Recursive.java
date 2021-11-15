package edu.uchicago.gerber._07streams.P13_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursive {
    private ArrayList<String> wordList;
    private List<List<Character>> keypad;
    private ArrayList<String> dictionary;

    public Recursive(ArrayList<String> dictionary) {
        this.wordList = new ArrayList<>();
        this.keypad = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList( 'A', 'B', 'C' ),
                Arrays.asList( 'D', 'E', 'F' ),
                Arrays.asList( 'G', 'H', 'I' ),
                Arrays.asList( 'J', 'K', 'L' ),
                Arrays.asList( 'M', 'N', 'O' ),
                Arrays.asList( 'P', 'Q', 'R', 'S'),
                Arrays.asList( 'T', 'U', 'V' ),
                Arrays.asList( 'W', 'X', 'Y', 'Z')
        );
        this.dictionary = dictionary;
    }

    public void matchWords(int[] numbers, String result, int index) {
        if (index == -1) {
            if (this.dictionary.contains(result)) {
                this.wordList.add(result);
                return;
            }
        }

        int number = numbers[index];
        int letterOptions = this.keypad.get(number).size();

        for (int i = 0; i < letterOptions; i++) {
            matchWords(numbers, this.keypad.get(number).get(i) + result, index-1);
        }
    }

    public ArrayList<String> getWordList() {
        return this.wordList;
    }
}
