package edu.uchicago.gerber._06design.E12_4;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Welcome to the basic arithmetic game!");

        Player player = new Player();
        Question question = new Question();

        while (player.keepPlaying() == 1) {
            question.genQ(player.getLevel());
            while (player.alive()) {
                if(player.progress(question.check())) {
                    break;
                }
            }
        }

        if (player.keepPlaying() == 2) {
            System.out.println("Congrats - you passed all 3 levels. You win!");
        }
        else if (player.keepPlaying() == 3) {
            System.out.println("Sorry - you got the question wrong 3 times. GAME OVER!");
        }
    }
}
