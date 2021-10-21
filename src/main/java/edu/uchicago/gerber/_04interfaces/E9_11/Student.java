package edu.uchicago.gerber._04interfaces.E9_11;

public class Student extends Person {
    private String major;

    public Student(String name, int yob, String major) {
        super(name, yob);
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", yob=" + super.getYob() + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
