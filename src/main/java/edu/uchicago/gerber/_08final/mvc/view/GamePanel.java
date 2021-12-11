package edu.uchicago.gerber._08final.mvc.view;

import edu.uchicago.gerber._08final.mvc.controller.Game;
import edu.uchicago.gerber._08final.mvc.model.CommandCenter;
import edu.uchicago.gerber._08final.mvc.model.Falcon;
import edu.uchicago.gerber._08final.mvc.model.Missile;
import edu.uchicago.gerber._08final.mvc.model.Movable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;


public class GamePanel extends Panel {
	
	// ==============================================================
	// FIELDS 
	// ============================================================== 
	 
	// The following "off" vars are used for the off-screen double-bufferred image. 
	private Dimension dimOff;
	private Image imgOff;
	private Graphics grpOff;
	
	private GameFrame gmf;
	private Font fnt = new Font("SansSerif", Font.BOLD, 12);
	private Font fntBig = new Font("SansSerif", Font.BOLD + Font.ITALIC, 36);
	private FontMetrics fmt; 
	private int fontWidth;
	private int fontHeight;
	private String strDisplay = "";
	private Image img;
	

	// ==============================================================
	// CONSTRUCTOR 
	// ==============================================================
	
	public GamePanel(Dimension dim) throws IOException {
	    gmf = new GameFrame();
		gmf.getContentPane().add(this);
		gmf.pack();
		initView();
		
		gmf.setSize(dim);
		gmf.setTitle("Game Base");
		gmf.setResizable(false);
		gmf.setVisible(true);
		this.setFocusable(true);

		img = ImageIO.read(CommandCenter.class.getResourceAsStream("/img/planet_opt.jpg"));
	}
	
	
	// ==============================================================
	// METHODS 
	// ==============================================================
	
	private void drawScore(Graphics g) {
		g.setColor(Color.white);
		g.setFont(fnt);
		if (CommandCenter.getInstance().getScore() != 0) {
			g.drawString("SCORE :  " + CommandCenter.getInstance().getScore(), fontWidth, fontHeight);
		} else {
			g.drawString("NO SCORE", fontWidth, fontHeight);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void update(Graphics g) {
		if (grpOff == null || Game.DIM.width != dimOff.width
				|| Game.DIM.height != dimOff.height) {
			dimOff = Game.DIM;
			imgOff = createImage(Game.DIM.width, Game.DIM.height);
			grpOff = imgOff.getGraphics();
		}
		// Fill in background with black.
		grpOff.setColor(Color.black);
//		grpOff.fillRect(0, 0, Game.DIM.width, Game.DIM.height);
		grpOff.drawImage(img,0,0, null);

		drawScore(grpOff);
		
		if (CommandCenter.getInstance().isGameOver()) {
			displayTextOnScreen();
		} else if (CommandCenter.getInstance().isPaused()) {
			strDisplay = "Game Paused";
			grpOff.drawString(strDisplay,
					(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);
		}

		//playing and not paused!
		else {
			iterateMovables(grpOff,
				CommandCenter.getInstance().getMovDebris(),
				CommandCenter.getInstance().getMovFloaters(),
				CommandCenter.getInstance().getMovFoes(),
				CommandCenter.getInstance().getMovFriends());

			drawLevel(grpOff);
			drawNumberMissilesLeft(grpOff);
			drawNumberShipsLeft(grpOff);
		}

		//draw the double-Buffered Image to the graphics context of the panel
		g.drawImage(imgOff, 0, 0, this);
	} 

	
	//for each movable array, process it.
	@SafeVarargs
	private final void iterateMovables(final Graphics g, List<Movable>... arrayOfListMovables){

		BiConsumer<Graphics, Movable> moveDraw = (grp, mov) -> {
			mov.move();
			mov.draw(grp);
		};

		Arrays.stream(arrayOfListMovables)
				.flatMap(Collection::stream)
				.forEach(m -> moveDraw.accept(g, m));
	}


	private void drawLevel(Graphics g) {
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("LEVEL :  " + CommandCenter.getInstance().getLevel(),
				fontWidth, Game.DIM.height - 40);
	}


	private void drawNumberShipsLeft(Graphics g){
		int numFalcons = CommandCenter.getInstance().getNumFalcons();
		while (numFalcons > 0){
			drawOneShipLeft(g, numFalcons--);
		}
	}

	// Draw the number of falcons left on the bottom-right of the screen. Upside-down, but ok.
	private void drawOneShipLeft(Graphics g, int offSet) {
		Falcon falcon = CommandCenter.getInstance().getFalcon();

		g.setColor(Color.white);

		g.drawPolygon(
					Arrays.stream(falcon.getCartesians())
							.map(pnt -> pnt.x + Game.DIM.width - (20 * offSet))
							.mapToInt(Integer::intValue)
							.toArray(),

					Arrays.stream(falcon.getCartesians())
							.map(pnt -> pnt.y + Game.DIM.height - 40)
							.mapToInt(Integer::intValue)
							.toArray(),

					falcon.getCartesians().length);
	}


	private void drawNumberMissilesLeft(Graphics g){
		int numMissiles = CommandCenter.getInstance().getNumMissiles();
		while (numMissiles > 0){
			drawOneMissileLeft(g, numMissiles--);
		}
	}

	// Draw the number of missiles left on the top-right of the screen. Upside-down, but ok.
	private void drawOneMissileLeft(Graphics g, int offSet) {
		Missile missile = new Missile(new Falcon());

		g.setColor(Color.white);

		g.drawPolygon(
				Arrays.stream(missile.getCartesians())
						.map(pnt -> pnt.x + Game.DIM.width - (20 * offSet))
						.mapToInt(Integer::intValue)
						.toArray(),

				Arrays.stream(missile.getCartesians())
						.map(pnt -> pnt.y + 10)
						.mapToInt(Integer::intValue)
						.toArray(),

				missile.getCartesians().length);
	}

	
	private void initView() {
		Graphics g = getGraphics();			// get the graphics context for the panel
		g.setFont(fnt);						// take care of some simple font stuff
		fmt = g.getFontMetrics();
		fontWidth = fmt.getMaxAdvance();
		fontHeight = fmt.getHeight();
		g.setFont(fntBig);					// set font info
	}
	
	// This method draws some text to the middle of the screen before/after a game
	private void displayTextOnScreen() {

		strDisplay = "SAVE US";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4);

		strDisplay = "use the arrow keys to turn and thrust";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ fontHeight + 40);

		strDisplay = "use the space bar to fire";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ fontHeight + 80);

		strDisplay = "'S' to Start";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ fontHeight + 120);

		strDisplay = "'P' to Pause";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ fontHeight + 160);

		strDisplay = "'Q' to Quit";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ fontHeight + 200);

		strDisplay = "left middle finger on 'D' for Hyperspace";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ fontHeight + 240);

		strDisplay = "left pinkie on 'A' to fire shockwave missile";
		grpOff.drawString(strDisplay,
				(Game.DIM.width - fmt.stringWidth(strDisplay)) / 2, Game.DIM.height / 4
						+ fontHeight + 280);
	}
	

}