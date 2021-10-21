package edu.uchicago.gerber._04interfaces.E9_11;

public class Instructor extends Person {
    private double salary;

    public Instructor(String name, int yob, double salary) {
        super(name, yob);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("Instructor{name=%s, yob=%d, salary=%.2f}",super.getName(), super.getYob(), salary);
    }
}
