package edu.uchicago.gerber._07streams.YodaSpeakRecursive;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a sentence for Yoda to translate: ");
        String sentence = input.nextLine();
        sentence = sentence.replaceAll("\\s+", " ");

        String[] wList = sentence.split(" ");

        reverse(wList, wList.length - 1);
    }

    public static void reverse(String[] wList, int index) {
        if (index == 0) {
            System.out.print(wList[index]);
        }
        else {
            System.out.print(wList[index] + " ");
            reverse(wList, index - 1);
        }
    }
}
