package edu.uchicago.gerber._02arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * P7_5: Reads a CSV file.
 */
public class P7_5 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Get file name from user and create a CSVReader object
         */
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();

        CSVReader reader = new CSVReader(inputFileName);

        /*
        Take user input when necessary to return specific details about the CSV
         */
        System.out.println("The CSV file has " + reader.numberOfRows() + " number of rows.");

        System.out.print("Enter a row number (max of " + reader.numberOfRows() + ") to check for number of fields: ");
        Scanner in = new Scanner(System.in);
        int rowInput = in.nextInt();
        System.out.println("Row " + rowInput + " has " + reader.numberOfFields(rowInput) + " fields.");

        System.out.print("First, enter the row number (max of " + reader.numberOfRows() + ") of your requested field data: ");
        rowInput = in.nextInt();
        System.out.print("Now, enter the column number (max of " + reader.numberOfFields(rowInput) + ") to get the field data: ");
        int columnInput = in.nextInt();
        System.out.println("Row " + rowInput + ", Col " + columnInput + ": " + reader.field(rowInput, columnInput));
    }
}

class CSVReader {
    ArrayList<String> rows = new ArrayList<>();

    /*
    Receives the file name as an argument, prepare a File objects,
    then update array list by reading lines
     */
    public CSVReader(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);
        Scanner in = new Scanner(inputFile);

        String line;
        int counter = 0;
        while (in.hasNextLine()) {
            line = in.nextLine();
            rows.add(counter, line);
            counter += 1;
        }
    }

    /*
    Return the number of rows for the CSVReader object
     */
    public int numberOfRows() {
        return rows.size();
    }

    /*
    Return the number of fields in a given row
     */
    public int numberOfFields(int row) {
        String[] fields = rows.get(row-1).split(",");
        return fields.length;
    }

    /*
    Return the specific field based on row and column argument
     */
    public String field(int row, int column) {
        String[] fields = rows.get(row-1).split(",");
        return fields[column-1];
    }
}