package edu.uchicago.gerber._05dice.P11_9;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class DrawCircleFrame extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private Point p1;
    private Point p2;

    private CircleComponent scene;

    class MousePressListener implements MouseListener {
        public void mousePressed(MouseEvent event) {
            if (p1 == null || p2 != null) {
                p1 = event.getPoint();
                p2 = null;
            }
            else {
                p2 = event.getPoint();
            }
            scene.drawCircle(p1, p2);
        }
        public void mouseReleased(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
    }

    public DrawCircleFrame () {
        scene = new CircleComponent();
        add(scene);
        MouseListener listener = new MousePressListener();
        scene.addMouseListener(listener);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
}