package edu.uchicago.gerber._02arrays;

public class Test {
//    public static void falseSwap(int a, int b)
//    {
//        int temp = a;
//        a = b;
//        b = temp;
//    }
//    public static void main(String[] args)
//    {
//        int x = 3;
//        int y = 4;
//        falseSwap(x, y);
//        System.out.println(x + " " + y);
//    }
public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
    int total = 0;
    for (int i = 0; i < 10; i++) { total = a[i] - total; }
    System.out.println(total);
}
}
