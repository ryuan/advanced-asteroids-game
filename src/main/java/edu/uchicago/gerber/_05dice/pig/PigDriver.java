package edu.uchicago.gerber._05dice.pig;

import java.util.Scanner;
import java.util.Random;

public class PigDriver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        Player player1 = new Player("Player", random, in, System.out);
        Player player2 = new Player("AI", random, in, System.out);

        while (true) {
            if (player1.playTurn()) {
                System.out.println(player1.getName() + " wins with a score of " + player1.getScore() + "!");
                break;
            }
            if (player2.playTurn()) {
                System.out.println(player2.getName() + " wins with a score of " + player2.getScore() + "!");
                break;
            }
        }

        System.out.println("Final score:");
        System.out.println(player1.getName() + ": " + player1.getScore() + " - " + player2.getName() + ": " + player2.getScore());
    }
}
