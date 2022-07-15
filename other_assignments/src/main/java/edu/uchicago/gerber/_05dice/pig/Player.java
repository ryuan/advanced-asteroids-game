package edu.uchicago.gerber._05dice.pig;

import javax.swing.*;
import java.util.Random;

public class Player {
    private String name;
    private Random random;
    private JTextArea output;
    private int score;
    private int currentTurnScore;

    public Player(String name, Random random, JTextArea output) {
        this.name = name;
        this.random = random;
        this.output = output;
    }

    public int playerTurn(boolean roll) {
        if (roll) {
            int result = this.random.nextInt(6) + 1;
            this.output.setText(this.name + " rolled a " + result);
            currentTurnScore += result;

            if (result == 1) {
                currentTurnScore = 0;
            }

            this.output.setText(this.name + " rolled a " + result + "\n" + this.name + "'s score this turn is " + currentTurnScore);
        }
        else {
            score += currentTurnScore;
            currentTurnScore = 0;
            this.output.setText(this.name + " ends the turn scoring " + this.score);
        }

        return currentTurnScore;
    }

    public void aiTurn() {
        currentTurnScore = 0;
        int result = 0;
        while (currentTurnScore < 20 && result != 1) {
            result = this.random.nextInt(6) + 1;
            currentTurnScore += result;
            if (result == 1) {
                currentTurnScore = 0;
            }
        }

        score += currentTurnScore;
        this.output.setText(this.name + " ends the turn scoring " + this.currentTurnScore);
    }

    public String getStrCurrentTurnScore() {
        return Integer.toString(currentTurnScore);
    }

    public int getCurrentTurnScore() {
        return currentTurnScore;
    }

    public String getStrScore() {
        return Integer.toString(score);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
