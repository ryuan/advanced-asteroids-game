package edu.uchicago.gerber._08final.mvc.model;



import edu.uchicago.gerber._08final.mvc.controller.Sound;
import lombok.Data;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//the lombok @Data gives us automatic getters and setters on all members
@Data
public class CommandCenter {

	private  int numFalcons;
	private  int numMissiles;
	private  int level;
	private  long score;
	//the falcon is located in the movFriends list, but since we use this reference a lot, we keep track of it in a
	//separate reference. See spawnFalcon() method below.
	private  Falcon falcon;
	private  boolean paused;

	private ArrayList<BufferedImage> ship1;
	private ArrayList<BufferedImage> ship2;
	private ArrayList<BufferedImage> ship3;
	private ArrayList<BufferedImage> ship4;
	private BufferedImage missile;
	private BufferedImage shield;
	private BufferedImage newShield;
	private BufferedImage upgrade;
	private BufferedImage explosion1;
	private BufferedImage explosion2;
	private BufferedImage explosion3;
	private BufferedImage explosion4;
	private ArrayList<BufferedImage> asteroids0;
	private ArrayList<BufferedImage> asteroids1;
	private ArrayList<BufferedImage> asteroids2;
	private BufferedImage mine1;
	private BufferedImage mine2;
	private BufferedImage mine3;
	private BufferedImage ufo1;
	private BufferedImage ufo2;
	private BufferedImage ufo3;
	private BufferedImage ufo4;

	private List<Movable> movDebris = new LinkedList<>();
	private List<Movable> movFriends = new LinkedList<>();
	private List<Movable> movFoes = new LinkedList<>();
	private List<Movable> movFloaters = new LinkedList<>();

	private GameOpsList opsList = new GameOpsList();


	private static CommandCenter instance = null;

	// Constructor made private
	private CommandCenter() {}

    //this class maintains game state - make this a singleton.
	public static CommandCenter getInstance(){
		if (instance == null){
			instance = new CommandCenter();
		}
		return instance;
	}

	public void initGame(){
		loadGraphics();

		setLevel(0);
		setScore(0);
		setNumFalcons(4);
		setNumMissiles(2);
		spawnFalcon();
	}

	private void loadGraphics() {
		ship1 = new ArrayList<>();
		ship1.add(loadGraphic("ship1_1.png"));
		ship1.add(loadGraphic("ship1_2.png"));
		ship1.add(loadGraphic("ship1_3.png"));
		ship1.add(loadGraphic("ship1_4.png"));

		ship2 = new ArrayList<>();
		ship2.add(loadGraphic("ship2_1.png"));
		ship2.add(loadGraphic("ship2_2.png"));
		ship2.add(loadGraphic("ship2_3.png"));
		ship2.add(loadGraphic("ship2_4.png"));

		ship3 = new ArrayList<>();
		ship3.add(loadGraphic("ship3_1.png"));
		ship3.add(loadGraphic("ship3_2.png"));
		ship3.add(loadGraphic("ship3_3.png"));
		ship3.add(loadGraphic("ship3_4.png"));

		ship4 = new ArrayList<>();
		ship4.add(loadGraphic("ship4_1.png"));
		ship4.add(loadGraphic("ship4_2.png"));
		ship4.add(loadGraphic("ship4_3.png"));
		ship4.add(loadGraphic("ship4_4.png"));

		missile = loadGraphic("missile.png");
		shield = loadGraphic("shield_mod.png");
		newShield = loadGraphic("new_shield.png");
		upgrade = loadGraphic("upgrade.png");

		asteroids0 = new ArrayList<>();
		asteroids0.add(loadGraphic("asteroid1_0.png"));
		asteroids0.add(loadGraphic("asteroid2_0.png"));
		asteroids0.add(loadGraphic("asteroid3_0.png"));
		asteroids0.add(loadGraphic("asteroid4_0.png"));
		asteroids0.add(loadGraphic("asteroid5_0.png"));

		asteroids1 = new ArrayList<>();
		asteroids1.add(loadGraphic("asteroid1_1.png"));
		asteroids1.add(loadGraphic("asteroid2_1.png"));
		asteroids1.add(loadGraphic("asteroid3_1.png"));
		asteroids1.add(loadGraphic("asteroid4_1.png"));
		asteroids1.add(loadGraphic("asteroid5_1.png"));

		asteroids2 = new ArrayList<>();
		asteroids2.add(loadGraphic("asteroid1_2.png"));
		asteroids2.add(loadGraphic("asteroid2_2.png"));
		asteroids2.add(loadGraphic("asteroid3_2.png"));
		asteroids2.add(loadGraphic("asteroid4_2.png"));
		asteroids2.add(loadGraphic("asteroid5_2.png"));

		explosion1 = loadGraphic("explosion1.png");
		explosion2 = loadGraphic("explosion2.png");
		explosion3 = loadGraphic("explosion3.png");
		explosion4 = loadGraphic("explosion4.png");

		mine1 = loadGraphic("mine1.png");
		mine2 = loadGraphic("mine2.png");
		mine3 = loadGraphic("mine3.png");

		ufo1 = loadGraphic("ufo_1.png");
		ufo2 = loadGraphic("ufo_2.png");
		ufo3 = loadGraphic("ufo_3.png");
		ufo4 = loadGraphic("ufo_4.png");
	}

