package edu.uchicago.gerber._03objects.P8_1;

public class Microwave {
    private int timer;
    private int level;

    public void add30Button() {
        this.timer += 30;
        System.out.println("Timer reads: " + timer + " seconds");
    }

    public void changeLevelButton() {
        if (this.level == 1) {
            this.level = 2;
        } else {
            this.level = 1;
        }
        System.out.println("Level reads: " + level);
    }

    public void resetButton() {
        this.timer = 0;
        System.out.println("Timer reads: " + timer + " seconds");
    }

    public void startButton() {
        System.out.println("Cooking for " + timer + " seconds at level " + level + ".");
    }

    public Microwave() {
        this.timer = 0;
        this.level = 1;
    }

    public int getTimer() {
        return timer;
    }

    public int getLevel() {
        return level;
    }
}
