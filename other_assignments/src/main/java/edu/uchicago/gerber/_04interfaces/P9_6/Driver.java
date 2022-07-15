package edu.uchicago.gerber._04interfaces.P9_6;
import java.time.LocalDate;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Appointment[] appointments = new Appointment[7];
        LocalDate[] localDates = {
                LocalDate.of(2022, 2, 1),
                LocalDate.of(2024, 4, 4),
                LocalDate.of(2021, 11, 12),
                LocalDate.of(2021, 12, 18),
                LocalDate.of(2019, 10, 20),
                LocalDate.of(2018, 4, 28),
                LocalDate.of(2000, 1, 8),
        };

        appointments[0] = new Daily("Study algo midterm", localDates[0]);
        appointments[1] = new Monthly("Finish algo homework", localDates[1]);
        appointments[2] = new Monthly("Finish Java homework", localDates[2]);
        appointments[3] = new Onetime("Meet with LIB team", localDates[3]);
        appointments[4] = new Onetime("Record LIB presentation", localDates[4]);
        appointments[5] = new Daily("Don't ever stop studying algo", localDates[5]);
        appointments[6] = new Daily("Kill yourself from studying algo", localDates[6]);

        System.out.println("Enter a date (in order - year, month, day) to list matching appointments: ");
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        for (Appointment appointment : appointments) {
            if (appointment.occursOn(year, month, day)) {
                System.out.println(appointment);
            }
        }
    }
}
