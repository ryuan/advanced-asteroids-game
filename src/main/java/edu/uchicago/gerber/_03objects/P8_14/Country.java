package edu.uchicago.gerber._03objects.P8_14;

public class Country {
    /*
    Declare instance variables
     */
    private final String countryName;
    private final long population;
    private final long area;

    /**
     * Constructor for passing in values to initiate instance variables
     * @param countryName   name of country
     * @param population    population of country
     * @param area          land area of country
     */
    public Country(String countryName, long population, long area) {
        this.countryName = countryName;
        this.population = population;
        this.area = area;
    }

    /**
     * Calculate and return population density, unless area is too small (defined as 0 in data)
     * @return population or population density based on land area of said country
     */
    public long getPopDensity() {
        if (area == 0) return population;
        else return population/area;
    }

    /**
     * Getter for country name
     * @return country name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Getter for country's population
     * @return population size
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Getter for country's land area
     * @return area size of country
     */
    public long getArea() {
        return area;
    }
}
