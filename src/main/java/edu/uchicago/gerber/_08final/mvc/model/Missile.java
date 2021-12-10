package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Missile extends Sprite {

    private final double FIRE_POWER = 15.0;
    private final int MAX_EXPIRE = 25;

    public Missile(Falcon fal) {

        super();
        setTeam(Team.FRIEND);

        //a cruis missile expires after 25 frames
        setExpiry(MAX_EXPIRE);
        setRadius(50);

        //everything is relative to the falcon ship that fired the bullet
        setDeltaX(fal.getDeltaX()
                + Math.cos(Math.toRadians(fal.getOrientation())) * FIRE_POWER);
        setDeltaY(fal.getDeltaY()
                + Math.sin(Math.toRadians(fal.getOrientation())) * FIRE_POWER);
        setCenter(fal.getCenter());

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(fal.getOrientation());

        //defined the points on a cartesean grid
        ArrayList<Point> pntCs = new ArrayList<Point>();


        pntCs.add(new Point(0, 5));
        pntCs.add(new Point(1, 3));
        pntCs.add(new Point(1, 0));
        pntCs.add(new Point(6, 0));
        pntCs.add(new Point(6, -1));
        pntCs.add(new Point(1, -1));
        pntCs.add(new Point(1, -2));

        pntCs.add(new Point(-1, -2));
        pntCs.add(new Point(-1, -1));
        pntCs.add(new Point(-6, -1));
        pntCs.add(new Point(-6, 0));
        pntCs.add(new Point(-1, 0));
        pntCs.add(new Point(-1, 3));

        setCartesians(pntCs);
    }

    @Override
    public void move() {
        super.move();

        if (getExpiry() < MAX_EXPIRE -5){
            setDeltaX(getDeltaX() * 1.07);
            setDeltaY(getDeltaY() * 1.07);
        }
        expire();
    }

    @Override
    public void draw(Graphics g){
        BufferedImage img = CommandCenter.getInstance().getMissileImg();
        drawImage(img, g);
    }


}
