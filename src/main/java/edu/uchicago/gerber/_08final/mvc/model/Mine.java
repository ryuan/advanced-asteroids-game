package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mine extends Sprite {
    private Falcon falcon;
    private int currentMineNum;

    public Mine(Falcon falcon) {
        super();

        this.falcon = falcon;

        setTeam(Team.FOE);

        setExpiry(250);
        setRadius(5);

        setCenter(new Point(Game.R.nextInt(Game.DIM.width), Game.R.nextInt(Game.DIM.height)));

        setOrientation(Game.R.nextInt(360));

        currentMineNum = 1;
    }

    @Override
    public void move() {
        super.move();

        if (getExpiry() == 0) {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        } else {
            setExpiry(getExpiry() - 1);

            int deltaX = falcon.getCenter().x - this.getCenter().x;
            int deltaY = falcon.getCenter().y - this.getCenter().y;

            double radians = Math.atan2(deltaY, deltaX);
            setDeltaX(Math.cos(radians) * 4);
            setDeltaY(Math.sin(radians) * 4);
        }
    }

    @Override
    public void draw(Graphics g) {
        BufferedImage img = CommandCenter.getInstance().getMine(currentMineNum);
        drawImage(img, g);

        currentMineNum += 1;
        if (currentMineNum >= 4) {
            currentMineNum = 1;
        }
    }
}
