package edu.uchicago.gerber._07streams.E19_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/main/java/edu/uchicago/gerber/_07streams/E19_14/warandpeace.txt"));

        ArrayList<String> wordList = new ArrayList<>();
        while (in.hasNext()) {
            String word = in.next().replaceAll("[^A-Za-z]+", "");
            wordList.add(word);
        }

        String result = wordList.stream()
                .parallel()
                .filter(w -> w.length() > 4)
                .filter(Driver::isPalindrome)
                .findAny()
                .orElse("");

        System.out.println(result);

        // Seems the program finds a random palindrome when run repeatedly due to parallel process.
    }

    public static boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (word.charAt(i) != word.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }
}
