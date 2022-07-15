package edu.uchicago.gerber._06design.E12_4;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Question {
    private final Random random;
    private final PrintStream output;
    private final Scanner scanner;
    private int solution;
    private int num1;
    private int num2;

    public Question() {
        this.random = new Random();
        this.output = System.out;
        this.scanner = new Scanner(System.in);
    }

    public void genQ(int level) {
        switch (level) {
            case 1 -> this.genLvl1();
            case 2 -> this.genLvl2();
            case 3 -> this.genLvl3();
        }
    }

    public boolean check() {
        return this.getAnswer() == solution;
    }

    public int getAnswer() {
        while (!this.scanner.hasNextInt()) {
            this.output.println("You must enter an integer solution! Try typing again:");
            this.scanner.next();
        }

        return this.scanner.nextInt();
    }

    private void genLvl1() {
        this.solution = this.genInt(0, 10);
        int mid = this.solution / 2;
        this.num1 = this.genInt(0, mid+1);
        this.num2 = this.solution - this.num1;

        this.output.println("What is " + this.num1 + "+" + this.num2 + "=?");
    }

    private void genLvl2() {
        this.num1 = this.genInt(0, 10);
        this.num2 = this.genInt(0, 10);
        this.solution = this.num1 + this.num2;

        this.output.println("What is " + this.num1 + "+" + this.num2 + "=?");
    }

    private void genLvl3() {
        this.num1 = this.genInt(0, 10);
        int mid = this.num1 / 2;
        this.num2 = this.genInt(0, mid+1);
        this.solution = this.num1 - this.num2;

        this.output.println("What is " + this.num1 + "-" + this.num2 + "=?");
    }

    private int genInt(int min, int max) {
        return this.random.nextInt(min,max);
    }
}
