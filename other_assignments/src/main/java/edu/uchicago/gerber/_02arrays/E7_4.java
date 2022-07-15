package edu.uchicago.gerber._02arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * E7_4: Prompts user for input & output text files, prints each line with index prefix, then writes to file.
 */
public class E7_4 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Get user input for the file name and prepare a File objects to read in lines
        */
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFileName);

        /*
        Update a counter for each line that is read and prefix the index/counter number
        */
        int counter = 1;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            out.println("/* " + counter + " */ " + line);
            counter += 1;
        }

        in.close();
        out.close();
    }
}
