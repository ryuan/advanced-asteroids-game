package edu.uchicago.gerber._05dice.P10_9;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class FlagComponent extends JComponent {
    public void paintComponent (Graphics g) {
        drawGERFlag(g, 10, 10, 150);
        drawHUNFlag(g, 10, 125, 150);
    }

    void drawGERFlag(Graphics g, int xLeft, int yTop, int width) {
        g.setColor(Color.BLACK);
        g.fillRect(xLeft, yTop, width, width * 2/9);
        g.setColor(Color.RED.darker());
        g.fillRect(xLeft, yTop + width * 2/9, width, width * 2/9);
        g.setColor(Color.ORANGE);
        g.fillRect(xLeft, yTop + 2 * width * 2/9, width, width * 2/9);
    }

    void drawHUNFlag(Graphics g, int xLeft, int yTop, int width) {
        g.setColor(Color.RED.darker());
        g.fillRect(xLeft, yTop, width, width * 2/9);
        g.setColor(Color.WHITE);
        g.fillRect(xLeft, yTop + width * 2/9, width, width * 2/9);
        g.setColor(Color.GREEN.darker().darker());
        g.fillRect(xLeft, yTop + 2 * width * 2/9, width, width * 2/9);
    }
}
