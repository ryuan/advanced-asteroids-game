package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;

public class NewMissileFloater extends Sprite {
    public static final int FADE_INITIAL_VALUE = 0;

    public NewMissileFloater() {

        super();
        setTeam(Team.FLOATER);

        setExpiry(250);
        setRadius(35);
        setColor(Color.BLACK);

        setFade(FADE_INITIAL_VALUE);

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

        //defined the points on a cartesian grid
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


//        //these are alt points
//        ArrayList<Point> pntAs = new ArrayList<Point>();
//        pntAs.add(new Point(0, 5));
//        pntAs.add(new Point(1, 3));
//        pntAs.add(new Point(1, -2));
//        pntAs.add(new Point(-1, -2));
//        pntAs.add(new Point(-1, 3));
//
//        setCartesians(pntAs);
    }

    @Override
    public boolean isProtected() {
        return getFade() != 255;
    }

    @Override
    public void move() {
        super.move();

        if (isProtected()) {
            setFade(getFade() + 3);
        }

        //a newShipFloater spins
        setOrientation(getOrientation() + getSpin());
        //and it also expires
        expire();
    }

    private int adjustColor(int colorNum, int adjust) {
        return Math.max(colorNum - adjust, 0);
    }

    public void draw(Graphics g) {
        Color colShip;
        if (getFade() == 245) {
            colShip = Color.MAGENTA;
        } else {
            colShip = new Color(
                    adjustColor(getFade(), 180), //red
                    adjustColor(getFade(), 75), //green
                    getFade() //blue
            );
        }

        draw(g,colShip);
    } //end draw()
}

