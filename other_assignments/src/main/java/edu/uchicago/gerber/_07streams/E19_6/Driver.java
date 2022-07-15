package edu.uchicago.gerber._07streams.E19_6;

import java.util.Currency;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        Set<Currency> currencySet = Currency.getAvailableCurrencies();
        System.out.println(toString(currencySet));
    }

    public static String toString(Set<Currency> currencySet) {
        Stream<Currency> stream = currencySet.stream();

        return stream
                .map(Currency::getDisplayName)
                .sorted()
                .collect(Collectors.joining("\n"));
    }
}
