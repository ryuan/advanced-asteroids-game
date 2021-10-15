package edu.uchicago.gerber._03objects.P8_14;

public class Country {
    private String countryName;
    private long population;
    private long area;

    public Country(String countryName, long population, long area) {
        this.countryName = countryName;
        this.population = population;
        this.area = area;
    }

    public long getPopDensity() {
        if (area == 0) return population;
        else return population/area;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }
}
