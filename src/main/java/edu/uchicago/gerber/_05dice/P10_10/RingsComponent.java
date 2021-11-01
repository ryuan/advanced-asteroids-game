package edu.uchicago.gerber._05dice.P10_10;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class RingsComponent extends JComponent {
    public void paintComponent (Graphics g) {
        drawRing(g, 10, 10, 50, Color.BLUE);
        drawRing(g, 35, 35, 50, Color.ORANGE);
        drawRing(g, 60, 10, 50, Color.BLACK);
        drawRing(g, 85, 35, 50, Color.GREEN.darker());
        drawRing(g, 110, 10, 50, Color.RED);
    }

    void drawRing(Graphics g, int xLeft, int yTop, int diameter, Color color) {
        g.setColor(color);
        g.drawOval(xLeft, yTop, diameter, diameter);
    }
}
