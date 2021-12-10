package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NewBulletFloater extends Sprite {

    public NewBulletFloater() {

        super();
        setTeam(Team.FLOATER);

        setExpiry(250);
        setRadius(35);

        //set random DeltaX
        setDeltaX(somePosNegValue(10));

        //set random DeltaY
        setDeltaY(somePosNegValue(10));

        //set random spin
        setSpin(somePosNegValue(7));

        //random point on the screen
        setCenter(new Point(Game.R.nextInt(Game.DIM.width),
                Game.R.nextInt(Game.DIM.height)));

        //random orientation
        setOrientation(Game.R.nextInt(360));
    }

    @Override
    public boolean isProtected() {
        return getFade() != 255;
    }

    @Override
    public void move() {
        super.move();

        //a newShipFloater spins
        setOrientation(getOrientation() + getSpin());
        //and it also expires
        expire();
    }

    public void draw(Graphics g) {
        BufferedImage img = CommandCenter.getInstance().getUpgradeImg();
        drawImage(img, g);
    } //end draw()
}
