package edu.uchicago.gerber._04interfaces.P9_1;

public class WorldClock extends Clock {
    private int offset;

    public WorldClock(int offset) {
        this.offset = offset;
    }

    @Override
    public int getHours() {
        int newHour = super.getHours() + this.offset;
        if (newHour < 0) {
            newHour += 24;
        }
        return newHour;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
