package edu.uchicago.gerber._02arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * P7_5: Reads a CSV file.
 */
public class P7_5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();

        CSVReader reader = new CSVReader(inputFileName);

        System.out.println("The CSV file has " + reader.numberOfRows() + " number of rows.");

        Scanner in = new Scanner(System.in);
        int rowInput = in.nextInt();
        System.out.println("Row " + rowInput + " has " + reader.numberOfFields(rowInput) + " fields.");

        rowInput = in.nextInt();
        int columnInput = in.nextInt();
        System.out.println("Row " + rowInput + ", Col " + columnInput + ": " + reader.field(rowInput, columnInput));
    }
}

class CSVReader {
    ArrayList<String> rows = new ArrayList<>();

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

    public int numberOfRows() {
        return rows.size();
    }

    public int numberOfFields(int row) {
        String[] fields = rows.get(row-1).split(",");
        return fields.length;
    }

    public String field(int row, int column) {
        String[] fields = rows.get(row-1).split(",");
        return fields[column-1];
    }
}