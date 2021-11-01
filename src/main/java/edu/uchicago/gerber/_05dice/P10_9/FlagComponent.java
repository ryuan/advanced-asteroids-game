package edu.uchicago.gerber._05dice.P10_9;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class FlagComponent extends JComponent {
    public void paintComponent (Graphics g) {
        drawFlag(g, 10, 10, 100);
//        drawFlag(g, 10, 125, 150);
    }

    void drawFlag(Graphics g, int xLeft, int yTop, int width) {
        g.setColor(Color.BLACK);
        g.fillRect(xLeft, yTop, width/3, width*2/3);
        g.setColor(Color.RED);
        g.fillRect(xLeft + width/3, yTop, width/3, width*2/3);
        g.setColor(Color.YELLOW);
        g.fillRect(xLeft + 2 * width/3, yTop, width/3, width*2/3);
    }
}
