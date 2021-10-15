package edu.uchicago.gerber._03objects.P8_8;

public class VotingMachine {
    private int votesDem;
    private int votesRep;
    private final int[] votesTotal;

    public VotingMachine() {
        this.votesDem = 0;
        this.votesRep = 0;
        this.votesTotal = new int[2];
    }

    public void reset() {
        this.votesDem = 0;
        this.votesRep = 0;
    }

    public void voteDem() {
        this.votesDem += 1;
    }

    public void voteRep() {
        this.votesRep += 1;
    }

    public int[] tallyVotes() {
        this.votesTotal[0] = votesDem;
        this.votesTotal[1] = votesRep;
        return votesTotal;
    }
}
