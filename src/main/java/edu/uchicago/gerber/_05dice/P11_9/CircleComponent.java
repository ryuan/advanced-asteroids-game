package edu.uchicago.gerber._05dice.P11_9;

import javax.swing.*;
import java.awt.*;

public class CircleComponent extends JComponent {
    private int xLeft;
    private int yTop;
    private int diameter;

    public CircleComponent() {
        xLeft = 0;
        yTop = 0;
        diameter = 0;
    }

    public void paintComponent (Graphics g) {
        g.drawOval(xLeft, yTop, diameter, diameter);
    }

    public void drawCircle(Point p1, Point p2) {
        int r = (int) Math.round(p1.distance(p2));
        xLeft = (int) p1.getX() - r;
        yTop = (int) p1.getY() - r;
        diameter = r * 2;
        repaint();
    }
}