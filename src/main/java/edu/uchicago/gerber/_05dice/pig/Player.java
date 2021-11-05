package edu.uchicago.gerber._05dice.pig;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private final String name;
    private final Random random;
    private final Scanner scanner;
    private final PrintStream output;
    private int score;

    public Player(String name, Random random, Scanner scanner, PrintStream output) {
        this.name = name;
        this.random = random;
        this.scanner = scanner;
        this.output = output;
    }

    public boolean playTurn() {
        output.println(this.name + "'s turn.");

        int currentTurnScore = 0;
        if (this.name.equals("Player")) {
            do {
                int result = this.random.nextInt(6) + 1;
                this.output.println(this.name + " rolled a " + result);
                currentTurnScore += result;

                if (result == 1) {
                    currentTurnScore = 0;
                    break;
                }
                this.output.println(this.name + "'s score so far this turn is " + currentTurnScore + ".");
            } while (this.score + currentTurnScore < 100 && this.rollAgain());
        }
        else {
            do {
                int result = this.random.nextInt(6) + 1;
                this.output.println(this.name + " rolled a " + result + ".");
                currentTurnScore += result;

                if (result == 1) {
                    currentTurnScore = 0;
                    break;
                }
                this.output.println(this.name + "'s score so far this turn is " + currentTurnScore);
            } while (this.score + currentTurnScore < 100 && this.randomAI(currentTurnScore));
        }

        this.score += currentTurnScore;
        this.output.println(this.name + " ends the turn scoring " + this.score);

        return (this.score >= 100);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    private String answer() {
        return scanner.nextLine().replaceAll(" ","").toUpperCase();
    }

    private boolean rollAgain() {
        this.output.println("Do you want to roll again? (Y/N)");
        String choice = this.answer();

        while (!(choice.equals("Y") || choice.equals("N"))) {
            this.output.println("You have to enter Y or N:");
            choice = this.answer();
        }

        return choice.equals("Y");
    }

    private boolean randomAI(int currentScore) {
        if (currentScore < 20) {
            this.output.println(this.name + " chooses to roll again.");
        }
        return (currentScore < 20);
    }
}
