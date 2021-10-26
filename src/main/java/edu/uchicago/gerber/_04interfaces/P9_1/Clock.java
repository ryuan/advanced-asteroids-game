package edu.uchicago.gerber._04interfaces.P9_1;

public class Clock {
    private final int hours;
    private final int minutes;

    /*
    Constructor for Clock class, initializing instance variables with default values
     */
    public Clock() {
        String timeNow = java.time.LocalTime.now().toString();
        String[] time = timeNow.split(":");
        this.hours = Integer.parseInt(time[0]);
        this.minutes = Integer.parseInt(time[1]);
    }

    /*
    Getters for Clock object variables and data below
     */
    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public String getTime() {
        return "The time is " + this.getHours() + " hours and " + this.getMinutes() + " minutes.";
    }
}
