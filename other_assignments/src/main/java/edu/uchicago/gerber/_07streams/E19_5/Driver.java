package edu.uchicago.gerber._07streams.E19_5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        String[] words = {"May", "the", "force", "be", "with", "you"};
        System.out.println(toString(Stream.of(words), 5));
        System.out.println(toString(Stream.of(words), 3));
        System.out.println(toString(Stream.of(words), 10));

        Integer[] digits = {4, 2, 10, 3, 7, 5, 5, 8};
        System.out.println(toString(Stream.of(digits), 4));
        System.out.println(toString(Stream.of(digits), 0));
        System.out.println(toString(Stream.of(digits), 12));
    }

    public static <T> String toString(Stream<T> stream, int n) {
        return stream
                .map(Object::toString)
                .limit(n)
                .collect(Collectors.joining(","));
    }
}
