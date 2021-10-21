package edu.uchicago.gerber._04interfaces.E9_13;

import java.awt.*;

public class BetterRectangle extends Rectangle {
    public BetterRectangle(int width, int height) {
        super.setLocation(0,0);
        super.setSize(width, height);
    }

    public int getPerimeter() {
        return 2*width + 2*height;
    }

    public int getArea() {
        return width * height;
    }
}
