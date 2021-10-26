package edu.uchicago.gerber._04interfaces.E9_11;

public class Student extends Person {
    private final String major;

    /**
     * Creates Student object by initializing instance variables with passed in params
     * @param name  String name of the student
     * @param yob   int year of birth of student
     * @param major String major of student
     */
    public Student(String name, int yob, String major) {
        super(name, yob);
        this.major = major;
    }

    /**
     * Override default toString method with message with assigned major
     * @return  String message with student's major data included
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", yob=" + super.getYob() + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