	private BufferedImage loadGraphic(String imgName) {
		BufferedImage img;
		try {
			img = ImageIO.read(CommandCenter.class.getResourceAsStream("/img/" + imgName));
		}
		catch (IOException e) {
			e.printStackTrace();
			img = null;
		}

		return img;
	}

	public BufferedImage getFalconImg(int level, int currentShipNum) {
		if (level == 1) {
			return ship1.get(currentShipNum);
		} else if(level == 2) {
			return ship2.get(currentShipNum);
		} else if(level == 3) {
			return ship3.get(currentShipNum);
		} else {
			return ship4.get(currentShipNum);
		}
	}

	public BufferedImage getMissileImg() { return missile; }
	public BufferedImage getShieldImg() { return shield; }
	public BufferedImage getNewShieldImg() { return newShield; }
	public BufferedImage getUpgradeImg() { return upgrade; }

	public BufferedImage getAsteroid(int asteroidNum, int size) {
		if (size == 0) {
			return asteroids0.get(asteroidNum);
		} else if (size == 1) {
			return asteroids1.get(asteroidNum);
		} else {
			return asteroids2.get(asteroidNum);
		}
	}

	public BufferedImage getExplosion(int explosionNum) {
		switch(explosionNum){
			case 1:
				return explosion1;
			case 2:
				return explosion2;
			case 3:
				return explosion3;
			case 4:
				return explosion4;
			default:
				return null;
		}
	}

	public BufferedImage getMine(int mineNum) {
		switch (mineNum) {
			case 1:
				return mine1;
			case 2:
				return mine2;
			case 3:
				return mine3;
			default:
				return null;
		}
	}

	public BufferedImage getUfo(int ufoNum) {
		switch (ufoNum) {
			case 1:
				return ufo1;
			case 2:
				return ufo2;
			case 3:
				return ufo3;
			case 4:
				return ufo4;
			default:
				return null;
		}
	}

	public  boolean isGameOver() {		//if the number of falcons is zero, then game over
		return getNumFalcons() == 0;
	}

	public  void spawnFalcon() {

		//decrement the number of falcons first
		setNumFalcons(getNumFalcons() - 1);
		if (isGameOver()) return;

		falcon = new Falcon();
		opsList.enqueue(falcon, CollisionOp.Operation.ADD);
		Sound.playSound("shipspawn.wav");

	}

	public  void clearAll(){
		movDebris.clear();
		movFriends.clear();
		movFoes.clear();
		movFloaters.clear();
	}





}
