package edu.uchicago.gerber._03objects.P8_7;

public class ComboLock {
    /*
    Declare class instance variables
     */
    private final int secret1;
    private final int secret2;
    private final int secret3;
    private int state;
    private int currentNum;

    /**
     * Constructor for instance variables, passing in user inputs for 3 of the variables
     * @param secret1   combination lock 1 passcode number
     * @param secret2   combination lock 2 passcode number
     * @param secret3   combination lock 3 passcode number
     */
    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        this.state = 0;
        this.currentNum = 0;
    }

    /*
    Resets the lock state to allow new unlocking attempt
     */
    public void reset() {
        state = 0;
        currentNum = 0;
    }

    /**
     * Take user input for turning the left a certain number of ticks.
     * If ticks can match the secret2 number, then elevate unlock state.
     * Allow further turns to the left if left turn ticks are insufficient.
     * If ticks surpass the secret2 number, then set the lock state to 4, forcing reset.
     * If left turn is initiated before the first right turn, also lock state to 4.
     * @param ticks number of ticks to turn lock knob to the left
     */
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

    /**
     * Take user input for turning the right a certain number of ticks.
     * If ticks can match the secret1 number on initial direction of turn, then elevate unlock state.
     * If ticks can match the secret2 number on third direction of turn, then unlock the lock.
     * Allow further turns to the right if right turn ticks are insufficient.
     * If ticks surpass the secret1 or secret3 number, then set the lock state to 4, forcing reset.
     * @param ticks number of ticks to turn lock knob to the right
     */
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

    /**
     * Attempt to open the lock
     * @return true or false based on if state instance variable is currently set to 3
     */
    public boolean open() {
        return state == 3;
    }
}
