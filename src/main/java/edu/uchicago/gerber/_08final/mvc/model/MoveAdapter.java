package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;

public class MoveAdapter implements Movable {

    @Override
    public void move() {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public Point getCenter() {
        return null;
    }

    @Override
    public int getRadius() {
        return 0;
    }

    @Override
    public Team getTeam() {
        return null;
    }

    @Override
    public boolean isProtected() {
        return false;
    }
}
