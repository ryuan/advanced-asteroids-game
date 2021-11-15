package edu.uchicago.gerber._07streams.E19_7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("You", "must", "construct", "additional", "pylons");
        Stream<String> words2 = Stream.of("Taylor", "Swift", "is", "a", "legend");

        System.out.println(convert(words));
        System.out.println(convert(words2));
    }

    public static String transform(String word) {
        char f = word.charAt(0);
        char l = word.charAt(word.length()-1);
        return f + "..." + l;
    }

    public static List<String> convert(Stream<String> words) {
        return words
                .filter(w -> w.length() > 1)
                .map(Driver::transform)
                .collect(Collectors.toList());
    }
}
