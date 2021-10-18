package edu.uchicago.gerber._03objects.P8_8;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        /*
        Initiate Scanner and VotingMachine objects
         */
        Scanner in = new Scanner(System.in);
        VotingMachine machine = new VotingMachine();

        /*
        Declare or initiate control flow variables
         */
        int actionVote = 1;
        int voteChoice;
        int actionTally;
        int actionReset;
        int actionQuit = 0;

        /*
        Keep looping until user decides to quit the program
         */
        while (actionQuit != 1) {
            /*
            Ask user to add vote for a Democrat or Republic, giving choice to cast more votes
             */
            while (actionVote == 1) {
                System.out.println("\nDo you want to vote for a Democrat or a Republican?");
                System.out.print("Type 1 to vote Democrat, type 2 to vote Republican: ");
                voteChoice = in.nextInt();
                if (voteChoice == 1) {machine.voteDem();}
                else if (voteChoice == 2) {machine.voteRep();}

                /*
                After each vote, ask user if they want to vote again
                 */
                System.out.print("Do you want to vote again? Type 1 for yes, 2 for no: ");
                actionVote = in.nextInt();
            }

            /*
            Give user option to tally votes after voting
             */
            System.out.print("\nWould you like to tally the votes? Type 1 to tally, 2 otherwise: ");
            actionTally = in.nextInt();
            if (actionTally == 1) {
                System.out.println("The Democrats received " + machine.tallyVotes()[0] + " total votes.");
                System.out.println("The Republicans received " + machine.tallyVotes()[1] + " total votes.");
            }

            /*
            Give user to reset vote totals
             */
            System.out.print("\nWould you like to reset the votes? Type 1 to reset, 2 otherwise: ");
            actionReset = in.nextInt();
            if (actionReset == 1) {
                machine.reset();
                System.out.println("The vote totals for both Democrats and Republicans have been reset to 0.");
            }

            /*
            As the user to quit the program, otherwise repeat loop
            Note that the vote action is reset to allow voting loop to occur again
             */
            System.out.print("\nWould you like to quit the program? Type 1 to quit, 2 otherwise: ");
            actionQuit = in.nextInt();
            if (actionQuit != 1) {
                System.out.print("Ok, in that case, do you want to vote again? 1 for yes, 2 for no: ");
                actionVote = in.nextInt();
            }
        }
    }
}
