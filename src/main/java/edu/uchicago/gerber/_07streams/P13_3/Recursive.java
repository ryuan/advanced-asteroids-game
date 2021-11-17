package edu.uchicago.gerber._07streams.P13_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursive {
    private final ArrayList<ArrayList<ArrayList<String>>> wordList;
    private final List<List<Character>> keypad;
    private final ArrayList<String> dictionary;

    public Recursive(ArrayList<String> dictionary) {
        this.wordList = new ArrayList<>();
        this.keypad = Arrays.asList(
                List.of(),
                List.of(),
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

    public void combinations(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            wordList.add(new ArrayList<>());
        }

        for (int i = 1; i < numbers.length + 1; i++) {
            for (int j = 0; j < numbers.length + 1 - i; j++) {
                int[] newArray = Arrays.copyOfRange(numbers, j, j+i);
                ArrayList<String> output = new ArrayList<>();
                matchWords(newArray, output, "", newArray.length-1);
                wordList.get(i-1).add(output);
            }
        }
    }

    public void matchWords(int[] numbers, ArrayList<String> output, String result, int index) {
        if (index == -1) {
            if (this.dictionary.contains(result.toLowerCase())) {
                output.add(result);
                return;
            }
            return;
        }

        int number = numbers[index];
        int letterOptions = this.keypad.get(number).size();

        for (int i = 0; i < letterOptions; i++) {
            matchWords(numbers, output, this.keypad.get(number).get(i) + result, index-1);
        }
    }

    public ArrayList<ArrayList<ArrayList<String>>> getWordList() {
        return this.wordList;
    }
}
