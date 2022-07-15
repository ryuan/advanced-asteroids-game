package edu.uchicago.gerber._04interfaces.E9_13;

import java.awt.*;

public class BetterRectangle extends Rectangle {
    /**
     * Creates BetterRectangle object with passed in params
     * @param width     width of the rectangle
     * @param height    height of the rectangle
     */
    public BetterRectangle(int width, int height) {
        super.setLocation(0,0);
        super.setSize(width, height);
    }

    /**
     * Calculates and returns the object's perimeter
     * @return  perimeter of rectangle
     */
    public int getPerimeter() {
        return 2*width + 2*height;
    }

    /**
     * Calculates and returns the object's area
     * @return  area of rectangle
     */
    public int getArea() {
        return width * height;
    }
}
