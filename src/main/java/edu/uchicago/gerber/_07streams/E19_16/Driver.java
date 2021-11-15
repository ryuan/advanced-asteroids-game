package edu.uchicago.gerber._07streams.E19_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("src/main/java/edu/uchicago/gerber/_07streams/E19_16/sample1.txt"));

        List<String> wordList = new ArrayList<>();
        while (input.hasNext()) {
            wordList.add(input.next());
        }

        System.out.println(findAverage(wordList.stream()));
    }

    public static Map<String, Double> findAverage(Stream<String> words) {
        return words
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        w -> w.substring(0,1),
                        Collectors.averagingLong(
                                String::length
                        )
                ));
    }
}
