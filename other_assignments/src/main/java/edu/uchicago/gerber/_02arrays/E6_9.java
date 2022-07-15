package edu.uchicago.gerber._02arrays;

/**
 * E6_9: Checks for equality between two arrays.
 */
public class E6_9 {
    public static boolean equals(int[] a, int[] b) {
        /*
        Compare each element with the same index from each array
         */
        if (a.length != b.length) {return false;}
        else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {return false;}
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        Test the equals() method with below arguments
         */
        int[] x = {4, 5, 6, 7, 10};
        int[] y = {4, 5, 6, 7, 10};

        System.out.println(equals(x,y));
    }
}
