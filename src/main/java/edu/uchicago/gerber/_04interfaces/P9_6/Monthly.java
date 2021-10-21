package edu.uchicago.gerber._04interfaces.P9_6;

import java.time.LocalDate;

public class Monthly extends Appointment {
    public Monthly(String description, LocalDate date) {
        super(description, date);
    }

    public boolean occursOn(int year, int month, int day) {
        if (this.getYear() < year) {
            return false;
        }
        else if (month < this.getMonth() && year == this.getYear()) {
            return false;
        }
        return this.getDay() == day;
    }
}
