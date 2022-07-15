package edu.uchicago.gerber._03objects.P8_8;

public class VotingMachine {
    /*
    Declare the instance variables
     */
    private int votesDem;
    private int votesRep;
    private final int[] votesTotal;

    /*
    Constructor for initiating instance variables with default values
     */
    public VotingMachine() {
        this.votesDem = 0;
        this.votesRep = 0;
        this.votesTotal = new int[2];
    }

    /*
    Resets the vote tally for both parties
     */
    public void reset() {
        this.votesDem = 0;
        this.votesRep = 0;
    }

    /*
    Increments the vote tally for Democrats and Republicans
     */

    public void voteDem() {
        this.votesDem += 1;
    }

    public void voteRep() {
        this.votesRep += 1;
    }

    /**
     * Tallies the votes for both parties and returns them
     * @return  votesTotal is returned as array of vote totals for Dems and Reps
     */
    public int[] tallyVotes() {
        this.votesTotal[0] = votesDem;
        this.votesTotal[1] = votesRep;
        return votesTotal;
    }
}
