package edu.uchicago.gerber._03objects.P8_8;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        VotingMachine machine = new VotingMachine();

        int actionVote = 1;
        int voteChoice;
        int actionTally;
        int actionReset;
        int actionQuit = 0;

        while (actionQuit != 1) {
                while (actionVote == 1) {
                    System.out.println("\nDo you want to vote for a Democrat or a Republican?");
                    System.out.print("Type 1 to vote Democrat, type 2 to vote Republican: ");
                    voteChoice = in.nextInt();
                    if (voteChoice == 1) {machine.voteDem();}
                    else if (voteChoice == 2) {machine.voteRep();}

                    System.out.print("Do you want to vote again? Type 1 for yes, 2 for no: ");
                    actionVote = in.nextInt();
                }

            System.out.print("\nWould you like to tally the votes? Type 1 to tally, 2 otherwise: ");
            actionTally = in.nextInt();
            if (actionTally == 1) {
                System.out.println("The Democrats received " + machine.tallyVotes()[0] + " total votes.");
                System.out.println("The Republicans received " + machine.tallyVotes()[1] + " total votes.");
            }

            System.out.print("\nWould you like to reset the votes? Type 1 to reset, 2 otherwise: ");
            actionReset = in.nextInt();
            if (actionReset == 1) {
                machine.reset();
                System.out.println("The vote totals for both Democrats and Republicans have been reset to 0.");
            }

            System.out.print("\nWould you like to quit the program? Type 1 to quit, 2 otherwise: ");
            actionQuit = in.nextInt();
            if (actionQuit != 1) {
                System.out.print("Ok, in that case, do you want to vote again? 1 for yes, 2 for no: ");
                actionVote = in.nextInt();
            }
        }
    }
}
