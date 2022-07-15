package edu.uchicago.gerber._03objects.P8_1;

public class Microwave {
    private int timer;
    private int level;

    /*
    Add 30 seconds to the microwave timer. Print the current timer displayed on microwave.
     */
    public void add30Button() {
        this.timer += 30;
        System.out.println("Timer reads: " + timer + " seconds");
    }

    /*
    Switch the power level (options 1 and 2). Print the power level reading on microwave.
     */
    public void changeLevelButton() {
        if (this.level == 1) {
            this.level = 2;
        } else {
            this.level = 1;
        }
        System.out.println("Level reads: " + level);
    }

    /*
    Resets the timer on the microwave.
     */
    public void resetButton() {
        this.timer = 0;
        System.out.println("Timer reads: " + timer + " seconds");
    }

    /*
    Starts the microwave and print timer and level.
     */
    public void startButton() {
        System.out.println("Cooking for " + timer + " seconds at level " + level + ".");
    }

    /*
    Constructor for instance variables
     */
    public Microwave() {
        this.timer = 0;
        this.level = 1;
    }

    /**
     * Getter for timer instance variable
     * @return current timer
     */
    public int getTimer() {
        return timer;
    }
}
