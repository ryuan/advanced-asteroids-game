package edu.uchicago.gerber._07streams.YodaSpeak;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sentence for Yoda to translate: ");
        String sentence = input.nextLine();
        sentence = sentence.replaceAll("\\s+", " ");

        String[] wList = sentence.split(" ");

        for (int i = wList.length-1; i >= 0; i--) {
            System.out.print(wList[i]);
            if (i > 0) {
                System.out.print(" ");
            }
        }
    }
}
