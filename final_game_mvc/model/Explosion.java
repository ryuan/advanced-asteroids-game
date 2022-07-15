package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends Sprite{
    private int currentExplosionNum;

    public Explosion(Sprite target){
        super();
        setTeam(Team.DEBRIS);
        setDeltaX(0);
        setDeltaY(0);
        setCenter(target.getCenter());
        setOrientation(target.getOrientation());
        currentExplosionNum = 1;
    }

    @Override
    public void draw(Graphics g) {
        BufferedImage img = CommandCenter.getInstance().getExplosion(currentExplosionNum);
        drawImage(img, g);
        currentExplosionNum += 1;
        if (currentExplosionNum >= 5){
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        }
    }
}

