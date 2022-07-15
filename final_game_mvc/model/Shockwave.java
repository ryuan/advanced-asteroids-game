package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;
import edu.uchicago.gerber._08final.mvc.controller.Sound;

import java.awt.*;

public class Shockwave extends MoveAdapter {

    private int mExpiry;
    private Point mCenter;
    private int mRadius;

    public Shockwave(Missile missile) {
        mExpiry = 20;
        mRadius = 10;
        mCenter = missile.getCenter();
        Sound.playSound("shockwave.wav");
    }

    @Override
    public Point getCenter() {
        return mCenter;
    }

    @Override
    public int getRadius() {
        return mRadius;
    }

    @Override
    public Team getTeam() {
        return Team.FRIEND;
    }

    @Override
    public boolean isProtected() {
        return true;
    }

    @Override
    public void move() {
        super.move();

        if (mExpiry > 0) {
            mRadius += 20;
            mExpiry--;
        } else {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        }
    }

    @Override
    public void draw(Graphics g){
        g.setColor(new Color(Game.R.nextInt(256), Game.R.nextInt(256), Game.R.nextInt(256)));
        g.fillOval(mCenter.x - mRadius / 2, mCenter.y - mRadius / 2, mRadius, mRadius);

        super.draw(g);
    }
}
