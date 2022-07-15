package edu.uchicago.gerber._04interfaces.P9_6;

import java.time.LocalDate;

public class Daily extends Appointment {
    public Daily(String description, LocalDate date) {
        super(description, date);
    }

    public boolean occursOn(int year, int month, int day) {
        if (year > this.getYear()) {
            return true;
        }
        if (year == this.getYear()) {
            if (month > getMonth()) {
                return true;
            }
            if (month == this.getMonth()) {
                return day >= this.getDay();
            }
        }
        return false;
    }
}
