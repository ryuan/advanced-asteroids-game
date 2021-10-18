package edu.uchicago.gerber._03objects.P8_14;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
P8_14: Read in file with country data. Find and print ranked metrics on countries (population, density, etc.)
 */
public class Driver {
    /*
    Store filepath of country data list (can update once project is forked on your computer)
    Copy and paste path of this program file's CSV sheet
     */
    private static final String FILENAME = "/Users/ruodayuan/IdeaProjects/projava/src/main/java/edu/uchicago/gerber/_03objects/P8_14/P8_14_country_data_2020.csv";

    public static void main(String[] args) throws FileNotFoundException {
        /*
        Initiate new objects to read in file, as well as array list to store country data
         */
        File inputFile = new File(FILENAME);
        Scanner file = new Scanner(inputFile);
        ArrayList<Country> countries = new ArrayList<>();

        /*
        Go through each line in opened CSV file and extract data to array list as Country class type
         */
        String line;
        while (file.hasNextLine()) {
            line = file.nextLine();
            String[] countryData = line.trim().split(",");

            Country newCountry = new Country(countryData[0], Long.parseLong(countryData[1].trim()), Long.parseLong(countryData[2].trim()));
            countries.add(newCountry);
        }

        /*
        Initiate base case values for comparisons
         */
        long maxArea = 0;
        String maxAreaName = null;
        long maxPop = 0;
        String maxPopName = null;
        long maxPopDensity = 0;
        String maxPopDensityName = null;

        /*
        Loop through each Country object and extract ranked key data
         */
        for (Country country : countries) {
            if (country.getArea() > maxArea) {
                maxArea = country.getArea();
                maxAreaName = country.getCountryName();
            }
            if (country.getPopulation() > maxPop) {
                maxPop = country.getPopulation();
                maxPopName = country.getCountryName();
            }
            if (country.getPopDensity() > maxPopDensity) {
                maxPopDensity = country.getPopDensity();
                maxPopDensityName = country.getCountryName();
            }
        }

        System.out.println("The country with the largest area is " + maxAreaName + " with and area of " + maxArea);
        System.out.println("The country with the largest population is " + maxPopName + " with population of " + maxPop);
        System.out.println("The country with the largest population density is " + maxPopDensityName + " with density of " + maxPopDensity);
    }
}
