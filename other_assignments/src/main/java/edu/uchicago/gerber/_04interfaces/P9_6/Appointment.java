package edu.uchicago.gerber._04interfaces.P9_6;
import java.time.*;

public class Appointment {
    private final String description;
    private final LocalDate date;

    public Appointment(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    public int getYear() {
        return date.getYear();
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

    public String toString() {
        return description;
    }

    public boolean occursOn(int year, int month, int day)
    {
        return (year == this.getYear()) && (month == this.getMonth()) && (day == this.getDay());
    }
}
