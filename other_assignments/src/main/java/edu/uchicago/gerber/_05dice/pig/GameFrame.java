package edu.uchicago.gerber._05dice.pig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GameFrame extends JFrame implements ActionListener {
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;

    private final JTextArea message = new JTextArea();
    private final JLabel playerScore = new JLabel();
    private final JLabel aiScore = new JLabel();
    private final JButton buttonRoll = new JButton();
    private final JButton buttonHold = new JButton();

    private final Random random = new Random();
    Player player1 = new Player("Player", random, message);
    Player player2 = new Player("AI", random, message);

    public GameFrame() {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createComponents() {
        JPanel scorePanel = new JPanel();
        JLabel playerLabel = new JLabel("Your Score:");
        playerScore.setText("0");
        JLabel aiLabel = new JLabel("AI Score:");
        aiScore.setText("0");

        scorePanel.setLayout(new GridLayout(2, 2));
        scorePanel.add(playerLabel);
        scorePanel.add(playerScore);
        scorePanel.add(aiLabel);
        scorePanel.add(aiScore);

        message.setText("Welcome to the game of PIG!");
        message.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonRoll.setText("Roll");
        buttonHold.setText("Hold");
        buttonPanel.setLayout(new GridLayout(1,2));
        buttonPanel.add(buttonRoll);
        buttonRoll.addActionListener(this);
        buttonPanel.add(buttonHold);
        buttonHold.addActionListener(this);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        mainPanel.add(scorePanel);
        mainPanel.add(message);
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Roll")) {
            if (player1.playerTurn(true) == 0) {
                player2.aiTurn();
                message.setText("You rolled a 1.\nNo points this round.\n" + player2.getName() + " scored " + player2.getStrCurrentTurnScore() + " points on its turn");
            }
        }
        else if (e.getActionCommand().equals("Hold")) {
            player1.playerTurn(false);
            player2.aiTurn();
        }

        playerScore.setText(player1.getStrScore());
        aiScore.setText(player2.getStrScore());

        if (((player1.getCurrentTurnScore() + player1.getScore()) >= 100) || ((player2.getCurrentTurnScore() + player2.getScore()) >= 100) ) {
            playerScore.setText(Integer.toString(player1.getScore() + player1.getCurrentTurnScore()));
            aiScore.setText(Integer.toString(player2.getScore() + player2.getCurrentTurnScore()));
            message.setText("Final score:\n" + player1.getName() + ": " + playerScore.getText() + " - " + player2.getName() + ": " + aiScore.getText());
            buttonRoll.setEnabled(false);
            buttonHold.setEnabled(false);
        }
    }
}
