package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewShipFloater extends Sprite {
	public static final int FADE_INITIAL_VALUE = 0;

	public NewShipFloater() {

		super();
		setTeam(Team.FLOATER);

		setExpiry(250);
		setRadius(35);
		setColor(Color.GREEN);

		setFade(FADE_INITIAL_VALUE);

		//set random DeltaX
		setDeltaX(somePosNegValue(10));

		//set rnadom DeltaY
		setDeltaY(somePosNegValue(10));
		
		//set random spin
		setSpin(somePosNegValue(10));

		//random point on the screen
		setCenter(new Point(Game.R.nextInt(Game.DIM.width),
				Game.R.nextInt(Game.DIM.height)));

		//random orientation 
		setOrientation(Game.R.nextInt(360));

		//be sure to set cartesian points last.
		List<Point> pntCs = new ArrayList<>();
		// Robert Alef's awesome falcon design
		pntCs.add(new Point(0,9));
		pntCs.add(new Point(-1, 6));
		pntCs.add(new Point(-1,3));
		pntCs.add(new Point(-4, 1));
		pntCs.add(new Point(4,1));
		pntCs.add(new Point(-4,1));

		pntCs.add(new Point(-4, -2));
		pntCs.add(new Point(-1, -2));
		pntCs.add(new Point(-1, -9));
		pntCs.add(new Point(-1, -2));
		pntCs.add(new Point(-4, -2));

		pntCs.add(new Point(-10, -8));
		pntCs.add(new Point(-5, -9));
		pntCs.add(new Point(-7, -11));
		pntCs.add(new Point(-4, -11));
		pntCs.add(new Point(-2, -9));
		pntCs.add(new Point(-2, -10));
		pntCs.add(new Point(-1, -10));
		pntCs.add(new Point(-1, -9));
		pntCs.add(new Point(1, -9));
		pntCs.add(new Point(1, -10));
		pntCs.add(new Point(2, -10));
		pntCs.add(new Point(2, -9));
		pntCs.add(new Point(4, -11));
		pntCs.add(new Point(7, -11));
		pntCs.add(new Point(5, -9));
		pntCs.add(new Point(10, -8));
		pntCs.add(new Point(4, -2));

		pntCs.add(new Point(1, -2));
		pntCs.add(new Point(1, -9));
		pntCs.add(new Point(1, -2));
		pntCs.add(new Point(4,-2));

		pntCs.add(new Point(4, 1));
		pntCs.add(new Point(1, 3));
		pntCs.add(new Point(1,6));
		pntCs.add(new Point(0,9));

		setCartesians(pntCs);
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
		if (getFade() == 215) {
			colShip = Color.green;
		} else {
			colShip = new Color(
					adjustColor(getFade(), 100), //red
					getFade(), //green
					adjustColor(getFade(), 80) //blue
			);
		}

		draw(g,colShip);
	} //end draw()


}
