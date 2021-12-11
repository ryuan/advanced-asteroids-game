package edu.uchicago.gerber._08final.mvc.controller;

import edu.uchicago.gerber._08final.mvc.model.*;
import edu.uchicago.gerber._08final.mvc.view.GamePanel;


import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

// ===============================================
// == This Game class is the CONTROLLER
// ===============================================

public class Game implements Runnable, KeyListener {

	// ===============================================
	// FIELDS
	// ===============================================

	public static final Dimension DIM = new Dimension(1100, 700); //the dimension of the game.
	private GamePanel gmpPanel;
	//this is used throughout many classes.
	public static Random R = new Random();

	public final static int ANI_DELAY = 50; // milliseconds between screen
											// updates (animation)

	public final static int FRAMES_PER_SECOND = 1000 / ANI_DELAY;

	private Thread animationThread;
	private int level = 1;


	private boolean muted = true;
	

	private final int PAUSE = 80, // p key
			QUIT = 81, // q key
			LEFT = 37, // rotate left; left arrow
			RIGHT = 39, // rotate right; right arrow
			UP = 38, // thrust; up arrow
			START = 83, // s key
			FIRE = 32, // space key
			MUTE = 77, // m-key mute
			HYPER = 68, // d key
 			MISSILE = 65; // a key arrow

	// for possible future use
	// NUM_ENTER = 10, 				// hyp
	// SPECIAL = 70; 					// fire special weapon;  F key

	private Clip clpThrust;
	private Clip clpMusicBackground;

	//spawn every 30 seconds
	private static final int SPAWN_NEW_SHIP_FLOATER = FRAMES_PER_SECOND * 25;
	private static final int SPAWN_NEW_SHIELD_FLOATER = FRAMES_PER_SECOND * 15;
	private static final int SPAWN_NEW_BULLET_FLOATER = FRAMES_PER_SECOND * 20;
	private static final int SPAWN_NEW_MISSILE_FLOATER = FRAMES_PER_SECOND * 10;
	private static final int SPAWN_MINE = FRAMES_PER_SECOND * 20;
	private static final int SPAWN_UFO = FRAMES_PER_SECOND * 30;



	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================

	public Game() throws IOException {

		gmpPanel = new GamePanel(DIM);
		gmpPanel.addKeyListener(this);
		clpThrust = Sound.clipForLoopFactory("whitenoise.wav");
		clpMusicBackground = Sound.clipForLoopFactory("music-background.wav");
	

	}

	// ===============================================
	// ==METHODS
	// ===============================================

