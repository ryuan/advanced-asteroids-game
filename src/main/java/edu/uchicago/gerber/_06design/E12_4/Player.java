package edu.uchicago.gerber._06design.E12_4;

import java.io.PrintStream;

public class Player {
    private int level;
    private int tries;
    private int score;
    private final PrintStream output;

    public Player() {
        this.level = 1;
        this.tries = 0;
        this.score = 0;
        this.output = System.out;
    }

    public boolean progress(boolean result) {
        if (result) {
            if (this.score == 4) {
                this.level ++;
                this.tries = 0;
                this.score = 0;
                this.output.println("You got 5 questions right - you're now level " + this.level + "!");
            }
            else {
                this.score ++;
                this.output.println("That's right! Here's the next question...");
            }
            return true;
        }
        else{
            this.tries ++;
            this.output.println("Nope, that's the wrong answer. Try another answer:");
            return false;
        }
    }

    public boolean alive() {
        return tries < 3;
    }

    public int keepPlaying() {
        if (!this.alive()) {
            return 3;
        }
        else if (this.level > 3) {
            return 2;
        }
        else return 1;
    }

    public int getLevel() {
        return this.level;
    }
}
