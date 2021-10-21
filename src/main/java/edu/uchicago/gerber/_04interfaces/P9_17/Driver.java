package edu.uchicago.gerber._04interfaces.P9_17;

public class Driver {
    public static double aveSA(Measurable[] objects) {
        double sum = 0;
        int size = objects.length;
        for (Measurable object : objects) {
            sum += object.getMeasure();
        }
        return sum/size;
    }

    public static void main(String[] args) {
        SodaCan[] sodaCans = new SodaCan[5];
        sodaCans[0] = new SodaCan(5,8);
        sodaCans[1] = new SodaCan(3,3);
        sodaCans[2] = new SodaCan(10,3);
        sodaCans[3] = new SodaCan(4,6);
        sodaCans[4] = new SodaCan(8,3);

        double average = aveSA(sodaCans);
        System.out.println("The average surface area is " + average);
    }
}
