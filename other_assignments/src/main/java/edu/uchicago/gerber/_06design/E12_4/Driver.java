package edu.uchicago.gerber._06design.E12_4;

public class Driver {
    public static void main(String[] args) {
        System.out.println("Welcome to the basic arithmetic game!");
        System.out.println("There are 3 levels. Get 5 questions in each level to progress.");
        System.out.println("Be careful - if you get a question wrong 3 times, it's GAME OVER.\n");

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