	public static void main(String args[]) {
		//typical Swing application main method
		EventQueue.invokeLater(new Runnable() { // uses the Event dispatch thread from Java 5 (refactored)
					public void run() {
						try {
							Game game = new Game(); // construct itself
							game.fireUpAnimThread();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

	private void fireUpAnimThread() { // called initially
		if (animationThread == null) {
			animationThread = new Thread(this); // pass the thread a runnable object (this)
			animationThread.start();
		}
	}

	// implements runnable - must have run method
	public void run() {

		// lower this thread's priority; let the "main" aka 'Event Dispatch'
		// thread do what it needs to do first
		animationThread.setPriority(Thread.MIN_PRIORITY);

		// and get the current time
		long lStartTime = System.currentTimeMillis();

		// this thread animates the scene
		while (Thread.currentThread() == animationThread) {

			gmpPanel.update(gmpPanel.getGraphics()); // see GamePanel class
			checkCollisions();
			checkNewLevel();
			spawnNewShipFloater();
			spawnNewShieldFloater();
			spawnNewBulletFloater();
			spawnNewMissileFloater();
			spawnMine();
			spawnUfo();

			// surround the sleep() in a try/catch block
			// this simply controls delay time between
			// the frames of the animation
			try {
				// The total amount of time is guaranteed to be at least ANI_DELAY long.  If processing (update) 
				// between frames takes longer than ANI_DELAY, then the difference between lStartTime - 
				// System.currentTimeMillis() will be negative, then zero will be the sleep time
				lStartTime += ANI_DELAY;

				Thread.sleep(Math.max(0,
						lStartTime - System.currentTimeMillis()));
			} catch (InterruptedException e) {
				// do nothing (bury the exception), and just continue, e.g. skip this frame -- no big deal
			}
		} // end while
	} // end run

	private void checkCollisions() {

		Point pntFriendCenter, pntFoeCenter;
		int radFriend, radFoe;

		//This has order-of-growth of O(n^2), there is no way around this.
		for (Movable movFriend : CommandCenter.getInstance().getMovFriends()) {
			for (Movable movFoe : CommandCenter.getInstance().getMovFoes()) {

				pntFriendCenter = movFriend.getCenter();
				pntFoeCenter = movFoe.getCenter();
				radFriend = movFriend.getRadius();
				radFoe = movFoe.getRadius();

				Sprite sprFoe = (Sprite) movFoe;

				//detect collision
				if (pntFriendCenter.distance(pntFoeCenter) < (radFriend + radFoe)) {
					//remove the friend (so long as he is not protected)
					if (!movFriend.isProtected()) {
						if (movFriend instanceof Missile) {
							CommandCenter.getInstance().getOpsList().enqueue(new Shockwave((Missile) movFriend), CollisionOp.Operation.ADD);
						}
						CommandCenter.getInstance().getOpsList().enqueue(movFriend, CollisionOp.Operation.REMOVE);
					}
					//remove the foe
					CommandCenter.getInstance().getOpsList().enqueue(movFoe, CollisionOp.Operation.REMOVE);
					Sound.playSound("kapow.wav");

					CommandCenter.getInstance().getOpsList().enqueue(new Explosion(sprFoe), CollisionOp.Operation.ADD);
					CommandCenter.getInstance().setScore(CommandCenter.getInstance().getScore() + sprFoe.getSpriteScore());

			 	}

			}//end if
		}//end inner for

		//check for collisions between falcon and floaters
		if (CommandCenter.getInstance().getFalcon() != null){

			Point pntFalCenter = CommandCenter.getInstance().getFalcon().getCenter();
			int radFalcon = CommandCenter.getInstance().getFalcon().getRadius();

			Point pntFloaterCenter;
			int radFloater;
			for (Movable movFloater : CommandCenter.getInstance().getMovFloaters()) {
				pntFloaterCenter = movFloater.getCenter();
				radFloater = movFloater.getRadius();
	
				//detect collision
				if (pntFalCenter.distance(pntFloaterCenter) < (radFalcon + radFloater)) {

					CommandCenter.getInstance().getOpsList().enqueue(movFloater, CollisionOp.Operation.REMOVE);
					Sound.playSound("pacman_eatghost.wav");

					if (movFloater instanceof NewShipFloater) {
						CommandCenter.getInstance().setNumFalcons(CommandCenter.getInstance().getNumFalcons() + 1);
					} else if (movFloater instanceof NewMissileFloater) {
						CommandCenter.getInstance().setNumMissiles(CommandCenter.getInstance().getNumMissiles() + 1);
					} else if (movFloater instanceof NewShieldFloater) {
						CommandCenter.getInstance().getFalcon().setFade(Falcon.FADE_INITIAL_VALUE);
						Sound.playSound("shieldup.wav");
					} else if (movFloater instanceof NewBulletFloater) {
						CommandCenter.getInstance().getFalcon().setBulletType(CommandCenter.getInstance().getFalcon().getBulletType() + 1);
						Sound.playSound("anchor_action.wav");
					}

				}//end if 
			}//end inner for
		}//end if not null

		processGameOpsQueue();

	}//end meth

	private void processGameOpsQueue() {

		//deferred mutation: these operations are done AFTER we have completed our collision detection to avoid
		// mutating the movable linkedlists while iterating them above
		while(!CommandCenter.getInstance().getOpsList().isEmpty()){
			CollisionOp cop =  CommandCenter.getInstance().getOpsList().dequeue();
			Movable mov = cop.getMovable();
			CollisionOp.Operation operation = cop.getOperation();

			switch (mov.getTeam()){
				case FOE:
					if (operation == CollisionOp.Operation.ADD){
						CommandCenter.getInstance().getMovFoes().add(mov);
					} else {
						CommandCenter.getInstance().getMovFoes().remove(mov);
						if (mov instanceof Asteroid)
							spawnSmallerAsteroids((Asteroid) mov);
					}

					break;
				case FRIEND:
					if (operation == CollisionOp.Operation.ADD){
						CommandCenter.getInstance().getMovFriends().add(mov);
					} else {
						CommandCenter.getInstance().getMovFriends().remove(mov);
						if (mov instanceof Falcon)
							CommandCenter.getInstance().spawnFalcon();
					}
					break;

				case FLOATER:
					if (operation == CollisionOp.Operation.ADD){
						CommandCenter.getInstance().getMovFloaters().add(mov);
					} else {
						CommandCenter.getInstance().getMovFloaters().remove(mov);
					}
					break;

				case DEBRIS:
					if (operation == CollisionOp.Operation.ADD){
						CommandCenter.getInstance().getMovDebris().add(mov);
					} else {
						CommandCenter.getInstance().getMovDebris().remove(mov);
					}
					break;


			}

		}
	}


	private void spawnSmallerAsteroids(Asteroid originalAsteroid) {

			//big asteroid 
			if(originalAsteroid.getSize() == 0){
				//spawn two medium Asteroids
				CommandCenter.getInstance().getOpsList().enqueue(new Asteroid(originalAsteroid), CollisionOp.Operation.ADD);
				CommandCenter.getInstance().getOpsList().enqueue(new Asteroid(originalAsteroid), CollisionOp.Operation.ADD);

			} 
			//medium size aseroid exploded
			else if(originalAsteroid.getSize() == 1){
				//spawn three small Asteroids
				CommandCenter.getInstance().getOpsList().enqueue(new Asteroid(originalAsteroid), CollisionOp.Operation.ADD);
				CommandCenter.getInstance().getOpsList().enqueue(new Asteroid(originalAsteroid), CollisionOp.Operation.ADD);
				CommandCenter.getInstance().getOpsList().enqueue(new Asteroid(originalAsteroid), CollisionOp.Operation.ADD);

			}

			//if it's a small asteroid, do nothing.
	}

	private void spawnNewShipFloater() {

		//appears more often as your level increses.
		if ((System.currentTimeMillis() / ANI_DELAY) % (SPAWN_NEW_SHIP_FLOATER - level * 7L) == 0) {
			CommandCenter.getInstance().getOpsList().enqueue(new NewShipFloater(), CollisionOp.Operation.ADD);
		}
	}

	private void spawnNewShieldFloater() {

		//appears more often as your level increses.
		if ((System.currentTimeMillis() / ANI_DELAY) % (SPAWN_NEW_SHIELD_FLOATER - level * 7L) == 0) {
			CommandCenter.getInstance().getOpsList().enqueue(new NewShieldFloater(CommandCenter.getInstance().getFalcon()), CollisionOp.Operation.ADD);
		}
	}

	private void spawnNewBulletFloater() {

		//appears more often as your level increses.
		if ((System.currentTimeMillis() / ANI_DELAY) % (SPAWN_NEW_BULLET_FLOATER - level * 8L) == 0) {
			CommandCenter.getInstance().getOpsList().enqueue(new NewBulletFloater(), CollisionOp.Operation.ADD);
		}
	}

	private void spawnNewMissileFloater() {

		//appears more often as your level increses.
		if ((System.currentTimeMillis() / ANI_DELAY) % (SPAWN_NEW_MISSILE_FLOATER - level * 7L) == 0) {
			CommandCenter.getInstance().getOpsList().enqueue(new NewMissileFloater(), CollisionOp.Operation.ADD);
		}
	}

	private void spawnMine() {

		//appears more often as your level increses.
		if ((System.currentTimeMillis() / ANI_DELAY) % (SPAWN_MINE - level * 7L) == 0) {
			CommandCenter.getInstance().getOpsList().enqueue(new Mine(CommandCenter.getInstance().getFalcon()), CollisionOp.Operation.ADD);
		}
	}

	private void spawnUfo() {

		//appears more often as your level increses.
		if ((System.currentTimeMillis() / ANI_DELAY) % (SPAWN_MINE - level * 8L) == 0) {
			CommandCenter.getInstance().getOpsList().enqueue(new Ufo(CommandCenter.getInstance().getFalcon()), CollisionOp.Operation.ADD);
		}
	}

	// Called when user presses 's'
	private void startGame() {
		CommandCenter.getInstance().clearAll();
//		CommandCenter.getInstance().setLevel(0);
		CommandCenter.getInstance().initGame();
		CommandCenter.getInstance().setPaused(false);

	}

	//this method spawns new asteroids
	private void spawnBigAsteroids(int nNum) {
		while(nNum-- > 0) {
			//Asteroids with size of zero are big
			CommandCenter.getInstance().getOpsList().enqueue(new Asteroid(0), CollisionOp.Operation.ADD);

		}
	}

	public void shootBullets(Falcon fal, int bulletLevel) {
		int oriFal = CommandCenter.getInstance().getFalcon().getOrientation();
		int range;
		if (bulletLevel == 1) {
			range = 0;
		} else if (bulletLevel == 2) {
			range = 5;
		} else if (bulletLevel == 3) {
			range = 10;
		} else {
			range = 25;
		}

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = -range; i <= range; i+=5) {
			if (oriFal + i > 359) {
				arr.add(oriFal + i - 360);
			} else if (oriFal + i < 0) {
				arr.add(oriFal + i + 360);
			} else {
				arr.add(oriFal + i);
			}
		}

		for (int orientation : arr) {
			CommandCenter.getInstance().getOpsList().enqueue(new Bullet(fal, orientation), CollisionOp.Operation.ADD);
		}
	}

	private boolean isLevelClear(){
		//if there are no more Asteroids on the screen
		boolean asteroidFree = true;
		for (Movable movFoe : CommandCenter.getInstance().getMovFoes()) {
			if (movFoe instanceof Asteroid){
				asteroidFree = false;
				break;
			}
		}
		return asteroidFree;
	}
	
	private void checkNewLevel(){

		if (isLevelClear() && CommandCenter.getInstance().getFalcon() != null) {
			//more asteroids at each level to increase difficulty
			spawnBigAsteroids(CommandCenter.getInstance().getLevel() + 1);
			CommandCenter.getInstance().setLevel(CommandCenter.getInstance().getLevel() + 1);
			this.level++;
			CommandCenter.getInstance().getFalcon().setFade(Falcon.FADE_INITIAL_VALUE);

		}
	}
	
	
	

	// Varargs for stopping looping-music-clips
	private static void stopLoopingSounds(Clip... clpClips) {
		for (Clip clp : clpClips) {
			clp.stop();
		}
	}

	// ===============================================
	// KEYLISTENER METHODS
	// ===============================================

	@Override
	public void keyPressed(KeyEvent e) {
		Falcon fal = CommandCenter.getInstance().getFalcon();
		int nKey = e.getKeyCode();

		if (nKey == START && CommandCenter.getInstance().isGameOver())
			startGame();

		if (fal != null) {

			switch (nKey) {
			case PAUSE:
				CommandCenter.getInstance().setPaused(!CommandCenter.getInstance().isPaused());
				if (CommandCenter.getInstance().isPaused())
					stopLoopingSounds(clpMusicBackground, clpThrust);
				break;
			case QUIT:
				System.exit(0);
				break;
			case UP:
				fal.thrustOn();
				if (!CommandCenter.getInstance().isPaused() && !CommandCenter.getInstance().isGameOver())
					clpThrust.loop(Clip.LOOP_CONTINUOUSLY);
				break;
			case LEFT:
				fal.rotateLeft();
				break;
			case RIGHT:
				fal.rotateRight();
				break;

			// possible future use
			// case KILL:
			// case NUM_ENTER:

			default:
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Falcon fal = CommandCenter.getInstance().getFalcon();
		int nKey = e.getKeyCode();
		//show the key-code in the console
		 System.out.println(nKey);

		if (fal != null) {
			switch (nKey) {
			case FIRE:
				shootBullets(fal, CommandCenter.getInstance().getFalcon().getBulletType());
				Sound.playSound("laser.wav");
				break;

			case MISSILE:
				if (CommandCenter.getInstance().getNumMissiles() > 0) {
					CommandCenter.getInstance().getOpsList().enqueue(new Missile(fal), CollisionOp.Operation.ADD);
					CommandCenter.getInstance().setNumMissiles(CommandCenter.getInstance().getNumMissiles() - 1);
					Sound.playSound("missile.wav");
				} else {
					Sound.playSound("outofammo.wav");
				}

				break;

			case LEFT:
				fal.stopRotating();
				break;
			case RIGHT:
				fal.stopRotating();
				break;
			case UP:
				fal.thrustOff();
				clpThrust.stop();
				break;
				
			case MUTE:
				if (!muted){
					stopLoopingSounds(clpMusicBackground);
				} 
				else {
					clpMusicBackground.loop(Clip.LOOP_CONTINUOUSLY);
				}
				muted = !muted;
				break;

			case HYPER:
				Point randPoint = new Point(Game.R.nextInt(Game.DIM.width), Game.R.nextInt(Game.DIM.height));
				CommandCenter.getInstance().getFalcon().setCenter(randPoint);
				Sound.playSound("warp.wav");
				break;
				
			default:
				break;
			}
		}
	}

	@Override
	// does nothing, but we need it b/c of KeyListener contract
	public void keyTyped(KeyEvent e) {
	}

}


