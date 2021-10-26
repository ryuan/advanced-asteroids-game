package edu.uchicago.gerber._04interfaces.E9_11;

public class Person {
    private final String name;
    private final int yob;

    /**
     * Default Person superclass object initialized with name and year of birth
     * @param name  Name of person
     * @param yob   Year of birth of person
     */
    public Person(String name, int yob) {
        this.name = name;
        this.yob = yob;
    }

    /**
     * Override default toString method with object data
     * @return  Name and yob of person
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", yob=" + yob +
                '}';
    }

    /**
     * Getter for name
     * @return  name instance variable
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for year of birth
     * @return  yob instance variable
     */
    public int getYob() {
        return yob;
    }
}
