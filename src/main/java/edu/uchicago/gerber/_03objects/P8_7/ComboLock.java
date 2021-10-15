package edu.uchicago.gerber._03objects.P8_7;

public class ComboLock {
    private int secret1;
    private int secret2;
    private int secret3;
    private int state;
    private int currentNum;

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        this.state = 0;
        this.currentNum = 0;
    }

    public void reset() {
        state = 0;
        currentNum = 0;
    }

    public void turnLeft(int ticks) {
        if (state == 0) {
            currentNum -= ticks;
            state = 4;
        }
        else if (state == 1) {
            currentNum -= ticks;
            if (secret2 == 40 + currentNum) {
                state = 2;
            }
            else if (secret2 < 40 + currentNum) {
                state = 4;
            }
        }
        else if (state == 2) {
            currentNum -= ticks;
            state = 4;
        }
        else if (state == 3) {
            currentNum -= ticks;
            state = 4;
        }
        else {
            state = 4;
        }
    }

    public void turnRight(int ticks) {
        if (state == 0) {
            currentNum += ticks;
            if (secret1 == currentNum) {
                state = 1;
            }
            else if (secret1 < currentNum) {
                state = 4;
            }
        }
        else if (state == 1) {
            currentNum += ticks;
            state = 4;
        }
        else if (state == 2) {
            currentNum += ticks;
            if (secret3 == currentNum) {
                state = 3;
            }
            else if (secret3 < currentNum) {
                state = 4;
            }
        }
        else {
            state = 4;
        }
    }

    public boolean open() {
        return state == 3;
    }

    public int getState() {
        return state;
    }

    public int getCurrentNum() {
        return currentNum;
    }
}
