package edu.uchicago.gerber._08final.mvc.model;

public class ASCIITitle {

    // Loads the ASCII art into char arrays which are turned into Strings and returned in a String array
    public static String[] makeASCIITitle(){

        // Each of the 6 ASCII text lines are hard coded as a char array to avoid escape sequence problems (like '\' and '|')
        // Some rows still had to have the '\' symbol casted as a char to get this to work correctly:

        char[] cRow0 = {' ', '_', '_', '_', '_', '_', '_', ' ', ' ', ' ', '_', '_', '_', '_', '_', '_', ' ', ' ', ' ',
                '_', '_', ' ', ' ', ' ', '_', '_', ' ', '_', '_', '_', '_', '_', '_', ' ', ' ', ' ', ' ', ' ', ' ',
                ' ', '_', '_', ' ', ' ', '_', '_', ' ', ' ', ' ', '_', '_', '_', '_', '_', '_', ' ', ' ', ' ', ' '};

        char[] cRow1 = {'/', (char)92, ' ', ' ', '_', '_', '_', (char)92, ' ', '/', (char)92, ' ', ' ', '_', '_',
                ' ', (char)92, ' ', '/', (char)92, ' ', (char)92, ' ', '/', ' ', '/', '/', (char)92, ' ', ' ',
                '_', '_', '_', (char)92, ' ', ' ', ' ', ' ', ' ', '/', (char)92, ' ', (char)92, '/', (char)92,
                ' ', (char)92, ' ', '/', (char)92, ' ', ' ', '_', '_', '_', (char)92, ' ', ' ', ' '};

        char[] cRow2 = {(char)92, ' ', (char)92, '_', '_', '_', ' ', ' ', (char)92, (char)92, ' ', (char)92, ' ', ' ',
                '_', '_', ' ', (char)92, (char)92, ' ', (char)92, ' ', (char)92, (char)39, '/', ' ', (char)92, ' ',
                (char)92, ' ', ' ', '_', '_', (char)92, ' ', ' ', ' ', ' ', ' ', (char)92, ' ', (char)92, ' ', (char)92,
                '_', (char)92, ' ', (char)92, (char)92, ' ', (char)92, '_', '_', '_', ' ', ' ', (char)92, ' ', ' '};

        char[] cRow3 = {' ', (char)92, '/', (char)92, '_', '_', '_', '_', '_', (char)92, (char)92, ' ', (char)92, '_',
                (char)92, ' ', (char)92, '_', (char)92, (char)92, ' ', (char)92, '_', '_', '|', ' ', ' ', (char)92,
                ' ', (char)92, '_', '_', '_', '_', '_', (char)92, ' ', ' ', ' ', ' ', (char)92, ' ', (char)92,
                '_', '_', '_', '_', '_', (char)92, (char)92, '/', (char)92, '_', '_', '_', '_', '_', (char)92, ' '};

        char[] cRow4 = {' ', ' ', (char)92, '/', '_', '_', '_', '_', '_', '/', ' ', (char)92, '/', '_', '/',
                (char)92, '/', '_', '/', ' ', (char)92, '/', '_', '/', ' ', ' ', ' ', ' ', (char)92, '/', '_',
                '_', '_', '_', '_', '/', ' ', ' ', ' ', ' ', ' ', (char)92, '/', '_', '_', '_', '_', '_', '/', ' ',
                (char)92, '/', '_', '_', '_', '_', '_', '/', ' '};

        String[] lines = new String[5];			// String array that will hold each line of the ASCII art title

        lines[0] = new String(cRow0);			// making each of the 6 char arrays a String and adding to an array
        lines[1] = new String(cRow1);
        lines[2] = new String(cRow2);
        lines[3] = new String(cRow3);
        lines[4] = new String(cRow4);

        return lines;
    }
}
