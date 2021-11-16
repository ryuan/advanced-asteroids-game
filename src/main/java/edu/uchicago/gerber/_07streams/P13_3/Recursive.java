package edu.uchicago.gerber._07streams.P13_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursive {
    private final ArrayList<String> wordList;
    private final List<List<Character>> keypad;
    private final ArrayList<String> dictionary;

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
            if (this.dictionary.contains(result.toLowerCase())) {
                this.wordList.add(result);
                return;
            }
            return;
        }

        int number = numbers[index];
        int letterOptions = this.keypad.get(number).size();

        for (int i = 0; i < letterOptions; i++) {
            matchWords(numbers, this.keypad.get(number).get(i) + result, index-1);
        }
    }

    public void combinations(int[] numbers) {
        for (int i = 1; i < numbers.length + 1; i++) {
            for (int j = 0; j < numbers.length + 1 - i; j++) {
                int[] newArray = Arrays.copyOfRange(numbers, j, j+i);
                matchWords(newArray, "", newArray.length-1);
            }
        }
    }

    public ArrayList<String> getWordList() {
        return this.wordList;
    }
}
