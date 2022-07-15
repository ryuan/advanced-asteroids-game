package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ufo extends Sprite {
    private Falcon falcon;
    private int currentUfoNum;

    public Ufo(Falcon falcon) {
        super();

        this.falcon = falcon;

        setTeam(Team.FOE);

        setExpiry(250);
        setRadius(25);
        setSpin(somePosNegValue(10));

        setCenter(new Point(Game.R.nextInt(Game.DIM.width), Game.R.nextInt(Game.DIM.height)));

        setOrientation(Game.R.nextInt(360));

        currentUfoNum = 1;
    }

    @Override
    public void move() {
        super.move();

        if (getExpiry() == 0) {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        } else {
            expire();

            int deltaX = falcon.getCenter().x - this.getCenter().x;
            int deltaY = falcon.getCenter().y - this.getCenter().y;

            double radians = Math.atan2(deltaY, deltaX);
            setDeltaX(Math.cos(radians) * 7);
            setDeltaY(Math.sin(radians) * 7);
        }
    }

    @Override
    public void draw(Graphics g) {
        BufferedImage img = CommandCenter.getInstance().getUfo(currentUfoNum);
        drawImage(img, g);

        currentUfoNum += 1;
        if (currentUfoNum > 4) {
            currentUfoNum = 1;
        }
    }
}
