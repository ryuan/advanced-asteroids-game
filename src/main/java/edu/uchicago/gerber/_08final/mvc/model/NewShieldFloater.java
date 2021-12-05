package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class NewShieldFloater extends Sprite {
    private Falcon falcon;

    public NewShieldFloater(Falcon falcon) {
        super();

        this.falcon = falcon;

        setTeam(Team.FLOATER);

        setExpiry(250);
        setRadius(35);

        //set random spin
        setSpin(somePosNegValue(7));

        //random point on the screen
        setCenter(new Point(Game.R.nextInt(Game.DIM.width),
                Game.R.nextInt(Game.DIM.height)));

        //random orientation
        setOrientation(Game.R.nextInt(360));
    }

    @Override
    public void move() {
        super.move();

        if (getExpiry() == 0) {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        } else {
            setOrientation(getOrientation() + getSpin());
            expire();

            int deltaX = falcon.getCenter().x - this.getCenter().x;
            int deltaY = falcon.getCenter().y - this.getCenter().y;

            double radians = Math.atan2(deltaY, deltaX);
            setDeltaX(Math.cos(radians) * 3);
            setDeltaY(Math.sin(radians) * 3);
        }
    }

    public void draw(Graphics g) {
        BufferedImage img = CommandCenter.getInstance().getNewShieldImg();
        drawImage(img, g);
    }
}
