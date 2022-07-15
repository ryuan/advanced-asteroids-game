package edu.uchicago.gerber._04interfaces.E9_11;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input = 0;
        while (input != 1 && input != 2 && input != 3) {
            System.out.println("Are you a student, instructor, or just a random person at UChicago? ");
            System.out.print("Type 1 for student, 2 for instructor, and 3 for a misc person: ");
            input = in.nextInt();
            in.nextLine();
        }

        System.out.print("\nWhat is your name? ");
        String name = in.nextLine();
        System.out.print("\nWhat is the year of your birth? ");
        int yob = in.nextInt();
        in.nextLine();

        if (input == 1) {
            System.out.print("\nWhat is your major? ");
            String major = in.nextLine();
            Student newStudent = new Student(name, yob, major);
            System.out.println(newStudent);
        }
        else if (input == 2) {
            System.out.print("\nWhat is your salary? ");
            double salary = in.nextDouble();
            Instructor newInstructor = new Instructor(name, yob, salary);
            System.out.println(newInstructor);
        }
        else {
            Person newPerson = new Person(name, yob);
            System.out.println(newPerson);
        }

    }
}
