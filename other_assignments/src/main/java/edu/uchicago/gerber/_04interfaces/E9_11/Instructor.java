package edu.uchicago.gerber._04interfaces.E9_11;

/**
 * Instructor subclass extends Person superclass with salary data
 */
public class Instructor extends Person {
    private final double salary;

    /**
     * Creates Instructor object by initializing instance variables with passed in params
     * @param name  String name of the instructor
     * @param yob   int year of birth of instructor
     * @param salary    double annual salary of instructor
     */
    public Instructor(String name, int yob, double salary) {
        super(name, yob);
        this.salary = salary;
    }

    /**
     * Override default toString method with message with salary data
     * @return  String message with salary data included
     */
    @Override
    public String toString() {
        return String.format("Instructor{name=%s, yob=%d, salary=%.2f}",super.getName(), super.getYob(), salary);
    }
}
