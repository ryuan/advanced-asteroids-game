package edu.uchicago.gerber._04interfaces.P9_1;

public class WorldClock extends Clock {
    private int offset;

    /**
     * Constructor for WorldClock class extending Clock class
     * @param offset    Initializes offset variable with passed on value
     */
    public WorldClock(int offset) {
        this.offset = offset;
    }

    /**
     * Converts hours based on offset
     * @return  adjusted hour after accounting for offset
     */
    @Override
    public int getHours() {
        int newHour = super.getHours() + this.offset;
        if (newHour < 0) {
            newHour += 24;
        }
        return newHour;
    }


    /**
     * Setter for offset
     * @param offset    offset hour amount
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}
